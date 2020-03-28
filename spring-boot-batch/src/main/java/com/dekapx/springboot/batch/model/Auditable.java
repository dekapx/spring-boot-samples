package com.dekapx.springboot.batch.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    protected Long id;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false, updatable = true)
    protected Date createdDate;

    @CreatedBy
    @Column(name = "CREATED_BY")
    protected U createdBy;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name = "LAST_MODIFIED_DATE", nullable = false, updatable = true)
    protected Date lastModifiedDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    protected U lastModifiedBy;
}
