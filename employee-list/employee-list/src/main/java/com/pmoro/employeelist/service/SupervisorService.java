package com.pmoro.employeelist.service;

import com.pmoro.employeelist.domain.model.MaintenanceSupervisor;

import java.util.List;
import java.util.Optional;

public interface SupervisorService {
    MaintenanceSupervisor createSupervisor(MaintenanceSupervisor supervisorToCreate);

    Optional<MaintenanceSupervisor> findSupervisor(Integer id);

    List<MaintenanceSupervisor> listSupervisor();
}
