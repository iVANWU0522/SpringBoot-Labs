package com.ivan.springboot.lab47.ivanserver.autoconfigure;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;

@Configuration
@EnableConfigurationProperties(IvanServerProperties.class)
public class IvanServerAutoConfiguration {
    private Logger logger = LoggerFactory.getLogger(IvanServerAutoConfiguration.class);

    @Bean
    @ConditionalOnClass(HttpServer.class)
    public HttpServer httpServer(IvanServerProperties serverProperties) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(serverProperties.getPort()), 0);
        httpServer.start();
        logger.info("[httpServer][started on port {}]", serverProperties.getPort());
        return httpServer;
    }
}
