package com.example.springtransaction.controller;

import com.example.springtransaction.entity.Employee;
import com.example.springtransaction.service.EmployeeService;
import com.example.springtransaction.service.SavingEmployeeFailed;
import com.example.springtransaction.vo.SaveEmployeeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody SaveEmployeeRequestDTO saveEmployeeRequestDTO) throws SavingEmployeeFailed {
        Optional<Employee> savedEmployee = employeeService.saveEmployee(saveEmployeeRequestDTO);
        if (savedEmployee.isPresent()) {
            return ResponseEntity.ok(savedEmployee.get());
        } else {
            throw new SavingEmployeeFailed();
        }

    }
}
