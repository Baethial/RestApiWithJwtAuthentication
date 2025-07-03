package com.acm.hotelgestion.repository;

import com.acm.hotelgestion.persistence.HabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepository extends JpaRepository<HabitacionEntity, Long> {

}
