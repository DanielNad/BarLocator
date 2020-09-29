package main.java.com.barlocator.server;

import com.google.gson.Gson;
import main.java.com.barlocator.service.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HandleRequest implements Runnable {
    private Socket client;
    private Request req;
    private Response res;
    private Scanner in;
    private PrintWriter out;
    private Gson gson;
    private Controller controller;

    public HandleRequest(Socket client,Controller controller ) {
        this.client = client;
        this.controller = controller;
        try {
            in = new Scanner(client.getInputStream());
            out = new PrintWriter(client.getOutputStream());
            gson = new Gson();
            String clientRequest = "";
            while (in.hasNextLine()) {
                clientRequest = clientRequest + in.nextLine();
            }
            req = gson.fromJson(clientRequest,Request.class);
            in.close();
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

    private void execute(boolean status){
        if (status) {
            res.setBody(new BodyBuilder().status("ok").build());
        } else {
            res.setBody(new BodyBuilder().status("error").build());
        }
    }

    private void handleGet(){
        switch (req.getBody().getType()){
            case "graph" :
                execute(controller.readAll());
                break;
            default :
                break;
        }
        handleStatus();
    }

    private void handlePost(){
        switch (req.getBody().getType()){
            case "bar" :
                execute(controller.write(req.getBody().getBar()));
                break;
            case "menu" :
                execute(controller.write(req.getBody().getBar(),req.getBody().getMenu()));
                break;
            case "item" :
                execute(controller.write(req.getBody().getBar(),req.getBody().getMenu(),req.getBody().getItem()));
                break;
            case "edge" :
                execute(controller.addEdge(req.getBody().getBar().getBarName(),req.getBody().getBarTo(),req.getBody().getWeight()));
                break;
        }
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
                    execute(controller.remove(req.getBody().getBarName(),req.getBody().getMenu()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "item" :
                execute(controller.remove(req.getBody().getBarName(),req.getBody().getMenu(),req.getBody().getItem()));
                break;
            case "graph" :
                try {
                    execute(controller.removeAll());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
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
        int [] distance;
        switch (req.getBody().getType()){
            case "dijkstra" :
                controller.setAlgo(true);
                distance = controller.calculateDistance(controller.getGraph(),req.getBody().getI());
                res.getBody().setType("dijkstra");
                res.getBody().setDistance(distance);
                break;
            case "basic" :
                controller.setAlgo(false);
                distance = controller.calculateDistance(controller.getGraph(),req.getBody().getI());
                res.getBody().setType("basic");
                res.getBody().setDistance(distance);
                break;
            case "graph" :
                res.getBody().setType("graph");
                res.getBody().setType("graph");
                res.getBody().setGraph(controller.getGraph());
                break;
            default:
                break;
        }
        response();
    }

    private void response(){
        out.write(gson.toJson(res));
        out.flush();
        out.close();
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
