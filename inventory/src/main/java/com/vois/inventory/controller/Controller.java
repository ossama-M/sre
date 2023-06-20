package com.vois.inventory.controller;

import com.vois.clients.constant.ResponseCodes;
import com.vois.inventory.dto.request.AddRequest;
import com.vois.inventory.dto.request.UpdateRequest;
import com.vois.clients.utils.Response;
import com.vois.inventory.service.DeviceInventoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/inventory")
public class Controller {
    private final DeviceInventoryServiceImpl deviceInventoryService ;

    @PostMapping("/add-device")
    public @ResponseBody Response addDevice(@RequestBody AddRequest addRequest) {
        return deviceInventoryService.addDevice(addRequest);
    }

    @PutMapping("/udpate-device")
    public @ResponseBody Response updateDevice(@RequestBody UpdateRequest updateRequest) {
        return deviceInventoryService.updateDevice(updateRequest);
    }

    @GetMapping("/get-unconfig-device")
    public @ResponseBody Response getUnConfigDevice(){
        return deviceInventoryService.getUnConfigDevices();
    }

    @GetMapping("/get-config-device")
    public @ResponseBody Response getConfigDevice(){
        return deviceInventoryService.getConfigDevices();
    }

    @GetMapping("/check-availability-to-config")
    public @ResponseBody Response checkAvailabilityToConfig(){
        if(deviceInventoryService.checkAvailabToConfig()) {
            deviceInventoryService.sendNotificationToConfig();
            return new Response(ResponseCodes.WE_HAVE_DEVICE_TO_CONFIG);
        }
        return new Response(ResponseCodes.THERE_IS_NO_DEVICE_TO_CONFIG);
    }

}
