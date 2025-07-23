package com.acm.HotelManagementApp.util.mapping;

import com.acm.HotelManagementApp.controller.dto.PagoDTO;
import com.acm.HotelManagementApp.model.Pago;
import com.acm.HotelManagementApp.persistence.entity.PagoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPagoMapper extends IMapper<Pago, PagoEntity, PagoDTO>{
}
