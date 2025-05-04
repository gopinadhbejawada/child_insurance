package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    List<Employee> findByDepartmentId(Long departmentId);
    
    @Query("SELECT e FROM Employee e WHERE e.dateOfJoining > :date")
    List<Employee> findEmployeesJoinedAfter(LocalDate date);
}