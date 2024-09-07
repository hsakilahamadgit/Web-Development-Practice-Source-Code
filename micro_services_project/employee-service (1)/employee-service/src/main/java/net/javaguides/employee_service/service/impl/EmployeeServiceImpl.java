package net.javaguides.employee_service.service.impl;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.javaguides.employee_service.Dto.APIResponseDto;
import net.javaguides.employee_service.Dto.DepartmentDto;
import net.javaguides.employee_service.Dto.EmployeeDto;
import net.javaguides.employee_service.Dto.OrganizationDto;
import net.javaguides.employee_service.entity.Employee;
import net.javaguides.employee_service.mapper.EmployeeMapper;
import net.javaguides.employee_service.repository.EmployeeRepository;
import net.javaguides.employee_service.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private  static  final Logger LOGGER= LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;
// method 1 injecting RestClient object
   // private RestTemplate restTemplate;
    // method 2 injecting webClient Object
   private WebClient webClient;

    // method 3 using spring cloud feign client
   // private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee=EmployeeMapper.dtoToEntity(employeeDto);
       Employee employee1= employeeRepository.save(employee);

        return EmployeeMapper.EntityToDto(employee1);
    }

    //@CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod ="getDefaultDepartment" )
    @Override
    public APIResponseDto getEmployee(long id) {
        LOGGER.info("inside getEmployee() method");
       Optional<Employee>optionalEmployee = employeeRepository.findById(id);
       Employee employee=optionalEmployee.orElseThrow(()->new RuntimeException("no such id is found"));
        System.out.println("emp--->"+employee.getOrganizationCode());
       EmployeeDto employeeDto=EmployeeMapper.EntityToDto(employee);
       //provide communication by using restTemplate
      //ResponseEntity<DepartmentDto> responseEntity =restTemplate.getForEntity("http://localhost:8080/api/department/"+employee.getDepartmentCode(), DepartmentDto.class);
       //DepartmentDto departmentDto=responseEntity.getBody();

        // using webclient
        DepartmentDto departmentDto=webClient.get()
                .uri("http://localhost:8080/api/department/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        OrganizationDto organizationDto=webClient.get()
                .uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        // using feign client
       /* DepartmentDto departmentDto=apiClient.getDepartmentByCode(employee.getDepartmentCode());*/
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto;

    }
    public APIResponseDto getDefaultDepartment(long id,Exception exception) {

        LOGGER.info("inside getDefaultDepartment() method");
        Optional<Employee>optionalEmployee = employeeRepository.findById(id);
        Employee employee=optionalEmployee.orElseThrow(()->new RuntimeException("no such id is found"));
        EmployeeDto employeeDto= EmployeeMapper.EntityToDto(employee);
        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and development Department");
        // using webclient


        // using feign client
        /* DepartmentDto departmentDto=apiClient.getDepartmentByCode(employee.getDepartmentCode());*/
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;



    }



}
