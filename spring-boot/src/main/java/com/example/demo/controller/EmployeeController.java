package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @GetMapping("/department/{deptId}")
    public List<Employee> getByDepartment(@PathVariable Long deptId) {
        return employeeRepo.findByDepartmentId(deptId);
    }

    @GetMapping("/joinedAfter/{year}")
    public List<Employee> joinedAfter(@PathVariable int year) {
        return employeeRepo.findEmployeesJoinedAfter(LocalDate.of(year, 1, 1));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeRepo.deleteById(id);
    }
}