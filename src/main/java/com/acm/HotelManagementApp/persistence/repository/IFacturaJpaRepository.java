package com.acm.HotelManagementApp.persistence.repository;

import com.acm.HotelManagementApp.persistence.entity.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaJpaRepository extends JpaRepository<FacturaEntity, Long> {
}
