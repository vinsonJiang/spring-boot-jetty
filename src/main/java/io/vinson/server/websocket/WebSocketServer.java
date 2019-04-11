package io.vinson.server.websocket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * 启动一个websocket服务器
 *
 * @author: jiangweixin
 * @date: 2019/4/7
 */
public class WebSocketServer {

    public static final int PORT = 8082;

    public static void start() {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(PORT);
        server.addConnector(connector);

        ServletContextHandler contextHandler = new ServletContextHandler();

        contextHandler.setContextPath("/");
        server.setHandler(contextHandler);

        ServletHolder holder = new ServletHolder("ws", WebSocketConfig.class);
        contextHandler.addServlet(holder, "/ws/*");
        try {
            server.start();
            server.dump(System.err);
            server.join();
            System.out.println("jetty websocket started on ws://127.0.0.1:" + PORT + '/');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start();
    }
}
