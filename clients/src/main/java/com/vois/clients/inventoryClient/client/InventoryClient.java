package com.vois.clients.inventoryClient.client;

import com.vois.clients.utils.DeviceList;
import com.vois.clients.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("inventory")
public interface InventoryClient {
    @GetMapping("api/v1/inventory/unconfig-device")
    public @ResponseBody DeviceList callAvaliableDeviceToConfig();
    @PostMapping("api/v1/inventory/save-config-devices")
    Response callSaveConfiguredDevicesApi(@RequestBody DeviceList deviceList);
}
