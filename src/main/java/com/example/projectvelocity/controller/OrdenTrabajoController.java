package com.example.projectvelocity.controller;


import com.example.projectvelocity.model.OrdenTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.OrdenTrabajoService;

import java.util.List;

@RestController
@RequestMapping("/OrdenTrabajo")
public class OrdenTrabajoController {

    @Autowired
    private OrdenTrabajoService ordenTrabajoService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveOrdenTrabajo(@RequestBody OrdenTrabajo OrdenTrabajo){
        ResponseEntity<String> response = null;
        try {
            Long id = ordenTrabajoService.saveOrdenTrabajo(OrdenTrabajo);
            response = new ResponseEntity<String>(
                    "OrdenTrabajo '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo guardar el OrdenTrabajo",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAllOrdenTrabajos(){
        ResponseEntity<?> response = null;
        try{
            List<OrdenTrabajo> list = ordenTrabajoService.getAllOrdenTrabajo();
            response = new ResponseEntity<List<OrdenTrabajo>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los OrdenTrabajos",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


}