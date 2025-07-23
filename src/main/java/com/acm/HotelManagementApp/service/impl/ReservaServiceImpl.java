package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.Reserva;
import com.acm.HotelManagementApp.persistence.entity.ReservaEntity;
import com.acm.HotelManagementApp.persistence.repository.IReservaJpaRepository;
import com.acm.HotelManagementApp.service.IReservaService;
import com.acm.HotelManagementApp.util.mapping.IReservaMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservaServiceImpl implements IReservaService {

    private final IReservaJpaRepository reservaRepository;
    private final IReservaMapper reservaMapper;

    @Transactional
    @Override
    public Reserva save(Reserva model) {
        ReservaEntity reservaEntity = reservaMapper.modelToEntity(model);
        ReservaEntity savedReservaEntity = reservaRepository.save(reservaEntity);
        return reservaMapper.entityToModel(savedReservaEntity);
    }

    @Override
    public Reserva findById(Long id) {
        ReservaEntity reservaEntity = reservaRepository.findById(id).orElse(null);
        return reservaMapper.entityToModel(reservaEntity);
    }

    @Override
    public List<Reserva> findAll() {
        List<ReservaEntity> reservaEntities = reservaRepository.findAll();
        return reservaEntities.stream().map(reservaMapper::entityToModel).toList();
    }

    @Transactional
    @Override
    public Reserva update(Reserva model) {
        ReservaEntity reservaEntity = reservaMapper.modelToEntity(model);
        ReservaEntity updatedReservaEntity = reservaRepository.save(reservaEntity);
        return reservaMapper.entityToModel(updatedReservaEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }
}
