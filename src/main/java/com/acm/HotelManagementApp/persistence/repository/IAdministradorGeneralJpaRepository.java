package com.acm.HotelManagementApp.persistence.repository;

import com.acm.HotelManagementApp.persistence.entity.AdministradorGeneralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdministradorGeneralJpaRepository extends JpaRepository<AdministradorGeneralEntity, Long> {
}
