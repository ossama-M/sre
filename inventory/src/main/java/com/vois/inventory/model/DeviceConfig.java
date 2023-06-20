package com.vois.inventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vois.clients.inventoryClient.dto.DeviceStatus;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter @Builder
@Entity @Table
public class DeviceConfig {
    @Id
    @SequenceGenerator(
            name = "device_config_id_sequence",
            sequenceName = "device_config_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "device_config_id_sequence"

    )
    private Integer id;

    private Integer temperature ;
    @Audited
    @Column(name ="pin_code",length = 7,columnDefinition = "number(7) NOT NULL")
    private Integer pinCode ;
    @Enumerated(EnumType.STRING)
    private DeviceStatus deviceStatus ;
    @OneToOne
    @JsonBackReference
    private Device device;


}
