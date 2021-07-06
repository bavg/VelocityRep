package com.example.projectvelocity.controller;


import com.example.projectvelocity.model.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.ContratoService;

import java.util.List;

@RestController
@RequestMapping("/Contrato")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveContrato(@RequestBody Contrato contrato){
        ResponseEntity<String> response = null;
        try {
            Long id = contratoService.saveContrato(contrato);
            response = new ResponseEntity<String>(
                    "Contrato '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e){
                e.printStackTrace();
                response = new ResponseEntity<String>(
                        "No se pudo guardar el contrato",
                        HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAllContratos(){
        ResponseEntity<?> response = null;
        try{
            List<Contrato> list = contratoService.getAllContratos();
            response = new ResponseEntity<List<Contrato>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los contratos",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


}
