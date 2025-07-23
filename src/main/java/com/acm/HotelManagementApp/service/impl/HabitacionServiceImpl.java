package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.Habitacion;
import com.acm.HotelManagementApp.persistence.entity.HabitacionEntity;
import com.acm.HotelManagementApp.persistence.repository.IHabitacionJpaRepository;
import com.acm.HotelManagementApp.service.IHabitacionService;
import com.acm.HotelManagementApp.util.mapping.IHabitacionMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HabitacionServiceImpl implements IHabitacionService {

    private final IHabitacionJpaRepository habitacionRepository;
    private final IHabitacionMapper habitacionMapper;

    @Transactional
    @Override
    public Habitacion save(Habitacion model) {
        HabitacionEntity habitacionEntity = habitacionMapper.modelToEntity(model);
        HabitacionEntity savedHabitacionEntity = habitacionRepository.save(habitacionEntity);
        return habitacionMapper.entityToModel(savedHabitacionEntity);
    }

    @Override
    public Habitacion findById(Long id) {
        HabitacionEntity habitacionEntity = habitacionRepository.findById(id).orElse(null);
        return habitacionMapper.entityToModel(habitacionEntity);
    }

    @Override
    public List<Habitacion> findAll() {
        List<HabitacionEntity> habitacionEntities = habitacionRepository.findAll();
        return habitacionEntities.stream().map(habitacionMapper::entityToModel).toList();
    }

    @Transactional
    @Override
    public Habitacion update(Habitacion model) {
        HabitacionEntity habitacionEntity = habitacionMapper.modelToEntity(model);
        HabitacionEntity updatedHabitacionEntity = habitacionRepository.save(habitacionEntity);
        return habitacionMapper.entityToModel(updatedHabitacionEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        habitacionRepository.deleteById(id);
    }
}
