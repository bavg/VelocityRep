package com.example.projectvelocity.service.Impl;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Plan;
import com.example.projectvelocity.repository.PlanRepository;
import com.example.projectvelocity.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImplementation implements PlanService {

    @Autowired
    private PlanRepository planRepository;


    @Override
    public Long savePlan(Plan Plan) {
        Long id = planRepository.save(Plan).getId();
        return id;
    }

    @Override
    public void updatePlan(Plan Plan) {
        planRepository.save(Plan);
    }

    @Override
    public void deletePlan(Long id) {
        Plan Plan = getOnePlan(id);
        planRepository.delete(Plan);
    }

    @Override
    public Plan getOnePlan(Long id) {
        Plan Plan = planRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("Plan  '")
                                .append(id)
                                .append("' no existe")
                                .toString())
                );
        return Plan;
    }

    @Override
    public List<Plan> getAllPlan() {
        List<Plan> list = planRepository.findAll();
        return list;
    }

    @Override
    public boolean isPlanExist(Long id) {
        if (planRepository.existsById(id)){
            return true;
        }
        return false;
    }
}