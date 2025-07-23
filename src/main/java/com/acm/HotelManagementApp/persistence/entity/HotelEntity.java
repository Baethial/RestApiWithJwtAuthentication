package com.acm.HotelManagementApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelEntity implements Serializable {

   @Id
   @Column(name = "id_hotel")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String nombre;
   private String ciudad;
   private String telefono;
   private String correo;
   private String direccion;

   @OneToMany(mappedBy = "hotel")
   @JsonManagedReference("hotel-habitaciones")
   private List<HabitacionEntity> habitaciones = new ArrayList<>();
}