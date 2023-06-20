package com.vois.inventory.service;

import com.vois.clients.configurationServiceClient.client.ConfigurationServiceClient;
import com.vois.clients.constant.ResponseCodes;
import com.vois.clients.inventoryClient.dto.DeviceConfigDto;
import com.vois.clients.inventoryClient.dto.DeviceDto;
import com.vois.clients.inventoryClient.dto.DeviceList;
import com.vois.inventory.dto.request.AddRequest;
import com.vois.inventory.dto.request.UpdatePinRequest;
import com.vois.inventory.dto.request.UpdateRequest;
import com.vois.clients.utils.Response;
import com.vois.inventory.model.Device;
import com.vois.inventory.model.DeviceConfig;
import com.vois.clients.inventoryClient.dto.DeviceStatus;
import com.vois.inventory.repo.DeviceConfigRepo;
import com.vois.inventory.repo.DeviceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DeviceInventoryServiceImpl implements DeviceConfigService,DeviceService{

    private final DeviceRepo deviceRepo ;
    private final DeviceConfigRepo configRepo;
    private final ConfigurationServiceClient configClient ;
    @Override
    public Integer getUnConfigDeviceCount() {

        return configRepo.countDeviceConfigByDeviceStatus(DeviceStatus.READY);

    }

    @Override
    public Integer getConfigDeviceConfigCount() {
       return configRepo.countDeviceConfigByDeviceStatus(DeviceStatus.ACTIVE);

    }

    @Override

    public void sendNotificationToConfig() {

        DeviceList deviceList = (DeviceList) configClient.fireConfig();
        deviceList.getDevices().forEach(
                deviceDto -> {

                    Device device = deviceRepo.findById(deviceDto.getId()).get();
                    DeviceConfig deviceConfig = DeviceConfig.builder().deviceStatus(deviceDto.getDeviceConfig().getDeviceStatus()).
                            temperature(deviceDto.getDeviceConfig().getTemperature())
                            .build();
                    device.setDeviceConfig(deviceConfig);
                    deviceRepo.save(device);
                });

    }

    @Override
    public boolean checkAvailabToConfig() {
        long totalDevice = configRepo.count();
        return getUnConfigDeviceCount()< Math.ceil( totalDevice/2);
    }

    @Override
    public DeviceList getConfigDevices() {
        List<Device> devices = deviceRepo.getDeviceByDeviceConfig_DeviceStatus(DeviceStatus.ACTIVE);
        DeviceList deviceList  = deviceListBuilder(devices);
        return deviceList;
    }



    @Override
    public Response ChangePin(UpdatePinRequest updatePinRequest) {

        Device device = deviceRepo.findById(updatePinRequest.getId()).orElse(Device.builder().build());
        if(device.getId() == 0)
            return new Response(ResponseCodes.DEVICE_ID_NOT_EXIST);

        device.getDeviceConfig().setPinCode(updatePinRequest.getPin());
        return new Response(ResponseCodes.PIN_UPDATED);
    }



    @Override
    public DeviceList getUnConfigDevices() {
        List<Device> devices = deviceRepo.getDeviceByDeviceConfig_DeviceStatus(DeviceStatus.READY);
        DeviceList deviceList  = deviceListBuilder(devices);
        return deviceList ;
    }

    @Override
    public Response addDevice(AddRequest addRequest) {
        Random random = new Random();
        int pinCode = 1000000 +random.nextInt(9000000);
        Device device = Device.builder().vendor(addRequest.getVendor()).
                serial(addRequest.getSerial()).deviceConfig(DeviceConfig.builder().pinCode(pinCode).deviceStatus(DeviceStatus.READY).temperature(1).build()).
                build();
         deviceRepo.save(device);
        return new Response(ResponseCodes.CREATED);
    }

    @Override
    public Response deleteDevice(Integer id) {

         deviceRepo.deleteById(id);
         return new Response(ResponseCodes.DELETED);
    }

    @Override
    public Response updateDevice(UpdateRequest updateRequest) {
        Device device = deviceRepo.findById(updateRequest.getId()).orElse(Device.builder().build());
        if(device.getId() == 0)
            return new Response(ResponseCodes.DEVICE_ID_NOT_EXIST);
        device.setSerial(updateRequest.getSerial());
        device.setVendor(updateRequest.getVendor());
        device.getDeviceConfig().setPinCode(updateRequest.getPin());
        return new Response(ResponseCodes.PIN_UPDATED);

    }

    private DeviceList deviceListBuilder(List<Device> devices) {
        DeviceList deviceList = new DeviceList();
        List<DeviceDto> deviceObjectTemp = new ArrayList<>();
         devices.forEach(device ->{
            DeviceConfigDto deviceConfigDto = DeviceConfigDto.builder().
                    deviceStatus(device.getDeviceConfig().getDeviceStatus()).
                    pinCode(device.getDeviceConfig().getPinCode()).
                    temperature(device.getDeviceConfig().getTemperature()).
                    build();

            DeviceDto deviceDto = DeviceDto.builder().id(device.getId()).
                    deviceConfig(deviceConfigDto).
                    serial(device.getSerial()).
                    vendor(device.getVendor()).
                    build();
             deviceObjectTemp.add(deviceDto);
        });
         Collections.sort(deviceObjectTemp);
        deviceList.setDevices(deviceObjectTemp);
        deviceList.setResponseCode(ResponseCodes.SUCCESS);
        return deviceList;
    }
}
