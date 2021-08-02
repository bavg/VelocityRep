package com.example.projectvelocity.controller;


import com.example.projectvelocity.exception.VelocityException;
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

    @PostMapping("/")
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

    @GetMapping("/")
    public ResponseEntity<?> getAllPlans(){
        ResponseEntity<?> response = null;
        try{
            List<Plan> list = planService.getAllPlan();
            response = new ResponseEntity<List<Plan>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar los Plans",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOnePlan(@PathVariable Long id){
        ResponseEntity<?> response = null;
        try{
            Plan plan = planService.getOnePlan(id);
            response = new ResponseEntity<Plan>(plan, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar el plan",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlan(@PathVariable Long id, @RequestBody Plan planNew){
        ResponseEntity<?> response = null;
        try{
            planService.updatePlan(planNew, id);
            response = new ResponseEntity<Plan>(planNew, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<String>(
                    "No se pudo listar el plan",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            planService.deletePlan(id);
            resp= new ResponseEntity<String> (
                    "Plan '"+id+"' eliminado",HttpStatus.OK);

        } catch (VelocityException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "No se pudo eliminar el plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }


}