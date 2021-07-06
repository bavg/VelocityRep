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
public class Contrato {

    @Id
    @GeneratedValue
    private Long id;
    private String direccion;
    private String fechaVencimiento;
    private String estadoPago;
    private String ultimaFechaPagado;
    private Long idPlan;
    private Long idCliente;
}
