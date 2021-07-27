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
    public void updateSupervisor(Supervisor Supervisor) {
        supervisorRepository.save(Supervisor);
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