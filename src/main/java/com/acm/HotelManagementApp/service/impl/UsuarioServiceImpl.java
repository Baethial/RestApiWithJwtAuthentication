package com.acm.HotelManagementApp.service.impl;

import com.acm.HotelManagementApp.model.Rol;
import com.acm.HotelManagementApp.model.Usuario;
import com.acm.HotelManagementApp.persistence.entity.*;
import com.acm.HotelManagementApp.persistence.repository.*;
import com.acm.HotelManagementApp.service.IUsuarioService;
import com.acm.HotelManagementApp.util.mapping.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements IUsuarioService {

    // Repository dependencies - these handle database operations
    private final IUsuarioJpaRepository usuarioRepository;
    private final IClienteJpaRepository clienteRepository;
    private final IEmpleadoJpaRepository empleadoRepository;
    private final IAdministradorJpaRepository administradorRepository;
    private final IAdministradorGeneralJpaRepository administradorGeneralRepository;

    // Mapper dependencies - these convert between models, entities, and DTOs
    private final IUsuarioMapper usuarioMapper;
    private final IClienteMapper clienteMapper;
    private final IEmpleadoMapper empleadoMapper;
    private final IAdministradorMapper administradorMapper;
    private final IAdministradorGeneralMapper administradorGeneralMapper;


    // Enhanced save method that creates both the Usuario and the corresponding role-specific entity
    @Transactional
    @Override
    public Usuario save(Usuario model) {
        log.info("Creating user with role: {}", model.getRol());

        // Step 1: Create the role-specific entity first
        // We do this first because the Usuario entity needs to reference it
        Object roleSpecificEntity = createRoleSpecificEntity(model);

        // Step 2: Convert the Usuario model to entity for database persistence
        UsuarioEntity usuarioEntity = usuarioMapper.modelToEntity(model);

        // Step 3: Set the appropriate foreign key relationship based on the role
        // This connects the Usuario to the newly created role-specific entity
        if (roleSpecificEntity != null) {
            setRoleSpecificRelationship(usuarioEntity, roleSpecificEntity, model.getRol());
        }

        // Step 4: Save the Usuario entity to the database
        UsuarioEntity savedUsuarioEntity = usuarioRepository.save(usuarioEntity);

        // Step 5: Convert back to model and return
        Usuario savedUsuario = usuarioMapper.entityToModel(savedUsuarioEntity);

        log.info("Successfully created user with ID: {} and role: {}",
                savedUsuario.getId(), savedUsuario.getRol());

        return savedUsuario;
    }

    // Creates the appropriate role-specific entity based on the user's role
    // This method demonstrates the Factory pattern - creating different objects based on input
    private Object createRoleSpecificEntity(Usuario usuario) {
        switch (usuario.getRol()) {
            case Rol.USUARIO:
                return null;
            case Rol.CLIENTE:
                return createClienteEntity(usuario);
            case Rol.EMPLEADO:
                return createEmpleadoEntity(usuario);
            case Rol.ADMINISTRADOR:
                return createAdministradorEntity(usuario);
            case Rol.ADMINISTRADOR_GENERAL:
                return createAdministradorGeneralEntity(usuario);
            default:
                // This should never happen if validation is working correctly
                throw new IllegalArgumentException("Invalid role: " + usuario.getRol());
        }
    }

    // Creates a Cliente entity with default values from the Usuario
    // In a real application, you might want to collect additional Cliente-specific data
    private ClienteEntity createClienteEntity(Usuario usuario) {
        // Create a Cliente entity
        // Enhanced by extracting additional info from the Usuario
        ClienteEntity clienteEntity = ClienteEntity.builder()
                .primerNombre(usuario.getCliente().getPrimerNombre())
                .segundoNombre(usuario.getCliente().getSegundoNombre())
                .primerApellido(usuario.getCliente().getPrimerApellido())
                .segundoApellido(usuario.getCliente().getSegundoApellido())
                .cedula(usuario.getCliente().getCedula())
                .direccion(usuario.getCliente().getDireccion())
                .build();

        // Save the Cliente entity and return it
        ClienteEntity savedCliente = clienteRepository.save(clienteEntity);
        log.debug("Created Cliente entity with ID: {}", savedCliente.getId());
        return savedCliente;
    }

    // Creates an Empleado entity - similar pattern to Cliente
    // You would implement this based on your Empleado entity structure
    private EmpleadoEntity createEmpleadoEntity(Usuario usuario) {
        // Create a Empleado entity
        // Enhanced by extracting additional info from the Usuario
        EmpleadoEntity empleadoEntity = EmpleadoEntity.builder()
                .primerNombre(usuario.getEmpleado().getPrimerNombre())
                .segundoNombre(usuario.getEmpleado().getSegundoNombre())
                .primerApellido(usuario.getEmpleado().getPrimerApellido())
                .segundoApellido(usuario.getEmpleado().getSegundoApellido())
                .correo(usuario.getEmpleado().getCorreo())
                .telefono(usuario.getEmpleado().getTelefono())
                .build();

        EmpleadoEntity savedEmpleado = empleadoRepository.save(empleadoEntity);
        log.debug("Created Empleado entity with ID: {}", savedEmpleado.getId());
        return savedEmpleado;
    }

    /**
     * Creates an Administrador entity
     */
    private AdministradorEntity createAdministradorEntity(Usuario usuario) {
        // Create an Administrador entity
        // Enhanced by extracting additional info from the Usuario
        AdministradorEntity administradorEntity = AdministradorEntity.builder()
                .primerNombre(usuario.getAdministrador().getPrimerNombre())
                .segundoNombre(usuario.getAdministrador().getSegundoNombre())
                .primerApellido(usuario.getAdministrador().getPrimerApellido())
                .segundoApellido(usuario.getAdministrador().getSegundoApellido())
                .correo(usuario.getAdministrador().getCorreo())
                .telefono(usuario.getAdministrador().getTelefono())
                .build();

        AdministradorEntity savedAdministrador = administradorRepository.save(administradorEntity);
        log.debug("Created Administrador entity with ID: {}", savedAdministrador.getId());
        return savedAdministrador;
    }

    /**
     * Creates an AdministradorGeneral entity
     */
    private AdministradorGeneralEntity createAdministradorGeneralEntity(Usuario usuario) {
        // Create an Administrador entity
        // Enhanced by extracting additional info from the Usuario
        AdministradorGeneralEntity adminGeneralEntity = AdministradorGeneralEntity.builder()
                .primerNombre(usuario.getAdministradorGeneral().getPrimerNombre())
                .segundoNombre(usuario.getAdministradorGeneral().getSegundoNombre())
                .primerApellido(usuario.getAdministradorGeneral().getPrimerApellido())
                .segundoApellido(usuario.getAdministradorGeneral().getSegundoApellido())
                .correo(usuario.getAdministradorGeneral().getCorreo())
                .telefono(usuario.getAdministradorGeneral().getTelefono())
                .build();

        AdministradorGeneralEntity savedAdminGeneral = administradorGeneralRepository.save(adminGeneralEntity);
        log.debug("Created AdministradorGeneral entity with ID: {}", savedAdminGeneral.getId());
        return savedAdminGeneral;
    }

    // Sets the appropriate foreign key relationship in the UsuarioEntity
    // This method uses the Type Safety principle - we cast only after checking the role
    private void setRoleSpecificRelationship(UsuarioEntity usuarioEntity, Object roleEntity, String rol) {
        switch (rol) {
            case Rol.USUARIO:
                break;
            case Rol.CLIENTE:
                usuarioEntity.setCliente((ClienteEntity) roleEntity);
                break;
            case Rol.EMPLEADO:
                usuarioEntity.setEmpleado((EmpleadoEntity) roleEntity);
                break;
            case Rol.ADMINISTRADOR:
                usuarioEntity.setAdministrador((AdministradorEntity) roleEntity);
                break;
            case Rol.ADMINISTRADOR_GENERAL:
                usuarioEntity.setAdministradorGeneral((AdministradorGeneralEntity) roleEntity);
                break;
            default:
                throw new IllegalArgumentException("Invalid role for relationship: " + rol);
        }
    }

    // The rest of your existing methods remain unchanged
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
