package com.acm.HotelManagementApp.util.mapping;

import com.acm.HotelManagementApp.controller.dto.UsuarioDTO;
import com.acm.HotelManagementApp.model.Usuario;
import com.acm.HotelManagementApp.persistence.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUsuarioMapper extends IMapper<Usuario, UsuarioEntity, UsuarioDTO> {
}
