package io.vinson.server.websocket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;
import java.util.concurrent.Future;

/**
 * @Description:
 * @author: jiangweixin
 * @date: 2019/4/7
 */
public class MyWebSocketClient {

    public static void main(String[] args) {
        URI uri = URI.create("ws://localhost:" + WebSocketServer.PORT + "/ws/");
        WebSocketClient client = new WebSocketClient();

        try {
            client.start();
            WebSocketHandler socketHandler = new WebSocketHandler();
            Future<Session> sessionFuture = client.connect(socketHandler, uri);
            Session session = sessionFuture.get();
            session.getRemote().sendString("hello server");
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
