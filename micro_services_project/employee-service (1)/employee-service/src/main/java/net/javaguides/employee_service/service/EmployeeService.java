package net.javaguides.employee_service.service;

import net.javaguides.employee_service.Dto.APIResponseDto;
import net.javaguides.employee_service.Dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployee(long id);
}
