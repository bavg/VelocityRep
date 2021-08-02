package com.example.projectvelocity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {


    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Long cantidad;
    private Long precio;

}
