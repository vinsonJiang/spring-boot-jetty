package io.vinson.server.shutdown.tomcat;

import io.vinson.server.shutdown.GracefulShutdown;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.event.ContextClosedEvent;
import org.apache.catalina.connector.Connector;

import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: jiangweixin
 * @date: 2019/4/11
 */
public class TomcatGracefulShutdown extends GracefulShutdown implements TomcatConnectorCustomizer {
    private static final Logger logger = LoggerFactory.getLogger(TomcatGracefulShutdown.class);

    private volatile Connector connector;

    public TomcatGracefulShutdown(Duration timeout) {
        super(timeout);
    }

    @Override
    protected void gracefulShutdown(ContextClosedEvent event, Duration timeout) throws Exception {
        Executor executor = this.connector.getProtocolHandler().getExecutor();
        if (executor instanceof ThreadPoolExecutor) {
            try {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                threadPoolExecutor.shutdown();
                if (!threadPoolExecutor.awaitTermination(timeout.getSeconds(), TimeUnit.SECONDS)) {
                    logger.warn("Tomcat 30s 内没有关闭，被强制关闭");
                }
            }
            catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void customize(Connector connector) {
        this.connector = connector;
    }
}
