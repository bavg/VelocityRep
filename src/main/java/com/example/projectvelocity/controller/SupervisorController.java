package com.example.projectvelocity.controller;


import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Supervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.SupervisorService;

import java.util.List;

@RestController
@RequestMapping("/Supervisor")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveSupervisor(@RequestBody Supervisor Supervisor){
        ResponseEntity<String> response = null;
        try {
            Long id = supervisorService.saveSupervisor(Supervisor);
            response = new ResponseEntity<String>(
                    "Supervisor '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo guardar el Supervisor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAllSupervisors(){
        ResponseEntity<?> response = null;
        try{
            List<Supervisor> list = supervisorService.getAllSupervisor();
            response = new ResponseEntity<List<Supervisor>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los Supervisors",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupervisor(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            supervisorService.deleteSupervisor(id);
            resp= new ResponseEntity<String> (
                    "Supervisor '"+id+"' eliminado",HttpStatus.OK);

        } catch (VelocityException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "No se pudo eliminar el supervisor", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }


}