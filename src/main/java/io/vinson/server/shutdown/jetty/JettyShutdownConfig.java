package io.vinson.server.shutdown.jetty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.jetty.JettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

/**
 * @author: jiangweixin
 * @date: 2019/4/10
 */
public class JettyShutdownConfig {

    @Bean
    public JettyGracefulShutdown gracefulShutdown(@Value("${server.shutdown-timeout:30s}")Duration timeout) {
        return new JettyGracefulShutdown(timeout);
    }

    @Bean
    public WebServerFactoryCustomizer<JettyReactiveWebServerFactory> jettyCustomizer(JettyGracefulShutdown server) {
        return factory -> factory.addServerCustomizers(server);
    }
}
