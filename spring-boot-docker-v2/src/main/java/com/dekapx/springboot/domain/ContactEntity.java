package com.dekapx.springboot.domain;

import com.dekapx.springboot.annotation.AuditField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "CONTACT")
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class ContactEntity extends BaseEntity {
    private static final Logger LOGGER  = LoggerFactory.getLogger(ContactEntity.class);

    @AuditField
    @Column(name = "FIRST_NAME")
    private String firstName;

    @AuditField
    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<AddressEntity> address = new ArrayList<>();

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @PrePersist
    public void onPrePersist() {
        LOGGER.info("onPrePersist..........................");
    }

    @PreUpdate
    public void onPreUpdate() {
        LOGGER.info("onPreUpdate..........................");
    }

    @PreRemove
    public void onPreRemove() {
        LOGGER.info("onPreRemove..........................");
    }
}
