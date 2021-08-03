package com.example.projectvelocity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordenesTrabajo")
public class OrdenTrabajo {


    @Id
    @GeneratedValue
    private Long id;
    private String tipoDeOrden;
    private String hora;
    private String dia;
}

