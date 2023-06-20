package com.vois.DeviceConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.vois.clients"
)
public class DeviceConfigurationService {
    public static void main(String[] args) {
        SpringApplication.run(DeviceConfigurationService.class,args);
    }
}