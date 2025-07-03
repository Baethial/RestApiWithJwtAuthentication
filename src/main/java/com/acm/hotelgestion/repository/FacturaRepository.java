package com.acm.hotelgestion.repository;

import com.acm.hotelgestion.persistence.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<FacturaEntity, Long> {
}
