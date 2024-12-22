package org.gfg;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerDemo  {

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost",9000),0);

        //for /hello path use this handler
        httpServer.createContext("/hello",new HelloHandler());
        httpServer.start();


    }
}
