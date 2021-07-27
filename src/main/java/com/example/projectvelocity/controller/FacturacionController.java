package com.example.projectvelocity.controller;


import com.example.projectvelocity.model.Facturacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.FacturacionService;

import java.util.List;

@RestController
@RequestMapping("/Facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionService facturacionService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveFacturacion(@RequestBody Facturacion Facturacion){
        ResponseEntity<String> response = null;
        try {
            Long id = facturacionService.saveFacturacion(Facturacion);
            response = new ResponseEntity<String>(
                    "Facturacion '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo guardar el Facturacion",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAllFacturacions(){
        ResponseEntity<?> response = null;
        try{
            List<Facturacion> list = facturacionService.getAllFacturacion();
            response = new ResponseEntity<List<Facturacion>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los Facturacions",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


}