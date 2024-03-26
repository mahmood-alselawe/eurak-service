package com.takarub.departmentservice.out;


import com.takarub.departmentservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("employee/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable Long departmentId);
}
