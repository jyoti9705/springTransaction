package com.example.springtransaction.serviceImpl;

import com.example.springtransaction.entity.Department;
import com.example.springtransaction.entity.Employee;
import com.example.springtransaction.repository.DepartmentRepository;
import com.example.springtransaction.repository.EmployeeRepository;
import com.example.springtransaction.service.EmployeeService;
import com.example.springtransaction.vo.SaveEmployeeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    @Transactional
    public Optional<Employee> saveEmployee(SaveEmployeeRequestDTO saveEmployeeRequestDTO) {
        Department department = Department.builder().name(saveEmployeeRequestDTO.getDepartmentName()).build();
        /**
         * Properly working code
         */
        Optional<Employee> savedEmployeeOptional = Optional.ofNullable(departmentRepository.save(department)).map(department1 -> employeeRepository.save(Employee.builder().department(department)
                .email(saveEmployeeRequestDTO.getEmployeeEmail()).name(saveEmployeeRequestDTO.getEmployeeName()).build()));

        /**
         * Breaking code by passing Employee as null to save without transaction annotation to note findings
         *Findings before adding Transaction annotation
         *  1. Data was added in the Department table but was not added in Employee table
         *  2. Above is the situation we want to avoid
         *  3. We can either all updates should happen or none of them
         *
         * Findings after adding Transactional Annotation
         *  1. No data was added both in Department and Employee table
         */
        //Optional<Employee> savedEmployeeOptional = Optional.ofNullable(departmentRepository.save(department)).map(department1 -> employeeRepository.save(null));

        return savedEmployeeOptional;
    }
}
