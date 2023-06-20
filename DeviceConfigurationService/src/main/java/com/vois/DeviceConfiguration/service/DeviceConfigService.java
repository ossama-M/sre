package com.vois.DeviceConfiguration.service;

import com.vois.clients.constant.ResponseCodes;
import com.vois.clients.inventoryClient.client.InventoryClient;
import com.vois.clients.inventoryClient.dto.DeviceDto;
import com.vois.clients.utils.DeviceList;
import com.vois.clients.inventoryClient.dto.DeviceStatus;
import com.vois.clients.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeviceConfigService {

    private final InventoryClient inventoryClient ;

    public Response configDevicesService(){
        log.info("calling inventory service to get unConfig device");
        DeviceList deviceList =  inventoryClient.callAvaliableDeviceToConfig();
        List<DeviceDto> devices  =  deviceList.getDevices();
        log.info("we loaded unConfig devices ....... wait until config ");
        devices.forEach(device ->{device.getDeviceConfig().setDeviceStatus(DeviceStatus.ACTIVE);
            Random rand = new Random();
            device.getDeviceConfig().setTemperature(rand.nextInt(10));
        });
        deviceList.setDevices(devices);
        log.info("Hala....... we configured your devices .... let save in db {}",deviceList);
        inventoryClient.callSaveConfiguredDevicesApi(deviceList);
        return new Response(ResponseCodes.DEVICE_CONFIGURED_SUCCESSFULLY);
    }

}
