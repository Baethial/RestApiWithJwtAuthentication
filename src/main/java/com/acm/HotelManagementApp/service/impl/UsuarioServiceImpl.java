package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.Usuario;
import com.acm.HotelManagementApp.persistence.entity.UsuarioEntity;
import com.acm.HotelManagementApp.persistence.repository.IUsuarioJpaRepository;
import com.acm.HotelManagementApp.service.IUsuarioService;
import com.acm.HotelManagementApp.util.mapping.IUsuarioMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioJpaRepository usuarioRepository;
    private final IUsuarioMapper usuarioMapper;

    @Transactional
    @Override
    public Usuario save(Usuario model) {
        UsuarioEntity usuarioEntity = usuarioMapper.modelToEntity(model);
        UsuarioEntity savedUsuarioEntity = usuarioRepository.save(usuarioEntity);
        return usuarioMapper.entityToModel(savedUsuarioEntity);
    }

    @Override
    public Usuario findById(Long id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id).orElse(null);
        return usuarioMapper.entityToModel(usuarioEntity);
    }

    @Override
    public List<Usuario> findAll() {
        List<UsuarioEntity> usuarioEntities = usuarioRepository.findAll();
        return usuarioEntities.stream().map(usuarioMapper::entityToModel).toList();
    }

    @Transactional
    @Override
    public Usuario update(Usuario model) {
        UsuarioEntity usuarioEntity = usuarioMapper.modelToEntity(model);
        UsuarioEntity updatedUsuarioEntity = usuarioRepository.save(usuarioEntity);
        return usuarioMapper.entityToModel(updatedUsuarioEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
