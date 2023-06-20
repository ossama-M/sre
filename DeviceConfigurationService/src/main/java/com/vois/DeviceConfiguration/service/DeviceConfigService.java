package com.vois.DeviceConfiguration.service;

import com.vois.clients.inventoryClient.client.InventoryClient;
import com.vois.clients.inventoryClient.dto.DeviceDto;
import com.vois.clients.inventoryClient.dto.DeviceList;
import com.vois.clients.inventoryClient.dto.DeviceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class DeviceConfigService {

    private final InventoryClient inventoryClient ;

    public DeviceList configDevicesService(){
        DeviceList deviceList = (DeviceList) inventoryClient.callAvaliableDeviceToConfig();
        List<DeviceDto> devices  =  deviceList.getDevices();

        devices.forEach(device ->{device.getDeviceConfig().setDeviceStatus(DeviceStatus.ACTIVE);
            Random rand = new Random();
            device.getDeviceConfig().setTemperature(rand.nextInt(10));
        });
        deviceList.setDevices(devices);

        return deviceList;
    }

}
