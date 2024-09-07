package net.javaguides.department_service.mapper;

import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.entity.Department;

public class DepartmentMapper {

   /* private static Department dtoToEntity(DepartmentDto departmentDto){
        Department department=new Department();
        department.setId(departmentDto.getId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        return department;
    }*/
    public static DepartmentDto entityToDto(Department department){
        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDepartmentDescription(department.getDepartmentDescription());
        departmentDto.setDepartmentCode(department.getDepartmentCode());
        return departmentDto;
    }

    public static Department dtoToEntity(DepartmentDto departmentDto) {
        Department department=new Department();
        department.setId(departmentDto.getId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        return department;
    }
}
