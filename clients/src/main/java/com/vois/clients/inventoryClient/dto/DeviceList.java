package com.vois.clients.inventoryClient.dto;


import com.vois.clients.inventoryClient.dto.DeviceDto;
import com.vois.clients.utils.Response;
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
