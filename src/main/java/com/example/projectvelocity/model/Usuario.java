package com.example.projectvelocity.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements java.io.Serializable{

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String fechaNacimiento;
    private String rut;
    private Long telefono;
    private String username;
    private String password;

    @JsonBackReference(value = "Usuario-Rol")
    @ManyToOne
    @JoinColumn(name="Rol")
    private Rol rol;
}
