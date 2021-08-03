package com.example.projectvelocity.controller;


import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Cliente;
import com.example.projectvelocity.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/")
    public ResponseEntity<String> saveCliente (@RequestBody Cliente cliente){
        ResponseEntity<String> response = null;
        try {
            Long id = clienteService.saveCliente(cliente);
            response = new ResponseEntity<String>(
                    "Cliente '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo guardar el cliente",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return response;
        }

    @GetMapping("/")
    public ResponseEntity<?> getAllClientes(){
        ResponseEntity<?> response = null;
        try{
            List<Cliente> list = clienteService.getAllCliente();
            response = new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los clientes",
                    HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCliente(@PathVariable Long id){
        ResponseEntity<?> response = null;
        try{
            Cliente cliente = clienteService.getOneCliente(id);
            response = new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar el cliente",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteNew){
        ResponseEntity<?> response = null;
        try{
            clienteService.updateCliente(clienteNew, id);
            response = new ResponseEntity<Cliente>(clienteNew, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar el cliente",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            clienteService.deleteCliente(id);
            resp= new ResponseEntity<String> (
                    "Cliente '"+id+"' eliminado",HttpStatus.OK);

        } catch (VelocityException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "No se pudo eliminar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }
}
