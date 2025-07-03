package com.acm.hotelgestion.service;

import com.acm.hotelgestion.persistence.ClienteEntity;
import com.acm.hotelgestion.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteEntity saveCliente(ClienteEntity clienteEntity) {
        return clienteRepository.save(clienteEntity);
    }

    public ClienteEntity findClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<ClienteEntity> findAllClientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    public ClienteEntity updateCliente(ClienteEntity clienteEntity) {
        return clienteRepository.save(clienteEntity);
    }

    @Transactional
    public void deleteClienteById(Long id) {
        clienteRepository.deleteById(id);
    }

}
