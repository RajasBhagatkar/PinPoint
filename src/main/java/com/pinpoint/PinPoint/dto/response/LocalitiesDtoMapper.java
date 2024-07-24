package com.pinpoint.PinPoint.dto.response;

import com.pinpoint.PinPoint.entity.LocalityInfoEntity;
import com.pinpoint.PinPoint.mapper.Mapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocalitiesDtoMapper implements Mapper<LocalityInfoEntity, LocalitiesDto> {
    private final ModelMapper modelMapper;

    @Override
    public LocalitiesDto mapTo(LocalityInfoEntity localityInfoEntity) {
        return modelMapper.map(localityInfoEntity, LocalitiesDto.class);
    }

    @Override
    public LocalityInfoEntity mapFrom(LocalitiesDto localitiesDto) {
        return modelMapper.map(localitiesDto, LocalityInfoEntity.class);
    }
}
