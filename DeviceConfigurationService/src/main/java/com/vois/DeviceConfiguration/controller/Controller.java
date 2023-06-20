package com.vois.DeviceConfiguration.controller;

import com.vois.DeviceConfiguration.service.DeviceConfigService;
import com.vois.clients.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/device-config")
@RequiredArgsConstructor
public class Controller {

    private final DeviceConfigService deviceConfigService ;

    @GetMapping("/fire-config")
     public @ResponseBody Response fireConfig(){
        return deviceConfigService.configDevicesService();
    }
}
