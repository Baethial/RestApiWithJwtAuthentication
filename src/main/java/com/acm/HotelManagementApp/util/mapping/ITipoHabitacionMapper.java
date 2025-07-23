package com.acm.HotelManagementApp.util.mapping;

import com.acm.HotelManagementApp.controller.dto.TipoHabitacionDTO;
import com.acm.HotelManagementApp.model.TipoHabitacion;
import com.acm.HotelManagementApp.persistence.entity.TipoHabitacionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITipoHabitacionMapper extends IMapper<TipoHabitacion, TipoHabitacionEntity, TipoHabitacionDTO>{
}
