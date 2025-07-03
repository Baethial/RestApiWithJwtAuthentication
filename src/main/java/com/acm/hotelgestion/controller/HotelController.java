package com.acm.hotelgestion.controller;

import com.acm.hotelgestion.persistence.HotelEntity;
import com.acm.hotelgestion.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelEntity> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.findHotelById(id));
    }

    @GetMapping
    public ResponseEntity<List<HotelEntity>> getAllHotels() {
        return ResponseEntity.ok(hotelService.findAllHotels());
    }

    @PostMapping
    public ResponseEntity<HotelEntity> saveHotel(@RequestBody HotelEntity hotelEntity) {
        return ResponseEntity.ok(hotelService.saveHotel(hotelEntity));
    }

    @PutMapping
    public ResponseEntity<HotelEntity> updateHotel(@RequestBody HotelEntity hotelEntity) {
        return ResponseEntity.ok(hotelService.updateHotel(hotelEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HotelEntity> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotelById(id);
        return ResponseEntity.noContent().build();
    }

}