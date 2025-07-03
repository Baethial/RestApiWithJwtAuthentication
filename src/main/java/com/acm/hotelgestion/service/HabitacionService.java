package com.acm.hotelgestion.service;

import com.acm.hotelgestion.persistence.HabitacionEntity;
import com.acm.hotelgestion.repository.HabitacionRepository;
import com.acm.hotelgestion.repository.HotelRepository;
import com.acm.hotelgestion.repository.TipoHabitacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;
    private final HotelRepository hotelRepository;
    private final TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository, HotelRepository hotelRepository, TipoHabitacionRepository tipoHabitacionRepository) {
        this.habitacionRepository = habitacionRepository;
        this.hotelRepository = hotelRepository;
        this.tipoHabitacionRepository = tipoHabitacionRepository;
    }

    @Transactional
    public HabitacionEntity saveHabitacion(HabitacionEntity habitacionEntity) {
        return habitacionRepository.save(habitacionEntity);
    }

    public HabitacionEntity findHabitacionById(Long id) {
        return habitacionRepository.findById(id).orElse(null);
    }

    public List<HabitacionEntity> findAllHabitaciones() {
        return habitacionRepository.findAll();
    }

    @Transactional
    public HabitacionEntity updateHabitacion(HabitacionEntity habitacionEntity) {
        return habitacionRepository.save(habitacionEntity);
    }

    @Transactional
    public void deleteHabitacionById(Long id) {
        habitacionRepository.deleteById(id);
    }

}
