package com.acm.hotelgestion.controller;

import com.acm.hotelgestion.persistence.ClienteEntity;
import com.acm.hotelgestion.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findClienteById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> getAllClientes() {
        return ResponseEntity.ok(clienteService.findAllClientes());
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> saveCliente(@RequestBody ClienteEntity clienteEntity) {
        return ResponseEntity.ok(clienteService.saveCliente(clienteEntity));
    }

    @PutMapping
    public ResponseEntity<ClienteEntity> updateCliente(@RequestBody ClienteEntity clienteEntity) {
        return ResponseEntity.ok(clienteService.updateCliente(clienteEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteEntity> deleteCliente(@PathVariable Long id) {
        clienteService.deleteClienteById(id);
        return ResponseEntity.noContent().build();
    }

}
