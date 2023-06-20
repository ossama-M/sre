package com.vois.inventory.repo;

import com.vois.clients.inventoryClient.dto.DeviceStatus;
import com.vois.inventory.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepo extends JpaRepository<Device,Integer> {
    List<Device> getDeviceByDeviceConfig_DeviceStatus(DeviceStatus deviceStatus);
    Optional<Device>findById(int id );

}
