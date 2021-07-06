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
public class Plan {

    @Id
    @GeneratedValue
    private Long id;

    private String tipoServicio;
    private Integer precio;
    private String descripcion;
    private String zona;
    private Long idSupervisor;

}
