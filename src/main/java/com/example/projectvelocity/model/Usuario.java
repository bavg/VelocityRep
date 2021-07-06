package com.example.projectvelocity.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    private String rut;
    private String nombre;
    private String apellido;
    private String correo;
    private int telefono;
    private String direccion;
    private Long idCredencial;
    private String fechaNacimiento;
}
