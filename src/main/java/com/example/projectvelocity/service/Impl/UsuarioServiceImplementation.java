package com.example.projectvelocity.service.Impl;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Usuario;
import com.example.projectvelocity.repository.UsuarioRepository;
import com.example.projectvelocity.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Long saveUsuario(Usuario usuario) {
        Long id = usuarioRepository.save(usuario).getId();
        return id;
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        Usuario usuario = getOneUsuario(id);
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario getOneUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("Usuario  '")
                                .append(id)
                                .append("' no existe")
                                .toString())
                );
        return usuario;
    }

    @Override
    public List<Usuario> getAllUsuario() {
        List<Usuario> list = usuarioRepository.findAll();
        return list;
    }

    @Override
    public boolean isUsuarioExist(Long id) {
        if (usuarioRepository.existsById(id)){
            return true;
        }
        return false;
    }
}
