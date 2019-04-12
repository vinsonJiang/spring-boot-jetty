package io.vinson.server.shutdown.tomcat;

import io.vinson.server.shutdown.jetty.JettyGracefulShutdown;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.jetty.JettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

/**
 * @author: jiangweixin
 * @date: 2019/4/12
 */
public class TomcatShutdownConfig {

    @Bean
    public TomcatGracefulShutdown gracefulShutdown(@Value("${server.shutdown-timeout:30s}")Duration timeout) {
        return new TomcatGracefulShutdown(timeout);
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatReactiveWebServerFactory> jettyCustomizer(TomcatGracefulShutdown server) {
        return factory -> factory.addConnectorCustomizers(server);
    }
}
