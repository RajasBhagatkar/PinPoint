package com.pinpoint.PinPoint.services;

import com.pinpoint.PinPoint.dto.response.LocalitiesDto;
import com.pinpoint.PinPoint.entity.LocalityInfoEntity;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PincodeService {
    List<LocalitiesDto> getLocalitiesFromPincode(Integer pincode);
}
