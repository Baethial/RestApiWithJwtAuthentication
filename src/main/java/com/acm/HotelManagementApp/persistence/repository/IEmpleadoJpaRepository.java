package com.acm.HotelManagementApp.persistence.repository;

import com.acm.HotelManagementApp.persistence.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoJpaRepository extends JpaRepository<EmpleadoEntity, Long> {
}
