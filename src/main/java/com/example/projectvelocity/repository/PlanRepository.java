package com.example.projectvelocity.repository;

import com.example.projectvelocity.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
