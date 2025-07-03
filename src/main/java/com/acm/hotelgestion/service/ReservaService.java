package com.acm.hotelgestion.service;

import com.acm.hotelgestion.persistence.ReservaEntity;
import com.acm.hotelgestion.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Transactional
    public ReservaEntity saveReserva(ReservaEntity reservaEntity) {
        return reservaRepository.save(reservaEntity);
    }

    public ReservaEntity findReservaById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public List<ReservaEntity> findAllReservas() {
        return reservaRepository.findAll();
    }

    @Transactional
    public ReservaEntity updateReserva(ReservaEntity reservaEntity) {
        return reservaRepository.save(reservaEntity);
    }

    @Transactional
    public void deleteReservaById(Long id) {
        reservaRepository.deleteById(id);
    }

}
