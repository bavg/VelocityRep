package com.example.projectvelocity.controller;


import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.OrdenTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.OrdenTrabajoService;

import java.util.List;

@CrossOrigin
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
                    "No se pudo guardar la OrdenTrabajo",
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
                    "No se pudo listar las Ordenes de trabajo",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneOrdenTrabajo(@PathVariable Long id){
        ResponseEntity<?> response = null;
        try{
            OrdenTrabajo ordenTrabajo = ordenTrabajoService.getOneOrdenTrabajo(id);
            response = new ResponseEntity<OrdenTrabajo>(ordenTrabajo, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar la orden de trabajo",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrdenTrabajo(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            ordenTrabajoService.deleteOrdenTrabajo(id);
            resp= new ResponseEntity<String> (
                    "Orden de trabajo '"+id+"' eliminada",HttpStatus.OK);

        } catch (VelocityException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "No se pudo eliminar la orden de trabajo", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }


}