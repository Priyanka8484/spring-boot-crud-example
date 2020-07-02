package com.javatechie.springbootcrudexample.Repository;

import com.javatechie.springbootcrudexample.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByName(String name);
}
