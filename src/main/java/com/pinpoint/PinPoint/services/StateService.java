package com.pinpoint.PinPoint.services;

import com.pinpoint.PinPoint.entity.StateInfoEntity;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface StateService {
    StateInfoEntity getStateInfoByPincode(Integer pincode);

    List<String> getAllDistrictByStateName(String stateName);
}
