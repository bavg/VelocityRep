package com.example.projectvelocity.service.Impl;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Rol;
import com.example.projectvelocity.repository.RolRepository;
import com.example.projectvelocity.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImplementation implements RolService {

    @Autowired
    private RolRepository rolRepository;


    @Override
    public Long saveRol(Rol Rol) {
        Long id = rolRepository.save(Rol).getId();
        return id;
    }

    @Override
    public void updateRol(Rol Rol, Long id) {
        Rol old = getOneRol(id);
        old.setDescripcionRol(Rol.getDescripcionRol());
        old.setUsuarios(Rol.getUsuarios());
        rolRepository.save(Rol);
    }

    @Override
    public void deleteRol(Long id) {
        Rol Rol = getOneRol(id);
        rolRepository.delete(Rol);
    }

    @Override
    public Rol getOneRol(Long id) {
        Rol Rol = rolRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("Rol  '")
                                .append(id)
                                .append("' no existe")
                                .toString())
                );
        return Rol;
    }

    @Override
    public List<Rol> getAllRol() {
        List<Rol> list = rolRepository.findAll();
        return list;
    }

    @Override
    public boolean isRolExist(Long id) {
        if (rolRepository.existsById(id)){
            return true;
        }
        return false;
    }
}