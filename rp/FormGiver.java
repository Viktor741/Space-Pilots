/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Tomáš
 */
public class FormGiver implements HttpHandler {

    @Override
    public void handle(HttpExchange he) throws IOException {
        String response = ("<body><div><h1>Space Pilots</h1>"
                + "<form name='loginForm' method='handle' action='Register'>Username: "
                + "<input type='text' name='username' />"
                + " <br /><input type='submit' value='Register'/></form></div></body>");
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
