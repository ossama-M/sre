package com.vois.inventory.dto.request;

import com.vois.clients.constant.ResponseCodes;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class UpdateRequest {
    @NotNull
    private Integer id ;
    @NotNull
    private String serial;
    @NotNull
    private String vendor ;
    @Pattern(regexp="[\\d]{7}",message = ResponseCodes.PIN_PROPERTIES)
    private String pin ;

}
