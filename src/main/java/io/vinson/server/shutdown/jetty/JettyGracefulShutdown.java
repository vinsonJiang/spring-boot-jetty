package io.vinson.server.shutdown.jetty;

import io.vinson.server.shutdown.GracefulShutdown;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.event.ContextClosedEvent;

import java.time.Duration;

/**
 * @author: jiangweixin
 * @date: 2019/4/9
 */
public class JettyGracefulShutdown extends GracefulShutdown implements JettyServerCustomizer {

    private volatile Server server;

    public JettyGracefulShutdown(Duration timeout) {
        super(timeout);
    }

    /**
     * TODO:
     * @param event
     * @param timeout
     * @throws Exception
     */
    @Override
    protected void gracefulShutdown(ContextClosedEvent event, Duration timeout) throws Exception {
        server.stop();
        ThreadPool threadPool = server.getThreadPool();
    }

    @Override
    public void customize(Server server) {
        this.server = server;
    }
}
