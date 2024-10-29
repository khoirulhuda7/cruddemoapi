package com.example.springboot.cruddemo.service;

import com.example.springboot.cruddemo.dao.EmployeeRepository;
import com.example.springboot.cruddemo.dao.EmployeeRepository;
import com.example.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
    public class EmployeeServiceImpl implements EmployeeService {

        private EmployeeRepository employeeRepository;

        // Constructor injection
        public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
            this.employeeRepository = employeeRepository;
        }

        @Override
        public List<Employee> findAll() {
            return employeeRepository.findAll();
        }

        @Override
        public Employee findById(int id) {
            Optional<Employee> result = employeeRepository.findById(id);
            Employee employee = null;

            if (result.isPresent()){
                employee = result.get();
            }else {
                throw new RuntimeException("Employee nya ndak ada - " + id);
            }

            return employee;
        }

        @Transactional
        @Override
        public Employee save(Employee employee) {
            return employeeRepository.save(employee);
        }

        @Transactional
        @Override
        public void deleteById(int id) {
            employeeRepository.deleteById(id);
        }
    }
