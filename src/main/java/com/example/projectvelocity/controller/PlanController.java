package com.example.projectvelocity.controller;


import com.example.projectvelocity.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectvelocity.service.PlanService;

import java.util.List;

@RestController
@RequestMapping("/Plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @PostMapping("/crear")
    public ResponseEntity<String> savePlan(@RequestBody Plan Plan){
        ResponseEntity<String> response = null;
        try {
            Long id = planService.savePlan(Plan);
            response = new ResponseEntity<String>(
                    "Plan '" + id + "' creado", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo guardar el Plan",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAllPlans(){
        ResponseEntity<?> response = null;
        try{
            List<Plan> list = planService.getAllPlans();
            response = new ResponseEntity<List<Plan>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los Plans",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


}