package com.example.projectvelocity.controller;


import com.example.projectvelocity.exception.VelocityException;
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

    @PostMapping("/")
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

    @GetMapping("/")
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCredencial(@PathVariable Long id){
        ResponseEntity<?> response = null;
        try{
            Credencial credencial = credencialService.getOneCredencial(id);
            response = new ResponseEntity<Credencial>(credencial, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar la credencial",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCredencial(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            credencialService.deleteCredencial(id);
            resp= new ResponseEntity<String> (
                    "Credencial '"+id+"' eliminada",HttpStatus.OK);

        } catch (VelocityException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "No se pudo eliminar la credencial", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }


}