package com.mapping.jpamapping.repositories;

import com.mapping.jpamapping.entities.DepartmentEntity;
import com.mapping.jpamapping.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByManager(EmployeeEntity employeeEntity);
}
