package com.takarub.employeeservice.controller;

import com.takarub.employeeservice.model.Employee;
import com.takarub.employeeservice.reposoitry.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private static  final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeRepository repository;


    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}" , employee);
        return repository.add(employee);
    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("Employee find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("Employee find: id={}",id);
        return  repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable Long departmentId){
        LOGGER.info("Employee find: departmentId={}",departmentId);
        return  repository.findByDepartment(departmentId);
    }








}
