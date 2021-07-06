package com.example.projectvelocity.service;

import com.example.projectvelocity.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Long saveUsuario(Usuario Usuario);

    void updateUsuario(Usuario Usuario);

    void deleteUsuario(Long id);

    Usuario getOneUsuario(Long id);

    List<Usuario> getAllUsuarios();

    boolean isUsuarioExist(Long id);
}