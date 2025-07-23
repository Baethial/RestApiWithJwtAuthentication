package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.Cliente;
import com.acm.HotelManagementApp.persistence.entity.ClienteEntity;
import com.acm.HotelManagementApp.persistence.repository.IClienteJpaRepository;
import com.acm.HotelManagementApp.service.IClienteService;
import com.acm.HotelManagementApp.util.mapping.IClienteMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteServiceImpl implements IClienteService {

    private final IClienteJpaRepository clienteRepository;
    private final IClienteMapper clienteMapper;

    @Transactional
    @Override
    public Cliente save(Cliente model) {
        ClienteEntity clienteEntity = clienteMapper.modelToEntity(model);
        ClienteEntity savedClienteEntity = clienteRepository.save(clienteEntity);
        return clienteMapper.entityToModel(savedClienteEntity);
    }

    @Override
    public Cliente findById(Long id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id).orElse(null);
        return clienteMapper.entityToModel(clienteEntity);
    }

    @Override
    public List<Cliente> findAll() {
        List<ClienteEntity> clienteEntities = clienteRepository.findAll();
        return  clienteEntities.stream().map(clienteMapper::entityToModel).toList();
    }

    @Transactional
    @Override
    public Cliente update(Cliente model) {
        ClienteEntity clienteEntity = clienteMapper.modelToEntity(model);
        ClienteEntity updatedClienteEntity = clienteRepository.save(clienteEntity);
        return clienteMapper.entityToModel(updatedClienteEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
