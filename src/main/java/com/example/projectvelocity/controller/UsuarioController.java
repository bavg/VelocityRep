package com.example.projectvelocity.controller;


import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Usuario;
import com.example.projectvelocity.service.CredencialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.UsuarioService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
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

    @GetMapping("/")
    public ResponseEntity<?> getAllUsuarios(){
        ResponseEntity<?> response = null;
        try{
            List<Usuario> list = usuarioService.getAllUsuario();
            response = new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los Usuarios",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneUsuario(@PathVariable Long id){
        ResponseEntity<?> response = null;
        try{
            Usuario usuario = usuarioService.getOneUsuario(id);
            response = new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar el usuario",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            usuarioService.deleteUsuario(id);
            resp= new ResponseEntity<String> (
                    "Usuario '"+id+"' eliminado",HttpStatus.OK);

        } catch (VelocityException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "No se pudo eliminar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }


}