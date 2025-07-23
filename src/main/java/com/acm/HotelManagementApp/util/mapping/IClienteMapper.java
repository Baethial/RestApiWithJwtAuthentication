package com.acm.HotelManagementApp.util.mapping;

import com.acm.HotelManagementApp.controller.dto.ClienteDTO;
import com.acm.HotelManagementApp.model.Cliente;
import com.acm.HotelManagementApp.persistence.entity.ClienteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IClienteMapper extends IMapper<Cliente, ClienteEntity, ClienteDTO>{
}
