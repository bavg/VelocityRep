package com.example.projectvelocity.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credenciales")
public class Credencial {


    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
}
