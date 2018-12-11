/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 *
 * @author Tomáš
 */
public class RP {

    static int port = 9000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("server started at " + port);
        server.createContext("/Form", (HttpHandler) new FormGiver());
        server.createContext("/Register", (HttpHandler) new RegisterHandler());
        server.createContext("/Game", (HttpHandler) new GameHandler());
        server.setExecutor(null);
        server.start();

    }

}
