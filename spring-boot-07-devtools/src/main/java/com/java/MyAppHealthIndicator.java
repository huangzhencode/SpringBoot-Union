package com.java;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author huangzhen
 * @create 2020-03-22 14:06
 */
@Component
public class MyAppHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.down().withDetail("msg", "down").build();
    }
}
