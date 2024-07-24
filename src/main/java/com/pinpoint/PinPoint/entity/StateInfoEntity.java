package com.pinpoint.PinPoint.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="state_info")
public class StateInfoEntity extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    private String state;
    private String division;
    private String circleName;
    private String regionName;
    private String district;
    private Long pincode;

}
