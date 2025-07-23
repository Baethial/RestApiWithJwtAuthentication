package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.Hotel;
import com.acm.HotelManagementApp.persistence.entity.HotelEntity;
import com.acm.HotelManagementApp.persistence.repository.IHotelJpaRepository;
import com.acm.HotelManagementApp.service.IHotelService;
import com.acm.HotelManagementApp.util.mapping.IHotelMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements IHotelService {

    private final IHotelJpaRepository hotelRepository;
    private final IHotelMapper hotelMapper;

    @Override
    @Transactional
    public Hotel save(Hotel model) {
        HotelEntity hotelEntity = hotelMapper.modelToEntity(model);
        HotelEntity savedHotelEntity = hotelRepository.save(hotelEntity);
        return hotelMapper.entityToModel(savedHotelEntity);
    }

    @Override
    public Hotel findById(Long id) {
        HotelEntity hotelEntity = hotelRepository.findById(id).orElse(null);
        return hotelMapper.entityToModel(hotelEntity);
    }

    @Override
    public List<Hotel> findAll() {
        List<HotelEntity> hotelEntities = hotelRepository.findAll();
        return hotelEntities.stream().map(hotelMapper::entityToModel).toList();
    }

    @Transactional
    @Override
    public Hotel update(Hotel model) {
        HotelEntity hotelEntity = hotelMapper.modelToEntity(model);
        HotelEntity updatedHotelEntity = hotelRepository.save(hotelEntity);
        return hotelMapper.entityToModel(updatedHotelEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        hotelRepository.deleteById(id);
    }
}
