package com.takarub.departmentservice.controller;


import com.takarub.departmentservice.model.Department;
import com.takarub.departmentservice.model.Employee;
import com.takarub.departmentservice.out.EmployeeClient;
import com.takarub.departmentservice.repositroy.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("department")
@RequiredArgsConstructor
public class DepartmentController {

    private final EmployeeClient client;

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentRepository repository;


    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: []", department);
        return repository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Department find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department find: id=[]" , id);
        return repository.findById(id);
    }

    @GetMapping("with-employee")
    public List<Department> findAllWithEmployee(){
        LOGGER.info("Department find");

        List<Department> departments = repository.findAll();
        departments.forEach(department -> department.setList(client.findByDepartment(department.getId())));
        return departments;
    }







}
