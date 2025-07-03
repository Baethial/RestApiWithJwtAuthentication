package com.acm.hotelgestion.service;

import com.acm.hotelgestion.persistence.AdministradorEntity;
import com.acm.hotelgestion.repository.AdministradorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    private final AdministradorRepository administradorRepository;

    @Autowired
    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @Transactional
    public AdministradorEntity saveAdministrador(AdministradorEntity administradorEntity) {
        return administradorRepository.save(administradorEntity);
    }

    public AdministradorEntity findAdministradorById(Long id) {
        return administradorRepository.findById(id).orElse(null);
    }

    public List<AdministradorEntity> findAllAdministradores() {
        return administradorRepository.findAll();
    }

    @Transactional
    public AdministradorEntity updateAdministrador(AdministradorEntity administradorEntity) {
        return administradorRepository.save(administradorEntity);
    }

    @Transactional
    public void deleteAdministradorById(Long id) {
        administradorRepository.deleteById(id);
    }

}
