package com.example.projectvelocity.service;

import com.example.projectvelocity.model.Rol;

import java.util.List;

public interface RolService {

    Long saveRol(Rol rol);

    void updateRol(Rol rol, Long id);

    void deleteRol(Long id);

    Rol getOneRol(Long id);

    List<Rol> getAllRol();

    boolean isRolExist(Long id);
}