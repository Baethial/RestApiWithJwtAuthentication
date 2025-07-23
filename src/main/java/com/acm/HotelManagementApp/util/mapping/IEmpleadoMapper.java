package com.acm.HotelManagementApp.util.mapping;

import com.acm.HotelManagementApp.controller.dto.EmpleadoDTO;
import com.acm.HotelManagementApp.model.Empleado;
import com.acm.HotelManagementApp.persistence.entity.EmpleadoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IEmpleadoMapper extends IMapper<Empleado, EmpleadoEntity, EmpleadoDTO>{
}
