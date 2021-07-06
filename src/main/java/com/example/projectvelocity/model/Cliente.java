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
public class Cliente {


    @Id
    @GeneratedValue
    private Long id;
    private Long idFuncionario;
    private String rut;
}
