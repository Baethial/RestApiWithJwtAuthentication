package com.acm.HotelManagementApp.util.mapping;

import com.acm.HotelManagementApp.controller.dto.HotelDTO;
import com.acm.HotelManagementApp.model.Hotel;
import com.acm.HotelManagementApp.persistence.entity.HotelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IHabitacionMapper.class})
public interface IHotelMapper extends IMapper<Hotel, HotelEntity, HotelDTO> {

    @Override
    @Mapping(target = "habitaciones.hotel", ignore = true)
    @Mapping(target = "habitaciones.reservas", ignore = true)
    Hotel entityToModel(HotelEntity entity);

    @Override
    @Mapping(target = "habitaciones.hotel", ignore = true)
    @Mapping(target = "habitaciones.reservas", ignore = true)
    HotelEntity modelToEntity(Hotel model);

    @Override
    @Mapping(target = "habitaciones", ignore = true)
    Hotel dtoToModel(HotelDTO dto);

    @Override
    @Mapping(target = "idsHabitaciones", ignore = true)
    HotelDTO modelToDto(Hotel model);
}