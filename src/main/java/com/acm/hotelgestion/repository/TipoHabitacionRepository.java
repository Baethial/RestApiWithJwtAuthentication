package com.acm.hotelgestion.repository;

import com.acm.hotelgestion.persistence.TipoHabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacionEntity, Long> {
}
