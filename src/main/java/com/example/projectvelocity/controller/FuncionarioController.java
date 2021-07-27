
package com.example.projectvelocity.controller;


import com.example.projectvelocity.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/Funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveFuncionario(@RequestBody Funcionario Funcionario){
        ResponseEntity<String> response = null;
        try {
            Long id = funcionarioService.saveFuncionario(Funcionario);
            response = new ResponseEntity<String>(
                    "Funcionario '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo guardar el Funcionario",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAllFuncionarios(){
        ResponseEntity<?> response = null;
        try{
            List<Funcionario> list = funcionarioService.getAllFuncionario();
            response = new ResponseEntity<List<Funcionario>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los Funcionarios",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


}