package com.ivan.springboot.lab47.ivanserver.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ivan.server")
public class IvanServerProperties {

    private static final Integer DefaultPort = 8000;

    private Integer port = DefaultPort;

    public static Integer getDefaultPort() {
        return DefaultPort;
    }

    public Integer getPort() {
        return port;
    }

    public IvanServerProperties setPort(Integer port) {
        this.port = port;
        return this;
    }
}