package com.acm.HotelManagementApp.util.mapping;

import com.acm.HotelManagementApp.controller.dto.FacturaDTO;
import com.acm.HotelManagementApp.model.Factura;
import com.acm.HotelManagementApp.persistence.entity.FacturaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IFacturaMapper extends IMapper<Factura, FacturaEntity, FacturaDTO> {
}
