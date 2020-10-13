package main.java.com.barlocator.server;

import com.google.gson.Gson;
import main.java.com.barlocator.dm.DistanceDict;
import main.java.com.barlocator.service.Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

public class HandleRequest implements Runnable {
    private Socket client;
    private Request req;
    private Response res;
    private DataInputStream in;
    private DataOutputStream out;
    private Gson gson;
    private Controller controller;
    private List<DistanceDict> distance;

    public HandleRequest(Socket client,Controller controller ) {
        this.client = client;
        this.controller = controller;
        this.res = new Response(new Body());
        try {
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
            gson = new Gson();
            String messageFromClient = "";
            messageFromClient = in.readUTF();
            req = gson.fromJson(messageFromClient,Request.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        switch (req.getHeader().getAction()){
            case "GET":
                handleGet();
                break;
            case "POST" :
                handlePost();
                break;
            case "DELETE" :
                handleDelete();
                break;
            default:
                handleResponse();
                break;
        }
    }

    private void handleGet(){
        switch (req.getBody().getType()){
            case "graph" :
                execute(controller.readAll());
                break;
            case "dijkstra" :
                controller.setAlgo(true);
                distance = controller.calculateDistance(controller.getGraph(),req.getBody().getI());
                break;
            case "basic" :
                controller.setAlgo(false);
                distance = controller.calculateDistance(controller.getGraph(),req.getBody().getI());
                break;
            default :
                break;
        }
        if(req.getBody().getType().equals("dijkstra") || req.getBody().getType().equals("basic")){
            if (distance != null) {
                execute(true);
            } else {
                execute(false);
            }
        }
        handleStatus();
    }

    private void handlePost(){
        switch (req.getBody().getType()){
            case "bar" :
                execute(controller.write(req.getBody().getBar()));
                break;
            case "menu" :
                execute(controller.write(req.getBody().getBarName(),req.getBody().getMenu()));
                break;
            case "item" :
                execute(controller.write(req.getBody().getBarName(),req.getBody().getMenuName(),req.getBody().getItem()));
                break;
            case "edge" :
                execute(controller.addEdge(req.getBody().getBarName(),req.getBody().getBarTo(),req.getBody().getWeight()));
                break;
        }
        handleStatus();
    }

    private void handleDelete(){
        switch (req.getBody().getType()){
            case "bar" :
                try {
                    execute(controller.remove(req.getBody().getBarName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "menu" :
                try {
                    execute(controller.remove(req.getBody().getBarName(),req.getBody().getMenuName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "item" :
                execute(controller.remove(req.getBody().getBarName(),req.getBody().getMenuName(),req.getBody().getItemName()));
                break;
            case "graph" :
                try {
                    execute(controller.removeAll());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
        handleStatus();
    }

    private void execute(boolean status){
        if (status) {
            res.setBody(new BodyBuilder().status("ok").build());
        } else {
            res.setBody(new BodyBuilder().status("error").build());
        }
    }

    private void handleStatus(){
        switch (res.getBody().getStatus()) {
            case "ok" :
                handleResponse();
                break;
            default:
                response();
                break;
        }
    }

    private void handleResponse(){
        switch (req.getBody().getType()){
            case "dijkstra" :
                res.getBody().setType("dijkstra");
                res.getBody().setDistance(distance);
                break;
            case "basic" :
                res.getBody().setType("basic");
                res.getBody().setDistance(distance);
                break;
            case "graph" :
                res.getBody().setType("graph");
                res.getBody().setGraph(controller.getGraph());
                break;
            default:
                break;
        }
        response();
    }

    private void response(){
        try {
            out.writeUTF(gson.toJson(res));
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
