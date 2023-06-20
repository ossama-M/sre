package com.vois.inventory.repo;

import com.vois.inventory.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepo extends JpaRepository<Device,Integer> {

    List<Device> getDeviceByDeviceConfig_DeviceStatus_Active();
    List<Device> getDeviceByDeviceConfig_DeviceStatus_Ready();

    Optional<Device>findById(int id );

}
