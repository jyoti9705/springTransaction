package com.example.springtransaction.service;

import com.example.springtransaction.entity.Employee;
import com.example.springtransaction.vo.SaveEmployeeRequestDTO;

import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> saveEmployee(SaveEmployeeRequestDTO saveEmployeeRequestDTO);
}
