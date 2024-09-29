package com.spring.chapter_2.Controllers;

import com.spring.chapter_2.Entities.EmployeeEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "audit")
public class EmployeeAuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping(path = "employee/{employeeId}")
    List<EmployeeEntity> getEmployeeRevisions(@PathVariable Long employeeId)
    {
        AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> revisions = reader.getRevisions(EmployeeEntity.class , employeeId);
        return revisions
                .stream()
                .map(revisionNumber ->
                        reader.find(EmployeeEntity.class , employeeId , revisionNumber))
                .collect(Collectors.toList());
    }
}
