package main.java.util;

import com.google.gson.Gson;
import main.java.com.barlocator.dm.Bar;
import main.java.com.barlocator.server.Body;
import main.java.com.barlocator.server.BodyBuilder;
import main.java.com.barlocator.server.Header;
import main.java.com.barlocator.server.Request;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException {
        Socket myServer = new Socket("localhost",3000);
        PrintWriter output=new PrintWriter(myServer.getOutputStream());
        Scanner input=new Scanner(myServer.getInputStream());
        Request req = new Request(new Header("POST"), new BodyBuilder().type("bar").bar(new Bar("testBar","just a test")).build());
        Gson gson = new Gson();
        String sun = gson.toJson(req);
        output.write(gson.toJson(req));

    }
}
