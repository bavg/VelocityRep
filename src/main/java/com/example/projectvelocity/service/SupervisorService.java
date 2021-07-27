package com.example.projectvelocity.service;

import com.example.projectvelocity.model.Supervisor;

import java.util.List;

public interface SupervisorService {

    Long saveSupervisor(Supervisor supervisor);

    void updateSupervisor(Supervisor supervisor);

    void deleteSupervisor(Long id);

    Supervisor getOneSupervisor(Long id);

    List<Supervisor> getAllSupervisor();

    boolean isSupervisorExist(Long id);
}