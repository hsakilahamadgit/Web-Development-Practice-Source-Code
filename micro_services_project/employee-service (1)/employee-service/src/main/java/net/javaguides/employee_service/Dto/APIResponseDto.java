package net.javaguides.employee_service.Dto;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class APIResponseDto {
    private  EmployeeDto employeeDto;
    private  DepartmentDto departmentDto;
    private  OrganizationDto organizationDto;

}
