package com.exercises.usermanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "phone")
@Getter
@Setter
public class Phone implements Serializable {
    @Id
    @GeneratedValue()
    private UUID id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false, name = "city_code")
    private String cityCode;

    @Column(nullable = false, name = "country_code")
    private String countryCode;

    @Column(nullable = false, name = "created_at")
    private Date createdAt;

    @Column(nullable = false, name = "updated_at")
    private Date updatedAt;

    public Phone(){}

    public Phone(String number, String cityCode, String countryCode, Date updatedAt, Date createdAt) {
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
