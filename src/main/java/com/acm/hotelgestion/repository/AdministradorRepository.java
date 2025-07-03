package com.acm.hotelgestion.repository;

import com.acm.hotelgestion.persistence.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Long> {
}
