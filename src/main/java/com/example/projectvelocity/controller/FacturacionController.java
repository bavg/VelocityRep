package com.example.projectvelocity.controller;


import com.example.projectvelocity.exception.VelocityException;
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
                    "No se pudo listar las facturaciones",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneFacturacion(@PathVariable Long id){
        ResponseEntity<?> response = null;
        try{
            Facturacion facturacion = facturacionService.getOneFacturacion(id);
            response = new ResponseEntity<Facturacion>(facturacion, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar la facturacion",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFacturacion(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            facturacionService.deleteFacturacion(id);
            resp= new ResponseEntity<String> (
                    "Facturacion '"+id+"' eliminada",HttpStatus.OK);

        } catch (VelocityException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "No se pudo eliminar la facturacion", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }


}