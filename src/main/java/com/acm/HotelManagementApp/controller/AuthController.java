package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.UsuarioDTO;
import com.acm.HotelManagementApp.model.*;
import com.acm.HotelManagementApp.service.IUsuarioService;
import com.acm.HotelManagementApp.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final IUsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

     // Login endpoint
     // This method authenticates a user and returns a JWT token
    @PostMapping("/login/")
    public ResponseEntity<Object> login(@RequestBody UsuarioDTO usuarioDTO){
        try {
            // Attempt to authenticate the user with Spring Security
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuarioDTO.getNombreUsuario(), usuarioDTO.getContrasena())
            );

            // Extract the authenticated user details
            User user = (User) authentication.getPrincipal();

            // Generate a JWT token for the authenticated user
            String token = jwtUtil.generateToken(user.getUsername());

            // Build the response with token and user info
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("username", user.getUsername());

            log.info("User {} successfully logged in", user.getUsername());
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.warn("Login failed for user: {}", usuarioDTO.getNombreUsuario());
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }


    // Signup endpoint that can handle role-specific information
    // This method supports creating users with additional data needed for role-specific entities
    @PostMapping("/signup/")
    public ResponseEntity<Object> signup(@Valid @RequestBody UsuarioDTO usuarioDTO){
        try {
            log.info("Attempting to create user with role: {}", usuarioDTO.getRol());

            // Build the basic Usuario object with encrypted password
            Usuario.UsuarioBuilder usuarioBuilder = Usuario.builder()
                    .nombreUsuario(usuarioDTO.getNombreUsuario())
                    .contrasena(passwordEncoder.encode(usuarioDTO.getContrasena()))
                    .rol(usuarioDTO.getRol());

            // Add role-specific information to the Usuario object
            // This is where we prepare the additional data that will be used
            // when creating the role-specific entities
            Usuario usuario = buildUsuarioWithRoleSpecificData(usuarioBuilder, usuarioDTO);

            // Save the user - this will trigger the creation of both
            // the Usuario entity and the appropriate role-specific entity
            Usuario savedUsuario = usuarioService.save(usuario);

            // Build a successful response
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User created successfully");
            response.put("userId", savedUsuario.getId());
            response.put("username", savedUsuario.getNombreUsuario());
            response.put("role", savedUsuario.getRol());

            log.info("Successfully created user {} with role {}",
                    savedUsuario.getNombreUsuario(), savedUsuario.getRol());

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            // Handle validation errors (like invalid role)
            log.error("Validation error during user creation: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Validation error: " + e.getMessage());

        } catch (Exception e) {
            // Handle any other unexpected errors
            log.error("Unexpected error during user creation", e);
            return ResponseEntity.badRequest().body("User creation failed: " + e.getMessage());
        }
    }

     // This method builds the Usuario object with role-specific data
     // Different roles might require different additional information
     // This is a "preparation step" for setting up all the data
     // that the UsuarioService will need to create the appropriate role-specific entities
    private Usuario buildUsuarioWithRoleSpecificData(Usuario.UsuarioBuilder builder,
                                                     UsuarioDTO usuarioDTO) {

        // Start with the basic usuario
        Usuario usuario = builder.build();

        // Add role-specific data based on the user's role
        // This is where we extract additional information from the DTO
        // and prepare it for the service layer to use
        switch (usuarioDTO.getRol()) {
            case Rol.USUARIO:

                break;
            case Rol.CLIENTE:

                Cliente cliente = Cliente.builder()
                        .primerNombre(usuarioDTO.getCliente().getPrimerNombre())
                        .segundoNombre(usuarioDTO.getCliente().getSegundoNombre())
                        .primerApellido(usuarioDTO.getCliente().getPrimerApellido())
                        .segundoApellido(usuarioDTO.getCliente().getSegundoApellido())
                        .cedula(usuarioDTO.getCliente().getCedula())
                        .direccion(usuarioDTO.getCliente().getDireccion())
                        .build();
                usuario.setCliente(cliente);

                break;

            case Rol.EMPLEADO:

                Empleado empleado = Empleado.builder()
                        .primerNombre(usuarioDTO.getEmpleado().getPrimerNombre())
                        .segundoNombre(usuarioDTO.getEmpleado().getSegundoNombre())
                        .primerApellido(usuarioDTO.getEmpleado().getPrimerApellido())
                        .segundoApellido(usuarioDTO.getEmpleado().getSegundoApellido())
                        .correo(usuarioDTO.getEmpleado().getCorreo())
                        .telefono(usuarioDTO.getEmpleado().getTelefono())
                        .build();
                usuario.setEmpleado(empleado);
                break;

            case Rol.ADMINISTRADOR:

                Administrador administrador = Administrador.builder()
                        .primerNombre(usuarioDTO.getAdministrador().getPrimerNombre())
                        .segundoNombre(usuarioDTO.getAdministrador().getSegundoNombre())
                        .primerApellido(usuarioDTO.getAdministrador().getPrimerApellido())
                        .segundoApellido(usuarioDTO.getAdministrador().getSegundoApellido())
                        .correo(usuarioDTO.getAdministrador().getCorreo())
                        .telefono(usuarioDTO.getAdministrador().getTelefono())
                        .build();
                usuario.setAdministrador(administrador);
                break;

            case Rol.ADMINISTRADOR_GENERAL:

                AdministradorGeneral administradorGeneral = AdministradorGeneral.builder()
                        .primerNombre(usuarioDTO.getAdministradorGeneral().getPrimerNombre())
                        .segundoNombre(usuarioDTO.getAdministradorGeneral().getSegundoNombre())
                        .primerApellido(usuarioDTO.getAdministradorGeneral().getPrimerApellido())
                        .segundoApellido(usuarioDTO.getAdministradorGeneral().getSegundoApellido())
                        .correo(usuarioDTO.getAdministradorGeneral().getCorreo())
                        .telefono(usuarioDTO.getAdministradorGeneral().getTelefono())
                        .build();
                usuario.setAdministradorGeneral(administradorGeneral);
                break;

            default:
                throw new IllegalArgumentException("Unsupported role: " + usuarioDTO.getRol());
        }

        return usuario;
    }

    /*// This endpoint creates Usuario entities with default values
    @PostMapping("/signup-simple/")
    public ResponseEntity<Object> signupSimple(@Valid @RequestBody UsuarioDTO usuarioDto){
        try {
            // Create a Usuario with minimal information
            // The UsuarioService will create the role-specific entity with default values
            Usuario usuario = Usuario.builder()
                    .nombreUsuario(usuarioDto.getNombreUsuario())
                    .contrasena(passwordEncoder.encode(usuarioDto.getContrasena()))
                    .rol(usuarioDto.getRol())
                    .build();

            Usuario savedUsuario = usuarioService.save(usuario);

            log.info("Simple signup completed for user: {}", savedUsuario.getNombreUsuario());
            return ResponseEntity.ok("User created successfully with default role-specific data");

        } catch (Exception e) {
            log.error("Simple signup failed", e);
            return ResponseEntity.badRequest().body("User creation failed");
        }
    }*/
}