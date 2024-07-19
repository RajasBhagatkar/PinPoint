package com.pinpoint.PinPoint.repository;

import com.pinpoint.PinPoint.entity.Pincode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PincodeRepository extends JpaRepository<Pincode, Long> {

}
