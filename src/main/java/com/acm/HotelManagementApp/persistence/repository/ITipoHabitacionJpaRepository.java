package com.acm.HotelManagementApp.persistence.repository;

import com.acm.HotelManagementApp.persistence.entity.TipoHabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoHabitacionJpaRepository extends JpaRepository<TipoHabitacionEntity, Long> {
}
