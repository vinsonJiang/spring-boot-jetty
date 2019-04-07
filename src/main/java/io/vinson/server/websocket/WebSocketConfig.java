package io.vinson.server.websocket;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * @Description:
 * @author: jiangweixin
 * @date: 2019/4/7
 */
public class WebSocketConfig extends WebSocketServlet {
    @Override
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.register(WebSocketHandler.class);
    }
}
