package com.vois.inventory.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
@Entity @Table
public class Device {
    @Id
    @SequenceGenerator(
            name ="device_id_sequence",
            sequenceName = "device_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "device_id_sequence"
    )
    private Integer id ;
    private String serial;
    private String vendor ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private DeviceConfig deviceConfig ;

}
