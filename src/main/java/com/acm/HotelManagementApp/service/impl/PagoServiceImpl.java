package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.Pago;
import com.acm.HotelManagementApp.persistence.entity.PagoEntity;
import com.acm.HotelManagementApp.persistence.repository.IPagoJpaRepository;
import com.acm.HotelManagementApp.service.IPagoService;
import com.acm.HotelManagementApp.util.mapping.IPagoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagoServiceImpl implements IPagoService {

    private final IPagoJpaRepository pagoRepository;
    private final IPagoMapper pagoMapper;

    @Transactional
    @Override
    public Pago save(Pago model) {
        PagoEntity pagoEntity = pagoMapper.modelToEntity(model);
        PagoEntity savedPagoEntity = pagoRepository.save(pagoEntity);
        return pagoMapper.entityToModel(savedPagoEntity);
    }

    @Override
    public Pago findById(Long id) {
        PagoEntity pagoEntity = pagoRepository.findById(id).orElse(null);
        return pagoMapper.entityToModel(pagoEntity);
    }

    @Override
    public List<Pago> findAll() {
        List<PagoEntity> pagoEntities = pagoRepository.findAll();
        return pagoEntities.stream().map(pagoMapper::entityToModel).toList();
    }

    @Transactional
    @Override
    public Pago update(Pago model) {
        PagoEntity pagoEntity = pagoMapper.modelToEntity(model);
        PagoEntity updatedPagoEntity = pagoRepository.save(pagoEntity);
        return pagoMapper.entityToModel(updatedPagoEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        pagoRepository.deleteById(id);
    }
}
