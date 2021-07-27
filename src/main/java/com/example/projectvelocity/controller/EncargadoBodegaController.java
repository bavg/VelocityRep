package com.example.projectvelocity.controller;

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

    @PostMapping("/crear")
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

    @GetMapping("/listar")
    public ResponseEntity<?> getAllEncargadoBodegas(){
        ResponseEntity<?> response = null;
        try{
            List<EncargadoBodega> list = encargadoBodegaService.getAllEncargadoBodega();
            response = new ResponseEntity<List<EncargadoBodega>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los EncargadoBodegas",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


}