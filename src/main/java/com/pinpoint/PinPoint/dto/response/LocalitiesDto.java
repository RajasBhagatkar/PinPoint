package com.pinpoint.PinPoint.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocalitiesDto {
    private Integer pincode;
    private String locality;
    private String state;
    private Double latitude;
    private Double longitude;
}
