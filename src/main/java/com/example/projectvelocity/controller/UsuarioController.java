package com.example.projectvelocity.controller;


import com.example.projectvelocity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveUsuario(@RequestBody Usuario Usuario){
        ResponseEntity<String> response = null;
        try {
            Long id = usuarioService.saveUsuario(Usuario);
            response = new ResponseEntity<String>(
                    "Usuario '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo guardar el Usuario",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAllUsuarios(){
        ResponseEntity<?> response = null;
        try{
            List<Usuario> list = usuarioService.getAllUsuarios();
            response = new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los Usuarios",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


}