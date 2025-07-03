package com.acm.hotelgestion.service;

import com.acm.hotelgestion.persistence.UsuarioEntity;
import com.acm.hotelgestion.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public UsuarioEntity saveUsuario(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    public UsuarioEntity findUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<UsuarioEntity> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public UsuarioEntity updateUsuario(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    @Transactional
    public void deleteUsuarioById(Long id) {
        usuarioRepository.deleteById(id);
    }

}
