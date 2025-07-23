package com.acm.HotelManagementApp.util.mapping;

//@Mapper(componentModel = "spring")
public interface IMapper<T, S, U> { // T for the model, S for the entity, U for the DTO

    // ENTITY -> MODEL
    T entityToModel(S entity);

    // MODEL -> ENTITY
    S modelToEntity(T model);

    // DTO -> MODEL
    T dtoToModel(U dto);

    // MODEL -> DTO
    U modelToDto(T model);
}
