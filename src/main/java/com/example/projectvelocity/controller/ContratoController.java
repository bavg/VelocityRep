package com.example.projectvelocity.controller;


import com.example.projectvelocity.exception.VelocityException;
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

    @PostMapping("/")
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

    @GetMapping("/")
    public ResponseEntity<?> getAllContratos(){
        ResponseEntity<?> response = null;
        try{
            List<Contrato> list = contratoService.getAllContrato();
            response = new ResponseEntity<List<Contrato>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los contratos",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneContrato(@PathVariable Long id){
        ResponseEntity<?> response = null;
        try{
            Contrato contrato = contratoService.getOneContrato(id);
            response = new ResponseEntity<Contrato>(contrato, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar el contrato",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContrato(@PathVariable Long id, @RequestBody Contrato contratoNew){
        ResponseEntity<?> response = null;
        try{
            contratoService.updateContrato(contratoNew, id);
            response = new ResponseEntity<Contrato>(contratoNew, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar el contrato",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContrato(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            contratoService.deleteContrato(id);
            resp= new ResponseEntity<String> (
                    "Contrato '"+id+"' eliminado",HttpStatus.OK);

        } catch (VelocityException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "No se pudo eliminar el contrato", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }


}
