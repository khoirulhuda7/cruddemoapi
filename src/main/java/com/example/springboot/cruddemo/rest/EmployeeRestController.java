package com.example.springboot.cruddemo.rest;

import com.example.springboot.cruddemo.entity.Employee;
import com.example.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // Constructor injection
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET all employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // GET employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee ID not found - " + employeeId);
        }
        return employee;
    }

    // POST a new employee
    @PostMapping("/employees")
    public Employee tambahKuli(@RequestBody Employee employee) {
        // Set id to 0 to force a save of new item
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    // PUT update existing employee
    @PutMapping("/employees")
    public Employee editKuli(@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    // DELETE employee by id
    @DeleteMapping("/employees/{employeeId}")
    public String bunuhKuli(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee ID not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted Kuli with ID - " + employeeId;
    }
}
