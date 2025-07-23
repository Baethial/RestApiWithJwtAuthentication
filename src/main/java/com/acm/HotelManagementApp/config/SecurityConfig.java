package com.acm.HotelManagementApp.config;

import com.acm.HotelManagementApp.util.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain httpSecurity(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(cors -> cors.configurationSource(configurationSource()))
                .authorizeHttpRequests(auth -> {
                    // Public endpoints for authentication
                    auth.requestMatchers("/api/auth/**").permitAll();

                    // --- ROLE-BASED RULES START HERE ---

                    // Rules for HOTELES
                    auth.requestMatchers(HttpMethod.GET,"/api/hoteles/**").hasAnyRole("USUARIO", "CLIENTE", "EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.POST,"/api/hoteles/**").hasAnyRole("EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.PUT,"/api/hoteles/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/hoteles/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");

                    // Rules for HABITACIONES
                    auth.requestMatchers(HttpMethod.GET,"/api/habitaciones/**").hasAnyRole("USUARIO", "CLIENTE", "EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.POST,"/api/habitaciones/**").hasAnyRole("EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.PUT,"/api/habitaciones/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/habitaciones/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");

                    // Rules for TIPOS_HABITACION
                    auth.requestMatchers(HttpMethod.GET,"/api/tipos_habitacion/**").hasAnyRole("USUARIO", "CLIENTE", "EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.POST,"/api/tipos_habitacion/**").hasAnyRole("EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.PUT,"/api/tipos_habitacion/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/tipos_habitacion/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");

                    // Rules for RESERVAS
                    auth.requestMatchers(HttpMethod.GET,"/api/reservas/**").hasAnyRole("USUARIO", "CLIENTE", "EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.POST,"/api/reservas/**").hasAnyRole("EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.PUT,"/api/reservas/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/reservas/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");

                    // Rules for PAGOS
                    auth.requestMatchers(HttpMethod.GET,"/api/pagos/**").hasAnyRole("USUARIO", "CLIENTE", "EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.POST,"/api/pagos/**").hasAnyRole("EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.PUT,"/api/pagos/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/pagos/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");

                    // Rules for FACTURAS
                    auth.requestMatchers(HttpMethod.GET,"/api/facturas/**").hasAnyRole("USUARIO", "CLIENTE", "EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.POST,"/api/facturas/**").hasAnyRole("EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.PUT,"/api/facturas/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/facturas/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");

                    // Rules for CLIENTES
                    auth.requestMatchers(HttpMethod.GET,"/api/clientes/**").hasAnyRole("USUARIO", "CLIENTE", "EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.POST,"/api/clientes/**").hasAnyRole("EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.PUT,"/api/clientes/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/clientes/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");

                    // Rules for EMPLEADOS
                    auth.requestMatchers(HttpMethod.GET,"/api/empleados/**").hasAnyRole("USUARIO", "CLIENTE", "EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.POST,"/api/empleados/**").hasAnyRole("EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.PUT,"/api/empleados/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/empleados/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");

                    // Rules for ADMINISTRADORES
                    auth.requestMatchers(HttpMethod.GET,"/api/administradores/**").hasAnyRole("USUARIO", "CLIENTE", "EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.POST,"/api/administradores/**").hasAnyRole("EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.PUT,"/api/administradores/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/administradores/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");

                    // Rules for ADMINISTRADORES_GENERALES
                    auth.requestMatchers(HttpMethod.GET,"/api/administradores_generales/**").hasAnyRole("USUARIO", "CLIENTE", "EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.POST,"/api/administradores_generales/**").hasAnyRole("EMPLEADO", "ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.PUT,"/api/administradores_generales/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/administradores_generales/**").hasAnyRole("ADMINISTRADOR", "ADMINISTRADOR_GENERAL");

                    // --- ROLE-BASED RULES END HERE ---

                    // Fallback rule: Any other request must be authenticated.
                    // This should always be the LAST rule.
                    auth.anyRequest().authenticated();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) throws Exception {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public CorsConfigurationSource configurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}