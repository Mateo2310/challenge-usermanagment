package com.exercises.usermanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue()
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones;

    @Column(nullable = false, name = "is_active")
    private boolean isActive;

    @Column(nullable = false, name = "created_at")
    private Date createdAt;

    @Column(nullable = false, name = "updated_at")
    private Date updatedAt;

    @Column(nullable = false, name = "last_login")
    private Date lastLogin;

    public User(String name, String email, String password, List<Phone> phones, boolean isActive, Date createdAt, Date updatedAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastLogin=new Date();
    }

    public User(String name, String email, String password, List<Phone> phones, boolean isActive, Date updatedAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.isActive = isActive;
        this.updatedAt = new Date();
    }

    public User() {}

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
