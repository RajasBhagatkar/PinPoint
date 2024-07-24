package com.pinpoint.PinPoint.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locality_info")
public class LocalityInfoEntity extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    private Long pincode;
    private String locality;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "state_info")
    private StateInfoEntity stateInfo;


}
