package com.vois.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.vois.clients"
)
public class InventoryService {
    public static void main(String[] args) {
        SpringApplication.run(InventoryService.class,args);
    }
}