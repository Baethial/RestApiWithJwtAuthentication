package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.TipoHabitacion;
import com.acm.HotelManagementApp.persistence.entity.TipoHabitacionEntity;
import com.acm.HotelManagementApp.persistence.repository.ITipoHabitacionJpaRepository;
import com.acm.HotelManagementApp.service.ITipoHabitacionService;
import com.acm.HotelManagementApp.util.mapping.ITipoHabitacionMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TipoHabitacionServiceImpl implements ITipoHabitacionService {

    private final ITipoHabitacionJpaRepository tipoHabitacionRepository;
    private final ITipoHabitacionMapper tipoHabitacionMapper;

    @Transactional
    @Override
    public TipoHabitacion save(TipoHabitacion model) {
        TipoHabitacionEntity tipoHabitacionEntity = tipoHabitacionMapper.modelToEntity(model);
        TipoHabitacionEntity savedTipoHabitacionEntity = tipoHabitacionRepository.save(tipoHabitacionEntity);
        return tipoHabitacionMapper.entityToModel(savedTipoHabitacionEntity);
    }

    @Override
    public TipoHabitacion findById(Long id) {
        TipoHabitacionEntity tipoHabitacionEntity = tipoHabitacionRepository.findById(id).orElse(null);
        return tipoHabitacionMapper.entityToModel(tipoHabitacionEntity);
    }

    @Override
    public List<TipoHabitacion> findAll() {
        List<TipoHabitacionEntity> tipoHabitacionEntities = tipoHabitacionRepository.findAll();
        return tipoHabitacionEntities.stream().map(tipoHabitacionMapper::entityToModel).toList();
    }

    @Transactional
    @Override
    public TipoHabitacion update(TipoHabitacion model) {
        TipoHabitacionEntity tipoHabitacionEntity = tipoHabitacionMapper.modelToEntity(model);
        TipoHabitacionEntity updatedTipoHabitacionEntity = tipoHabitacionRepository.save(tipoHabitacionEntity);
        return tipoHabitacionMapper.entityToModel(updatedTipoHabitacionEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        tipoHabitacionRepository.deleteById(id);
    }
}
