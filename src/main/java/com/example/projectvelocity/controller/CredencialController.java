package com.example.projectvelocity.controller;


import com.example.projectvelocity.model.Credencial;
import com.example.projectvelocity.service.CredencialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Credencial")
public class CredencialController {

    @Autowired
    private CredencialService credencialService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveCredencial(@RequestBody Credencial credencial){
        ResponseEntity<String> response = null;
        try {
            Long id = credencialService.saveCredencial(credencial);
            response = new ResponseEntity<String>(
                    "Credencial '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo guardar la credencial",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAllCredenciales(){
        ResponseEntity<?> response = null;
        try{
            List<Credencial> list = credencialService.getAllCredencial();
            response = new ResponseEntity<List<Credencial>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar las credenciales",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


}