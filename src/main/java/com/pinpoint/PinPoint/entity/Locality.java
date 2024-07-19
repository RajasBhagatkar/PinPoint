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
@Table(name = "locality")
public class Locality extends AuditModel {
    @Id
    @GeneratedValue
    private Long Id;
    private Integer pincode;
    private String locality;
}
