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
public class Funcionario extends Usuario{

    @OneToMany(mappedBy = "funcionario")
    private List<Contrato> contratos;
}
