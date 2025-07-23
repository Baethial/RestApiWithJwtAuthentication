package com.acm.HotelManagementApp.util.mapping;

import com.acm.HotelManagementApp.controller.dto.AdministradorGeneralDTO;
import com.acm.HotelManagementApp.model.AdministradorGeneral;
import com.acm.HotelManagementApp.persistence.entity.AdministradorGeneralEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAdministradorGeneralMapper extends IMapper<AdministradorGeneral, AdministradorGeneralEntity, AdministradorGeneralDTO> {
}
