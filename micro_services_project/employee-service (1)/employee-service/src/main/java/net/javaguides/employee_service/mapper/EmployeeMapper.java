package net.javaguides.employee_service.mapper;

import net.javaguides.employee_service.Dto.EmployeeDto;
import net.javaguides.employee_service.entity.Employee;

public class EmployeeMapper {
    public static Employee dtoToEntity(EmployeeDto employeeDto){
        Employee employee=new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartmentCode(employeeDto.getDepartmentCode());
        employee.setOrganizationCode(employeeDto.getOrganizationCode());
        return employee;
    }
    public  static EmployeeDto EntityToDto(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDepartmentCode(employee.getDepartmentCode());
        employeeDto.setOrganizationCode(employee.getOrganizationCode());
        return employeeDto;
    }
}
