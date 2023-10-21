package com.pmoro.employeelist.controller;

import com.pmoro.employeelist.domain.model.MaintenanceSupervisor;
import com.pmoro.employeelist.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supervisors")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;

    @GetMapping
    public ResponseEntity<List<MaintenanceSupervisor>> findAllSupervisor(){
        List<MaintenanceSupervisor> supervisorList = supervisorService.listSupervisor();
        return ResponseEntity.ok(supervisorList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<MaintenanceSupervisor>> findSupervisorById(@PathVariable Integer id){
        var supervisor = supervisorService.findSupervisor(id);
        return ResponseEntity.ok(supervisor);
    }

    @PostMapping
    public ResponseEntity<Optional<MaintenanceSupervisor>> createSupervisor(@RequestBody MaintenanceSupervisor supervisorToCreate){
        var supervisorCreated = supervisorService.createSupervisor(supervisorToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(supervisorCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(Optional.of(supervisorCreated));
    }


}
