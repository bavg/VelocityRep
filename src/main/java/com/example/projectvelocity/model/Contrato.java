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
    private String fecha;
    private String fechaVencimiento;
    private String estadoPago;
    private String ultimaFechaPagado;

    @ManyToMany
    @JoinTable(
            name = "contrato_detalle",
            joinColumns = @JoinColumn(name = "contrato_id",referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name= "planes_id",referencedColumnName="id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"contrato_id", "planes_id"})}
    )
    private List<Plan> planes;

    @JsonBackReference(value = "Funcionario-Contrato")
    @ManyToOne
    @JoinColumn(name = "funcionario")
    private Funcionario funcionario;

    @JsonBackReference(value = "Cliente-Contrato")
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;
}
