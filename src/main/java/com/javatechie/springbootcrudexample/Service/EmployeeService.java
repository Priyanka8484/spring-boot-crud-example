package com.javatechie.springbootcrudexample.Service;

import com.javatechie.springbootcrudexample.Entity.Employee;
import com.javatechie.springbootcrudexample.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Long saveEmployee(Employee employee){
        Employee empObj= employeeRepository.save(employee);
        return empObj.getId();
    }
    public List<Employee> saveEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }
    public Employee getById(Long empId){
        return employeeRepository.findById(empId).orElse(null);
    }
    public Employee getByName(String name){
        return employeeRepository.findByName(name);
    }
    public String delete(Long id){
        employeeRepository.deleteById(id);
        return "product removed !! " + id;
    }
    public Employee update(Employee existingEmployee,Employee updatedEmployeeData){
       // Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        //check if empl existing, if yes update emp with new data
        //else send status or false and construct response in controller
        existingEmployee.setName(updatedEmployeeData.getName());
        existingEmployee.setDesignation(updatedEmployeeData.getDesignation());
        return employeeRepository.save(updatedEmployeeData);
    }
}
