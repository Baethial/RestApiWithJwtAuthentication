package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.Empleado;
import com.acm.HotelManagementApp.persistence.entity.EmpleadoEntity;
import com.acm.HotelManagementApp.persistence.repository.IEmpleadoJpaRepository;
import com.acm.HotelManagementApp.service.IEmpleadoService;
import com.acm.HotelManagementApp.util.mapping.IEmpleadoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmpleadoServiceImpl implements IEmpleadoService {

    private final IEmpleadoJpaRepository empleadoRepository;
    private final IEmpleadoMapper empleadoMapper;

    @Transactional
    @Override
    public Empleado save(Empleado model) {
        EmpleadoEntity empleadoEntity = empleadoMapper.modelToEntity(model);
        EmpleadoEntity savedEmpleadoEntity = empleadoRepository.save(empleadoEntity);
        return empleadoMapper.entityToModel(savedEmpleadoEntity);
    }

    @Override
    public Empleado findById(Long id) {
        EmpleadoEntity empleadoEntity = empleadoRepository.findById(id).orElse(null);
        return empleadoMapper.entityToModel(empleadoEntity);
    }

    @Override
    public List<Empleado> findAll() {
        List<EmpleadoEntity> empleadoEntities = empleadoRepository.findAll();
        return empleadoEntities.stream().map(empleadoMapper::entityToModel).toList();
    }

    @Transactional
    @Override
    public Empleado update(Empleado model) {
        EmpleadoEntity empleadoEntity = empleadoMapper.modelToEntity(model);
        EmpleadoEntity updatedEmpleadoEntity = empleadoRepository.save(empleadoEntity);
        return empleadoMapper.entityToModel(updatedEmpleadoEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }
}
