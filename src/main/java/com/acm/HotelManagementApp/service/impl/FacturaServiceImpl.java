package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.Factura;
import com.acm.HotelManagementApp.persistence.entity.FacturaEntity;
import com.acm.HotelManagementApp.persistence.repository.IFacturaJpaRepository;
import com.acm.HotelManagementApp.service.IFacturaService;
import com.acm.HotelManagementApp.util.mapping.IFacturaMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FacturaServiceImpl implements IFacturaService {

    private final IFacturaJpaRepository facturaRepository;
    private final IFacturaMapper facturaMapper;

    @Transactional
    @Override
    public Factura save(Factura model) {
        FacturaEntity facturaEntity = facturaMapper.modelToEntity(model);
        FacturaEntity savedFacturaEntity = facturaRepository.save(facturaEntity);
        return facturaMapper.entityToModel(savedFacturaEntity);
    }

    @Override
    public Factura findById(Long id) {
        FacturaEntity facturaEntity = facturaRepository.findById(id).orElse(null);
        return facturaMapper.entityToModel(facturaEntity);
    }

    @Override
    public List<Factura> findAll() {
        List<FacturaEntity> facturaEntities = facturaRepository.findAll();
        return facturaEntities.stream().map(facturaMapper::entityToModel).toList();
    }

    @Transactional
    @Override
    public Factura update(Factura model) {
        FacturaEntity facturaEntity = facturaMapper.modelToEntity(model);
        FacturaEntity updatedFacturaEntity = facturaRepository.save(facturaEntity);
        return facturaMapper.entityToModel(updatedFacturaEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        facturaRepository.deleteById(id);
    }
}
