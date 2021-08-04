package com.example.projectvelocity.service.Impl;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Supervisor;
import com.example.projectvelocity.repository.SupervisorRepository;
import com.example.projectvelocity.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorServiceImplementation implements SupervisorService {

    @Autowired
    private SupervisorRepository supervisorRepository;


    @Override
    public Long saveSupervisor(Supervisor Supervisor) {
        Long id = supervisorRepository.save(Supervisor).getId();
        return id;
    }

    @Override
    public void updateSupervisor(Supervisor supervisor, Long id) {
        Supervisor old = getOneSupervisor(id);
        old.setNombre(supervisor.getNombre());
        old.setApellido(supervisor.getApellido());
        old.setCorreo(supervisor.getCorreo());
        old.setDireccion(supervisor.getDireccion());
        old.setFechaNacimiento(supervisor.getFechaNacimiento());
        old.setRut(supervisor.getRut());
        old.setTelefono(supervisor.getTelefono());
        old.setUsename(supervisor.getUsename());
        old.setPassword(supervisor.getPassword());
        old.setRol(supervisor.getRol());
        old.setPlanes(supervisor.getPlanes());
        supervisorRepository.save(supervisor);
    }

    @Override
    public void deleteSupervisor(Long id) {
        Supervisor Supervisor = getOneSupervisor(id);
        supervisorRepository.delete(Supervisor);
    }

    @Override
    public Supervisor getOneSupervisor(Long id) {
        Supervisor Supervisor = supervisorRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("Supervisor  '")
                                .append(id)
                                .append("' no existe")
                                .toString())
                );
        return Supervisor;
    }

    @Override
    public List<Supervisor> getAllSupervisor() {
        List<Supervisor> list = supervisorRepository.findAll();
        return list;
    }

    @Override
    public boolean isSupervisorExist(Long id) {
        if (supervisorRepository.existsById(id)){
            return true;
        }
        return false;
    }
}