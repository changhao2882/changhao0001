package com.atguigu.springboot08actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthAggregator;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class MyAppHealthIndicator implements HealthAggregator {


    @Override
    public Health aggregate(Map<String, Health> healths) {

        //return Health.up().build();  代表健康
        return Health.down().withDetail("msg","服务异常").build();
    }
}
