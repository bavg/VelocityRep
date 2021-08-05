package com.example.projectvelocity.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Cliente extends Usuario{

    @OneToMany(mappedBy = "cliente")
    private List<Contrato> contratos;
    //@JsonBackReference

}
