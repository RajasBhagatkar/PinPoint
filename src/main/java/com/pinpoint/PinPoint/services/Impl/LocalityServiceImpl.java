package com.pinpoint.PinPoint.services.Impl;

import com.pinpoint.PinPoint.dto.response.LocalitiesDto;
import com.pinpoint.PinPoint.entity.LocalityInfoEntity;
import com.pinpoint.PinPoint.mapper.Mapper;
import com.pinpoint.PinPoint.repository.LocalityInfoRepository;
import com.pinpoint.PinPoint.services.PincodeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalityServiceImpl implements PincodeService {
    private final LocalityInfoRepository localityRepository;

    private final Mapper<LocalityInfoEntity, LocalitiesDto>  localityDtoMapper;
    Logger logger = LoggerFactory.getLogger(LocalityServiceImpl.class);


    @Override
    public List<LocalitiesDto> getLocalitiesFromPincode(Integer pincode) {
        List<LocalityInfoEntity> allLocalities = localityRepository.findByPincode(pincode).orElse(null);
        if (allLocalities == null) {
            // throw Exception Data Not found
        }

        List<LocalitiesDto> result = new ArrayList<>();

        for(LocalityInfoEntity locality: allLocalities){
            result.add(localityDtoMapper.mapTo(locality));
        }

        return result;
    }



    public String testService() {
        return "Working....";
    }

}
