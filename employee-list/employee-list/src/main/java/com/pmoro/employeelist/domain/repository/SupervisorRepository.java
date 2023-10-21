package com.pmoro.employeelist.domain.repository;

import com.pmoro.employeelist.domain.model.MaintenanceSupervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorRepository extends JpaRepository<MaintenanceSupervisor, Integer> {
}
