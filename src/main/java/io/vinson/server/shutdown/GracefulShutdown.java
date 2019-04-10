package io.vinson.server.shutdown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import java.time.Duration;

/**
 * @author: jiangweixin
 * @date: 2019/4/9
 */
public abstract class GracefulShutdown implements ApplicationListener<ContextClosedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(GracefulShutdown.class);

    private Duration timeout;

    protected GracefulShutdown(Duration timeout) {
        this.timeout = timeout;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        try {
            gracefulShutdown(event, timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void gracefulShutdown(ContextClosedEvent event, Duration timeout) throws Exception;
}
