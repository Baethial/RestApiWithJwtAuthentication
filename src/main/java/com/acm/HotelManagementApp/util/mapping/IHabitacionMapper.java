package com.acm.HotelManagementApp.util.mapping;

import com.acm.HotelManagementApp.controller.dto.HabitacionDTO;
import com.acm.HotelManagementApp.model.Habitacion;
import com.acm.HotelManagementApp.persistence.entity.HabitacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IHotelMapper.class})
public interface IHabitacionMapper extends IMapper<Habitacion, HabitacionEntity, HabitacionDTO> {

    @Override
    @Mapping(target = "hotel.habitaciones", ignore = true)
    @Mapping(target = "tipoHabitacion.habitaciones", ignore = true)
    @Mapping(target = "reservas.habitacion", ignore = true)
    Habitacion entityToModel(HabitacionEntity entity);

    @Override
    @Mapping(target = "hotel.habitaciones", ignore = true)
    @Mapping(target = "tipoHabitacion.habitaciones", ignore = true)
    @Mapping(target = "reservas.habitacion", ignore = true)
    HabitacionEntity modelToEntity(Habitacion model);

    @Override
    @Mapping(target = "hotel", ignore = true)
    @Mapping(target = "tipoHabitacion", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    Habitacion dtoToModel(HabitacionDTO dto);

    @Override
    @Mapping(target = "idHotel", source = "hotel.id")
    @Mapping(target = "idTipoHabitacion", source = "tipoHabitacion.id")
    HabitacionDTO modelToDto(Habitacion model);
}