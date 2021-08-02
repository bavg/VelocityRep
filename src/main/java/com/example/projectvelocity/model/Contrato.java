package com.example.projectvelocity.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue
    private Long id;
    private String direccion;
    private String fechaVencimiento;
    private String estadoPago;
    private String ultimaFechaPagado;

    @ManyToMany
    @JoinColumn(name = "planes")
    private List<Plan> planes;

    @JsonBackReference(value = "Funcionario-Contrato")
    @ManyToOne
    @JoinColumn(name = "funcionario")
    private Funcionario funcionario;

    @JsonBackReference(value = "Facturacion-Contrato")
    @OneToOne
    @JoinColumn(name = "facturacion")
    private Facturacion facturacion;
}
