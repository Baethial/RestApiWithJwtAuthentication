package com.acm.HotelManagementApp.util.mapping;

import com.acm.HotelManagementApp.controller.dto.ReservaDTO;
import com.acm.HotelManagementApp.model.Reserva;
import com.acm.HotelManagementApp.persistence.entity.ReservaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IReservaMapper extends IMapper<Reserva, ReservaEntity, ReservaDTO>{
}
