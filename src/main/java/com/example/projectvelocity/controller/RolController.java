package com.example.projectvelocity.controller;


import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.RolService;

import java.util.List;

@RestController
@RequestMapping("/Rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveRol(@RequestBody Rol Rol){
        ResponseEntity<String> response = null;
        try {
            Long id = rolService.saveRol(Rol);
            response = new ResponseEntity<String>(
                    "Rol '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo guardar el Rol",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAllRols(){
        ResponseEntity<?> response = null;
        try{
            List<Rol> list = rolService.getAllRol();
            response = new ResponseEntity<List<Rol>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los Rols",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRol(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            rolService.deleteRol(id);
            resp= new ResponseEntity<String> (
                    "Rol '"+id+"' eliminado",HttpStatus.OK);

        } catch (VelocityException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "No se pudo eliminar el rol", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }


}