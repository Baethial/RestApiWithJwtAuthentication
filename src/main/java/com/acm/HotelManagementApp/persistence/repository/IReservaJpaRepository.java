package com.acm.HotelManagementApp.persistence.repository;

import com.acm.HotelManagementApp.persistence.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservaJpaRepository extends JpaRepository<ReservaEntity, Long> {
}
