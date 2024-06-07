package com.exercises.usermanagement.repository;

import com.exercises.usermanagement.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone, UUID> {
}
