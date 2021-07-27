package com.example.projectvelocity.service;

import com.example.projectvelocity.model.Plan;

import java.util.List;

public interface PlanService {

    Long savePlan(Plan plan);

    void updatePlan(Plan plan);

    void deletePlan(Long id);

    Plan getOnePlan(Long id);

    List<Plan> getAllPlan();

    boolean isPlanExist(Long id);
}