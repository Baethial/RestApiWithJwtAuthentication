package com.acm.hotelgestion.repository;

import com.acm.hotelgestion.persistence.AdministradorGeneralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorGeneralRepository extends JpaRepository<AdministradorGeneralEntity, Long> {
}
