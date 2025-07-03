package com.acm.hotelgestion.service;

import com.acm.hotelgestion.persistence.TipoHabitacionEntity;
import com.acm.hotelgestion.repository.TipoHabitacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoHabitacionService {

    private final TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    public TipoHabitacionService(TipoHabitacionRepository tipoHabitacionRepository) {
        this.tipoHabitacionRepository = tipoHabitacionRepository;
    }

    @Transactional
    public TipoHabitacionEntity saveTipoHabitacion(TipoHabitacionEntity tipoHabitacionEntity) {
        return tipoHabitacionRepository.save(tipoHabitacionEntity);
    }

    public TipoHabitacionEntity findTipoHabitacionById(Long id) {
        return tipoHabitacionRepository.findById(id).orElse(null);
    }

    public List<TipoHabitacionEntity> findAllTipoHabitaciones() {
        return tipoHabitacionRepository.findAll();
    }

    @Transactional
    public TipoHabitacionEntity updateTipoHabitacion(TipoHabitacionEntity tipoHabitacionEntity) {
        return tipoHabitacionRepository.save(tipoHabitacionEntity);
    }

    @Transactional
    public void deleteTipoHabitacionById(Long id) {
        tipoHabitacionRepository.deleteById(id);
    }

}
