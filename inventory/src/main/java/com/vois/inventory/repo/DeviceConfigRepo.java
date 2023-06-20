package com.vois.inventory.repo;

import com.vois.inventory.model.DeviceConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceConfigRepo extends JpaRepository<DeviceConfig,Integer> {

    Integer countDeviceConfigByDeviceStatus_Ready();
    Integer countDeviceConfigByDeviceStatus_Active();
    List<DeviceConfig> findDeviceConfigByDeviceStatus_Active();
    List<DeviceConfig> findDeviceConfigByDeviceStatus_Ready();



}
