package com.pinpoint.PinPoint.services;

import com.pinpoint.PinPoint.entity.StateInfoEntity;

import java.util.List;

public interface StateService {
    StateInfoEntity getStateInfoByPincode(Integer pincode);

    List<String> getAllDistrictByStateName(String stateName);

    String getDistrictOfPincode(Integer pincode);

    String getStateOfPincode(Integer pincode);
}
