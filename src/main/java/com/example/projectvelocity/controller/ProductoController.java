package com.example.projectvelocity.controller;


import com.example.projectvelocity.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/Producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveProducto(@RequestBody Producto Producto){
        ResponseEntity<String> response = null;
        try {
            Long id = productoService.saveProducto(Producto);
            response = new ResponseEntity<String>(
                    "Producto '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo guardar el Producto",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAllProductos(){
        ResponseEntity<?> response = null;
        try{
            List<Producto> list = productoService.getAllProducto();
            response = new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los Productos",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


}