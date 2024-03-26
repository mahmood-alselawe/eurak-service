package com.takarub.employeeservice.reposoitry;

import com.takarub.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> list = new ArrayList<>();

    public Employee add(Employee employee){
        list.add(employee);
        return employee;

    }
    public Employee findById(Long id){
        return list.stream().filter(a -> a.id().equals(id)).findFirst().orElseThrow();
    }

    public List<Employee> findAll(){
        return list;
    }

    public List<Employee> findByDepartment(Long departmentId){
        return list.stream().filter(a -> a.departmentId().equals(departmentId)).toList();
    }


}
