package com.ganxy03.bbs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
    private String host;
    private int port;
}
