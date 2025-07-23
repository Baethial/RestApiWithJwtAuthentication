package com.acm.HotelManagementApp.persistence.repository;

import com.acm.HotelManagementApp.persistence.entity.HabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabitacionJpaRepository extends JpaRepository<HabitacionEntity, Long> {

}
