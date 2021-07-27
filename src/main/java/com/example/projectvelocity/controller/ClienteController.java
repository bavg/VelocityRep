package com.example.projectvelocity.controller;


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

    @PostMapping("/crear")
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

    @GetMapping("/listar")
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
}
