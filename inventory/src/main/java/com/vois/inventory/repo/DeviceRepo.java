package com.vois.inventory.repo;

import com.vois.clients.inventoryClient.dto.DeviceStatus;
import com.vois.inventory.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface DeviceRepo extends JpaRepository<Device,Integer> {
    List<Device> getDeviceByDeviceConfig_DeviceStatus(DeviceStatus deviceStatus);
    Optional<Device>findById(int id );
    @Query(value = "delete from device d where d.id =:id",nativeQuery = true)
    @Modifying
    @Transactional
    void deleteDeviceBy(@Param("id") int id);

}
