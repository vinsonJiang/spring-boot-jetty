package io.vinson.server.shutdown;

import io.vinson.server.shutdown.jetty.JettyShutdownConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: jiangweixin
 * @date: 2019/4/10
 */
@Configuration
@ConditionalOnWebApplication
public class GracefulShutdownAutoConfig {

    @Configuration
    @ConditionalOnClass(name="org.eclipse.jetty.server.Server")
    @Import(JettyShutdownConfig.class)
    static class Jetty {

    }
}
