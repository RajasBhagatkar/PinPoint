package com.pinpoint.PinPoint.repository;

import com.pinpoint.PinPoint.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {
}
