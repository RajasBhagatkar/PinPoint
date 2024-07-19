package com.pinpoint.PinPoint.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pincode")
public class Pincode extends AuditModel{
    @Id
    @GeneratedValue
    private Long Id;

    private String circleName;
    private String regionName;
    private String divisionName;
    // office name is the locality
    private Integer pincode;

    private String district;
    private String state;

    private Double latitude;
    private Double longitude;
}
