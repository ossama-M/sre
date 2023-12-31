package com.vois.inventory.dto.request;

import com.vois.clients.constant.ResponseCodes;
import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class UpdatePinRequest {
    private Integer Id ;
    @NotNull(message = ResponseCodes.PIN_NOT_NULL)
//    @Pattern(regexp="[\\d]{7}")
    @Digits(integer =7,fraction = 0,message = ResponseCodes.PIN_PROPERTIES)
    private Integer pin  ;
}
