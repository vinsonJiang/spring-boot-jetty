package io.vinson.server.init;

import io.vinson.server.websocket.WebSocketServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: jiangweixin
 * @date: 2019/4/7
 */
@Component
@Order(1)
public class WebSocketApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        WebSocketServer.start();
    }
}
