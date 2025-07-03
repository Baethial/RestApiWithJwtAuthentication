package com.acm.hotelgestion.service;

import com.acm.hotelgestion.persistence.AdministradorGeneralEntity;
import com.acm.hotelgestion.repository.AdministradorGeneralRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorGeneralService {

    private final AdministradorGeneralRepository administradorGeneralRepository;

    @Autowired
    public AdministradorGeneralService(AdministradorGeneralRepository administradorGeneralRepository) {
        this.administradorGeneralRepository = administradorGeneralRepository;
    }

    @Transactional
    public AdministradorGeneralEntity saveAdministradorGeneral(AdministradorGeneralEntity administradorGeneralEntity) {
        return administradorGeneralRepository.save(administradorGeneralEntity);
    }

    public AdministradorGeneralEntity findAdministradorGeneralById(Long id) {
        return administradorGeneralRepository.findById(id).orElse(null);
    }

    public List<AdministradorGeneralEntity> findAllAdministradoresGenerales() {
        return administradorGeneralRepository.findAll();
    }

    @Transactional
    public AdministradorGeneralEntity updateAdministradorGeneral(AdministradorGeneralEntity administradorGeneralEntity) {
        return administradorGeneralRepository.save(administradorGeneralEntity);
    }

    @Transactional
    public void deleteAdministradorGeneralById(Long id) {
        administradorGeneralRepository.deleteById(id);
    }

}
