package main.java.com.barlocator.server;

import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.dm.Item;
import main.java.com.barlocator.dm.Menu;
import main.java.com.barlocator.service.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {
    private ServerSocket server;
    private boolean serverOn = true;
    private ExecutorService executorService = Executors.newCachedThreadPool();
    public Server(int port) throws IOException {
        this.server = new ServerSocket(port);
    }
    public void run(){
        while(serverOn){
            Socket client = null;
            try {
                client = server.accept();
                System.out.println("A new client has registered");
                executorService.execute(new HandleRequest(client, new Controller <Bar, Menu, Item,String> ()));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
