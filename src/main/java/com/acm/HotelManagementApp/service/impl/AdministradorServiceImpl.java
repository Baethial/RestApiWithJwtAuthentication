package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.Administrador;
import com.acm.HotelManagementApp.persistence.entity.AdministradorEntity;
import com.acm.HotelManagementApp.persistence.repository.IAdministradorJpaRepository;
import com.acm.HotelManagementApp.service.IAdministradorService;
import com.acm.HotelManagementApp.util.mapping.IAdministradorMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdministradorServiceImpl implements IAdministradorService {

    private final IAdministradorJpaRepository administradorRepository;
    private final IAdministradorMapper administradorMapper;

    @Transactional
    @Override
    public Administrador save(Administrador model) {
        AdministradorEntity administradorEntity = administradorMapper.modelToEntity(model);
        AdministradorEntity savedAdministradorEntity = administradorRepository.save(administradorEntity);
        return administradorMapper.entityToModel(savedAdministradorEntity);
    }

    @Override
    public Administrador findById(Long id) {
        AdministradorEntity administradorEntity = administradorRepository.findById(id).orElse(null);
        return administradorMapper.entityToModel(administradorEntity);
    }

    @Override
    public List<Administrador> findAll() {
        List<AdministradorEntity> administradorEntities = administradorRepository.findAll();
        return administradorEntities.stream().map(administradorMapper::entityToModel).toList();
    }

    @Transactional
    @Override
    public Administrador update(Administrador model) {
        AdministradorEntity administradorEntity = administradorMapper.modelToEntity(model);
        AdministradorEntity updatedAdministradorEntity = administradorRepository.save(administradorEntity);
        return administradorMapper.entityToModel(updatedAdministradorEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        administradorRepository.deleteById(id);
    }
}
