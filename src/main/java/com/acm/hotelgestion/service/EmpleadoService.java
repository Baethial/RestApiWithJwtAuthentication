package com.acm.hotelgestion.service;

import com.acm.hotelgestion.persistence.EmpleadoEntity;
import com.acm.hotelgestion.repository.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional
    public EmpleadoEntity saveEmpleado(EmpleadoEntity empleadoEntity) {
        return empleadoRepository.save(empleadoEntity);
    }

    public EmpleadoEntity findEmpleadoById(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public List<EmpleadoEntity> findAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Transactional
    public EmpleadoEntity updateEmpleado(EmpleadoEntity empleadoEntity) {
        return empleadoRepository.save(empleadoEntity);
    }

    @Transactional
    public void deleteEmpleadoById(Long id) {
        empleadoRepository.deleteById(id);
    }

}
