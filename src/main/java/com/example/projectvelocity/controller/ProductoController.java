package com.example.projectvelocity.controller;


import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.ProductoService;

import java.util.List;

@CrossOrigin
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneProducto(@PathVariable Long id){
        ResponseEntity<?> response = null;
        try{
            Producto producto = productoService.getOneProducto(id);
            response = new ResponseEntity<Producto>(producto, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar el producto",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            productoService.deleteProducto(id);
            resp= new ResponseEntity<String> (
                    "Producto '"+id+"' eliminado",HttpStatus.OK);

        } catch (VelocityException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "No se pudo eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }


}