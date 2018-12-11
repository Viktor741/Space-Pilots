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
import java.net.URI;

/**
 *
 * @author Tomáš
 */
public class GameHandler implements HttpHandler{

  @Override
    public void handle(HttpExchange he) throws IOException {
        URI uri = he.getRequestURI();
        String response1 = "<body><div>";
        String response2 = createResponseFromQueryParams(uri);
        String response3 = "</div></body>";

        String response = response1.concat(response2.concat(response3));
        System.out.println("Response: " + response);
        //Set the response header status and length
        he.sendResponseHeaders(200, response.getBytes().length);
        //Write the response string
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());

        os.close();
    }

    private String createResponseFromQueryParams(URI uri) {
        String username = "";
        //Get the request query
        String query = uri.getQuery();
        username = query.substring(16, query.length());

        return "Hello, " + username;

    }

    
}
