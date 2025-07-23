package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.ClienteDTO;
import com.acm.HotelManagementApp.model.Cliente;
import com.acm.HotelManagementApp.service.impl.ClienteServiceImpl;
import com.acm.HotelManagementApp.util.mapping.IClienteMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
@Slf4j
public class ClienteController {

    private final ClienteServiceImpl clienteService;
    private final IClienteMapper clienteMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        ClienteDTO clienteDTO = clienteMapper.modelToDto(cliente);
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDTO> clientesDTOs = clientes.stream().map(clienteMapper::modelToDto).toList();
        return ResponseEntity.ok(clientesDTOs);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> saveCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.dtoToModel(clienteDTO);
        Cliente savedCliente = clienteService.save(cliente);
        ClienteDTO savedClienteDTO = clienteMapper.modelToDto(savedCliente);
        return ResponseEntity.ok(savedClienteDTO);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> updateCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.dtoToModel(clienteDTO);
        Cliente updatedCliente = clienteService.save(cliente);
        ClienteDTO updatedClienteDTO = clienteMapper.modelToDto(updatedCliente);
        return ResponseEntity.ok(updatedClienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDTO> deleteCliente(@PathVariable Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
