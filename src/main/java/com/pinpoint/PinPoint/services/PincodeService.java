package com.pinpoint.PinPoint.services;

import com.pinpoint.PinPoint.dto.response.LocalitiesDto;

import java.util.List;

public interface PincodeService {
    List<LocalitiesDto> getLocalitiesFromPincode(Integer pincode);

    boolean verifyPincodeExists(Integer pincode);
}
