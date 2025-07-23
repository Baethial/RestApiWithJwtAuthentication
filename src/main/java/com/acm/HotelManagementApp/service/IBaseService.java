package com.acm.HotelManagementApp.service;

import java.util.List;

public interface IBaseService <T> {

    T save(T model);
    T findById(Long id);
    List<T> findAll();
    T update(T model);
    void deleteById(Long id);
}
