package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.AdministradorGeneral;
import com.acm.HotelManagementApp.persistence.entity.AdministradorGeneralEntity;
import com.acm.HotelManagementApp.persistence.repository.IAdministradorGeneralJpaRepository;
import com.acm.HotelManagementApp.service.IAdministradorGeneralService;
import com.acm.HotelManagementApp.util.mapping.IAdministradorGeneralMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdministradorGeneralServiceImpl implements IAdministradorGeneralService {

    private final IAdministradorGeneralJpaRepository administradorGeneralRepository;
    private final IAdministradorGeneralMapper administradorGeneralMapper;

    @Transactional
    @Override
    public AdministradorGeneral save(AdministradorGeneral model) {
        AdministradorGeneralEntity administradorGeneralEntity = administradorGeneralMapper.modelToEntity(model);
        AdministradorGeneralEntity savedAdministradorGeneralEntity = administradorGeneralRepository.save(administradorGeneralEntity);
        return administradorGeneralMapper.entityToModel(savedAdministradorGeneralEntity);
    }

    @Override
    public AdministradorGeneral findById(Long id) {
        AdministradorGeneralEntity administradorGeneralEntity = administradorGeneralRepository.findById(id).orElse(null);
        return administradorGeneralMapper.entityToModel(administradorGeneralEntity);
    }

    @Override
    public List<AdministradorGeneral> findAll() {
        List<AdministradorGeneralEntity> administradorGeneralEntities = administradorGeneralRepository.findAll();
        return administradorGeneralEntities.stream().map(administradorGeneralMapper::entityToModel).toList();
    }

    @Transactional
    @Override
    public AdministradorGeneral update(AdministradorGeneral model) {
        AdministradorGeneralEntity administradorGeneralEntity = administradorGeneralMapper.modelToEntity(model);
        AdministradorGeneralEntity updatedAdministradorGeneralEntity = administradorGeneralRepository.save(administradorGeneralEntity);
        return administradorGeneralMapper.entityToModel(updatedAdministradorGeneralEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        administradorGeneralRepository.deleteById(id);
    }
}
