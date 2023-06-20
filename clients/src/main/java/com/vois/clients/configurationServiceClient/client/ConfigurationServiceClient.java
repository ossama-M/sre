package com.vois.clients.configurationServiceClient.client;

import com.vois.clients.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("device-configuration-service")
public interface ConfigurationServiceClient {

    @GetMapping("/api/v1/device-config/fire-config")
    public @ResponseBody Response fireConfig();

}
