package com.example.projectvelocity.controller;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.EncargadoBodega;
import com.example.projectvelocity.service.EncargadoBodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EncargadoBodega")
public class EncargadoBodegaController {

    @Autowired
    private EncargadoBodegaService encargadoBodegaService;

    @PostMapping("/")
    public ResponseEntity<String> saveEncargadoBodega(@RequestBody EncargadoBodega EncargadoBodega){
        ResponseEntity<String> response = null;
        try {
            Long id = encargadoBodegaService.saveEncargadoBodega(EncargadoBodega);
            response = new ResponseEntity<String>(
                    "EncargadoBodega '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo guardar el EncargadoBodega",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllEncargadoBodegas(){
        ResponseEntity<?> response = null;
        try{
            List<EncargadoBodega> list = encargadoBodegaService.getAllEncargadoBodega();
            response = new ResponseEntity<List<EncargadoBodega>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los encargado de bodegas",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneEncargadoBodega(@PathVariable Long id){
        ResponseEntity<?> response = null;
        try{
            EncargadoBodega encargadoBodega = encargadoBodegaService.getOneEncargadoBodega(id);
            response = new ResponseEntity<EncargadoBodega>(encargadoBodega, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar el encargadoBodega",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEncargadoBodega(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            encargadoBodegaService.deleteEncargadoBodega(id);
            resp= new ResponseEntity<String> (
                    "EncargadoBodega '"+id+"' eliminado",HttpStatus.OK);

        } catch (VelocityException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "No se pudo eliminar el encargadoBodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }


}