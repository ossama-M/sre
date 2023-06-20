package com.vois.clients.inventoryClient.dto;

import lombok.*;
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class DeviceConfigDto {

    private Integer temperature ;
    private Integer pinCode ;
    private DeviceStatus deviceStatus ;

}
