package com.javatechie.springbootcrudexample.Controller;

import com.javatechie.springbootcrudexample.Entity.Employee;
import com.javatechie.springbootcrudexample.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path="",method = RequestMethod.POST)
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
    {
        Long id= employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).header(HttpHeaders.LOCATION, "/api/emplyee"+id).build();
    }
    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees)
    {
        return employeeService.saveEmployees(employees);
    }
    @GetMapping("")
    public List<Employee> findAllEmployee(){
        return employeeService.getEmployee();
    }
    //api/employee/102 --path param
    @GetMapping(path="/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long empId)
    {
        Employee employee= employeeService.getById(empId);
        if(employee==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee).build();
    }
///api/employee/search?param="john" --request param

    @GetMapping("/search")
    public Employee getByName(@RequestParam(name = "param",required = false) String name)
    {
        return employeeService.getByName(name);
    }

    @PutMapping("/id")
    public Employee updateEmployee(@PathVariable Long empId,@RequestBody Employee updatedEmployeeData)  {
        //get empByID
        //if its data is there update else send not found
        Employee existingEmployee= employeeService.getById(empId);
       /* if(existingEmployee==null){
            return ResponseEntity.notFound().build();
        }
        //return ResponseEntity.ok().body(employee);
        return employeeService.update(existingEmployee,updatedEmployeeData);*/
        return existingEmployee;
    }
    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable Long empId)
    {
        return employeeService.delete(empId);
    }
}
