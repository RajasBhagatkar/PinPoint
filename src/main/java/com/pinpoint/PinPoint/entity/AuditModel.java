package com.pinpoint.PinPoint.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AuditModel implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false, nullable = true)
    @CreatedDate
    private Date createdDate ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date", nullable = true)
    @LastModifiedDate
    private Date updatedDate;
}
