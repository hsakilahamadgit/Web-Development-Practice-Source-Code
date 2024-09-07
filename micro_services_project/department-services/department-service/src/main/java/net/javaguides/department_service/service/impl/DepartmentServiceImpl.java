package net.javaguides.department_service.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.entity.Department;
import net.javaguides.department_service.mapper.DepartmentMapper;
import net.javaguides.department_service.repository.DepartmentRepository;
import net.javaguides.department_service.service.DepartmentService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department= DepartmentMapper.dtoToEntity(departmentDto);
        Department department1=departmentRepository.save(department);
        return DepartmentMapper.entityToDto(department1);
    }

    @Override
    public DepartmentDto getDepartmentById(String departmentCode) {
      Department department=  departmentRepository.findByDepartmentCode(departmentCode);



        return DepartmentMapper.entityToDto(department);
    }

    //dtoToDepartment

}
