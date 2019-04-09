package io.vinson.server.shutdown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @author: jiangweixin
 * @date: 2019/4/9
 */
public abstract class GracefulShutdown implements ApplicationListener<ContextClosedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(GracefulShutdown.class);

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        gracefulShutdown();
    }

    protected abstract void gracefulShutdown();
}
