package com.vois.clients.utils;


import com.vois.clients.inventoryClient.dto.DeviceDto;
import lombok.*;

import java.util.List;
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class DeviceList extends Response {
    private List<DeviceDto> devices  ;
    public DeviceList(int responseCode, List<DeviceDto> devices) {
        super(responseCode);
        this.devices = devices;
    }
}
