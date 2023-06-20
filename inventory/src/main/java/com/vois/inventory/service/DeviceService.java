package com.vois.inventory.service;

import com.vois.clients.utils.DeviceList;
import com.vois.inventory.dto.request.AddRequest;
import com.vois.inventory.dto.request.UpdateRequest;
import com.vois.clients.utils.Response;

public interface DeviceService {
    Response addDevice(AddRequest addRequest);
    Response deleteDevice(Integer id );
    Response updateDevice(UpdateRequest updateRequest);

    void saveConfiguredDevices(DeviceList deviceList);
}
