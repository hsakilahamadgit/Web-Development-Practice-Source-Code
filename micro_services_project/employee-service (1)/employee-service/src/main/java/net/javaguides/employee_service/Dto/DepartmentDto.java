package net.javaguides.employee_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    private String departmentName;
    private  String departmentDescription;
    private  String departmentCode;
}
