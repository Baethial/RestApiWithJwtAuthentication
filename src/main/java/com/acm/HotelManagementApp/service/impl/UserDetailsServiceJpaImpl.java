package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.persistence.repository.IUsuarioJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceJpaImpl implements UserDetailsService {

    private final IUsuarioJpaRepository usuarioJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioJpaRepository.findByNombreUsuario(username).
                map(user -> User.builder()
                        .username(user.getNombreUsuario())
                        .password(user.getContrasena())
                        .authorities("ROLE_USER")
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}
