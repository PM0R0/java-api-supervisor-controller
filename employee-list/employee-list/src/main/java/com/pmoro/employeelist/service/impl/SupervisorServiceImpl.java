package com.pmoro.employeelist.service.impl;

import com.pmoro.employeelist.domain.model.MaintenanceSupervisor;
import com.pmoro.employeelist.domain.repository.SupervisorRepository;
import com.pmoro.employeelist.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Override
    public MaintenanceSupervisor createSupervisor(MaintenanceSupervisor supervisorToCreate) {
        return supervisorRepository.save(supervisorToCreate);
    }

    @Override
    public MaintenanceSupervisor findSupervisor(Integer id) {
        return supervisorRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<MaintenanceSupervisor> listSupervisor() {
        return supervisorRepository.findAll();
    }

    @Override
    public MaintenanceSupervisor deleteSupervisor(Integer id) {

        if(supervisorRepository.existsById(id)){
            MaintenanceSupervisor supervisorToRemove = findSupervisor(id);
            supervisorRepository.deleteById(id);
            return supervisorToRemove;
        }
        throw new NoSuchElementException();
    }
}
