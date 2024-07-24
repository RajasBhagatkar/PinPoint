package com.pinpoint.PinPoint.repository;

import com.pinpoint.PinPoint.entity.StateInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateInfoRepository extends JpaRepository<StateInfoEntity, String> {
    Optional<StateInfoEntity> findByPincode(Integer pincode);
    @Query("SELECT DISTINCT si.district FROM StateInfoEntity si WHERE si.state = :state ORDER BY district ASC")
    Optional<List<String>> findDistinctDistrictByState(String state);
}
