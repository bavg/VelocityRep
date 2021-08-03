package com.example.projectvelocity.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planes")
public class Plan {

    @Id
    @GeneratedValue
    private Long id;

    private String tipoServicio;
    private Integer precio;
    private String descripcion;
    private String zona;

    @JsonBackReference(value = "Supervisor-Plan")
    @ManyToOne
    @JoinColumn(name = "Supervisor")
    private Supervisor supervisor;


    @JsonBackReference(value = "Contrato-Plan")
    @ManyToMany(mappedBy = "planes")
    private List<Contrato> contratos;

}
