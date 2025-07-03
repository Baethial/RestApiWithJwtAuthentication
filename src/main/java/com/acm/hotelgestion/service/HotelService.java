package com.acm.hotelgestion.service;

import com.acm.hotelgestion.persistence.HotelEntity;
import com.acm.hotelgestion.repository.HotelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional
    public HotelEntity saveHotel(HotelEntity hotelEntity) {
        return hotelRepository.save(hotelEntity);
    }

    public HotelEntity findHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public List<HotelEntity> findAllHotels() {
        return hotelRepository.findAll();
    }

    @Transactional
    public HotelEntity updateHotel(HotelEntity hotelEntity) {
        return hotelRepository.save(hotelEntity);
    }

    @Transactional
    public void deleteHotelById(Long id) {
        hotelRepository.deleteById(id);
    }
}
