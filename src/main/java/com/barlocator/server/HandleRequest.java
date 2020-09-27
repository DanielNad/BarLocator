package main.java.com.barlocator.server;

import com.google.gson.Gson;
import main.java.com.barlocator.service.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class HandleRequest implements Runnable {
    private Request req;
    private Response res;
    private Gson gson;
    private Controller controller;

    public HandleRequest(Socket client,Controller controller ) {
        Scanner input;
        this.controller = controller;
        try {
            input = new Scanner(client.getInputStream());
            gson = new Gson();
            String messageFromServer="";
            while (input.hasNextLine()) {
                messageFromServer =messageFromServer + input.nextLine();
            }
            req = gson.fromJson(messageFromServer,Request.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handlePost(){
        switch (req.getBody().getType()){
            case "bar" :
                controller.write(req.getBody().getBar());
                break;
            case "menu" :
                break;
            case "item" :
                break;
        }
    }

    @Override
    public void run() {
        switch (req.getHeaders().getAction()){
            case "GET" :
                break;
            case "POST" :
                handlePost();
                break;
            case "DELETE" :
                break;
            default:
                break;
        }
    }
}
