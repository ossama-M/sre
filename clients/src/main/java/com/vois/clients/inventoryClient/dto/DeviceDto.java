package com.vois.clients.inventoryClient.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class DeviceDto implements Comparable<DeviceDto>{

    private Integer id ;
    private String serial;
    private String vendor ;
    private DeviceConfigDto deviceConfig;

    @Override
    public int compareTo(DeviceDto o) {
        if (this.deviceConfig.getPinCode() != o.getDeviceConfig().getPinCode()) {
            return this.deviceConfig.getPinCode() - o.getDeviceConfig().getPinCode();
        }
        return this.deviceConfig.getDeviceStatus().compareTo(o.getDeviceConfig().getDeviceStatus());
    }
}
