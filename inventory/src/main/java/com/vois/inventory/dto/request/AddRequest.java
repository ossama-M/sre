package com.vois.inventory.dto.request;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class AddRequest {
    private String serial;
    private String vendor ;

}
