package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.UsuarioDTO;
import com.acm.HotelManagementApp.model.Usuario;
import com.acm.HotelManagementApp.service.IUsuarioService;
import com.acm.HotelManagementApp.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final IUsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login/")
    public ResponseEntity<Object> login(@RequestBody UsuarioDTO usuarioDTO){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuarioDTO.getNombreUsuario(), usuarioDTO.getContrasena())
            );
            User user = (User) authentication.getPrincipal();
            String token = jwtUtil.generateToken(user.getUsername());
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("username", user.getUsername());
            return ResponseEntity.ok(response);

         } catch (Exception e) {
             return ResponseEntity.badRequest().body("Invalid credentials");
         }
    }

    @PostMapping("/signup/")
    public ResponseEntity<Object> signup(@Valid @RequestBody UsuarioDTO usuarioDto){
        try {
            usuarioService.save(Usuario.builder()
                            .nombreUsuario(usuarioDto.getNombreUsuario())
                            .contrasena(passwordEncoder.encode(usuarioDto.getContrasena()))
                            .rol(usuarioDto.getRol())
                    .build());
            return ResponseEntity.ok("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}
