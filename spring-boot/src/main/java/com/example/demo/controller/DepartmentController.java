package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepo;

    @PostMapping
    public Department create(@RequestBody Department department) {
        return departmentRepo.save(department);
    }

    @GetMapping("/moreThan/{n}")
    public List<Department> getDepartmentsWithMoreThan(@PathVariable int n) {
        return departmentRepo.findDepartmentsWithMoreThanNEmployees(n);
    }
}
