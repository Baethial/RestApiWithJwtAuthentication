package com.acm.hotelgestion.service;

import com.acm.hotelgestion.persistence.PagoEntity;
import com.acm.hotelgestion.repository.PagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    @Autowired
    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Transactional
    public PagoEntity savePago(PagoEntity pagoEntity) {
        return pagoRepository.save(pagoEntity);
    }

    public PagoEntity findPagoById(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public List<PagoEntity> findAllPagos() {
        return pagoRepository.findAll();
    }

    @Transactional
    public PagoEntity updatePago(PagoEntity pagoEntity) {
        return pagoRepository.save(pagoEntity);
    }

    @Transactional
    public void deletePagoById(Long id) {
        pagoRepository.deleteById(id);
    }

}
