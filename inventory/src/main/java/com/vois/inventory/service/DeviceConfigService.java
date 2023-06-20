package com.vois.inventory.service;

import com.vois.clients.inventoryClient.dto.DeviceList;
import com.vois.inventory.dto.request.UpdatePinRequest;
import com.vois.clients.utils.Response;

public interface DeviceConfigService {

    Integer getUnConfigDeviceCount();
    Integer getConfigDeviceConfigCount();
    void sendNotificationToConfig();

    boolean checkAvailabToConfig();
    DeviceList getConfigDevices();
    Response ChangePin(UpdatePinRequest updatePinRequest);
    DeviceList getUnConfigDevices();

}
