package com.acm.HotelManagementApp.util.mapping;

import com.acm.HotelManagementApp.controller.dto.AdministradorDTO;
import com.acm.HotelManagementApp.model.Administrador;
import com.acm.HotelManagementApp.persistence.entity.AdministradorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAdministradorMapper extends IMapper<Administrador, AdministradorEntity, AdministradorDTO>{
}
