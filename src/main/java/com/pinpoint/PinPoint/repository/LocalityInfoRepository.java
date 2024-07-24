package com.pinpoint.PinPoint.repository;

import com.pinpoint.PinPoint.entity.LocalityInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocalityInfoRepository extends JpaRepository<LocalityInfoEntity, String> {
    Optional<List<LocalityInfoEntity>> findByPincode(Integer pincode);
}
