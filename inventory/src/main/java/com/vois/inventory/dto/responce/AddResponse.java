package com.vois.inventory.dto.responce;

import com.vois.clients.utils.Response;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class AddResponse extends Response {
    private String serial;
    private String manufactureCompany ;

    public AddResponse(int responseCode, String serial, String manufactureCompany) {
        super(responseCode);
        this.serial = serial;
        this.manufactureCompany = manufactureCompany;
    }
}
