package com.vois.clients.inventoryClient.client;

import com.vois.clients.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("inventory")
public interface InventoryClient {
    @GetMapping("api/v1/inventory/get-unconfig-device")
    public @ResponseBody Response callAvaliableDeviceToConfig();

}
