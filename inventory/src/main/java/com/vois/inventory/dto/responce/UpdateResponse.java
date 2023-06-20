package com.vois.inventory.dto.responce;

import com.vois.clients.utils.Response;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class UpdateResponse extends Response {
    private String serial;
    private String manufactureCompany ;
    private String pin ;

    public UpdateResponse(int responseCode , String serial, String manufactureCompany, String pin) {
        super(responseCode);
        this.serial = serial;
        this.manufactureCompany = manufactureCompany;
        this.pin = pin;
    }
}
