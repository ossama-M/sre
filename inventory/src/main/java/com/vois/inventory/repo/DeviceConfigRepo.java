package com.vois.inventory.repo;

import com.vois.clients.inventoryClient.dto.DeviceStatus;
import com.vois.inventory.model.DeviceConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceConfigRepo extends JpaRepository<DeviceConfig,Integer> {

    Integer countDeviceConfigByDeviceStatus(DeviceStatus deviceStatus);
    List<DeviceConfig> findDeviceConfigByDeviceStatus(DeviceStatus deviceStatus);




}
