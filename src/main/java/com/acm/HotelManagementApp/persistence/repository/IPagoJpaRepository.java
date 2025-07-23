package com.acm.HotelManagementApp.persistence.repository;

import com.acm.HotelManagementApp.persistence.entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPagoJpaRepository extends JpaRepository<PagoEntity, Long> {
}
