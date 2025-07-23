package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.HotelDTO;
import com.acm.HotelManagementApp.model.Hotel;
import com.acm.HotelManagementApp.service.impl.HotelServiceImpl;
import com.acm.HotelManagementApp.util.mapping.IHotelMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
@RequiredArgsConstructor
@Validated
public class HotelController {

    private final HotelServiceImpl hotelService;
    private final IHotelMapper hotelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelService.findById(id);
        HotelDTO hotelDTO = hotelMapper.modelToDto(hotel);
        return ResponseEntity.ok(hotelDTO);
    }

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        List<Hotel> hoteles = hotelService.findAll();
        List<HotelDTO> hotelesDTOs = hoteles.stream().map(hotelMapper::modelToDto).toList();
        return ResponseEntity.ok(hotelesDTOs);
    }

    @PostMapping
    public ResponseEntity<HotelDTO> saveHotel(@Valid @RequestBody HotelDTO hotelDTO) {
        Hotel hotel = hotelMapper.dtoToModel(hotelDTO);
        Hotel savedHotel = hotelService.save(hotel);
        HotelDTO savedHotelDTO = hotelMapper.modelToDto(savedHotel);
        return ResponseEntity.ok(savedHotelDTO);
    }

    @PutMapping
    public ResponseEntity<HotelDTO> updateHotel(@Valid @RequestBody HotelDTO hotelDTO) {
        Hotel hotel = hotelMapper.dtoToModel(hotelDTO);
        Hotel updatedHotel = hotelService.update(hotel);
        HotelDTO updatedHotelDTO = hotelMapper.modelToDto(updatedHotel);
        return ResponseEntity.ok(updatedHotelDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HotelDTO> deleteHotel(@PathVariable Long id) {
        hotelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}