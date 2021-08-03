package com.example.projectvelocity.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facturaciones")
public class Facturacion {


    @Id
    @GeneratedValue
    private Long id;
    private int numeroFactura;
    private int monto;
    private String fecha;

    @JsonBackReference(value = "Cliente-Facturacion")
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @JsonManagedReference(value = "Facturacion-Contrato")
    @OneToOne(mappedBy = "facturacion")
    private Contrato contrato;

}