package com.acm.hotelgestion.service;

import com.acm.hotelgestion.persistence.FacturaEntity;
import com.acm.hotelgestion.repository.FacturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Transactional
    public FacturaEntity saveFactura(FacturaEntity facturaEntity) {
        return facturaRepository.save(facturaEntity);
    }

    public FacturaEntity findFacturaById(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    public List<FacturaEntity> findAllFacturas() {
        return facturaRepository.findAll();
    }

    @Transactional
    public FacturaEntity updateFactura(FacturaEntity facturaEntity) {
        return facturaRepository.save(facturaEntity);
    }

    @Transactional
    public void deleteFacturaById(Long id) {
        facturaRepository.deleteById(id);
    }
}
