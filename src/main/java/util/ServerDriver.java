package main.java.util;

import main.java.com.barlocator.server.Server;

import java.io.IOException;

public class ServerDriver {
    public static void main(String[] args) throws IOException {
        Server server = new Server(3000);
        server.run();
    }
}
