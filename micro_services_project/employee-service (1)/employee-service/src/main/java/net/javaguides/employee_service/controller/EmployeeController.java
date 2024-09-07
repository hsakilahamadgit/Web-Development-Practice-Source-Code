package net.javaguides.employee_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.employee_service.Dto.APIResponseDto;
import net.javaguides.employee_service.Dto.EmployeeDto;
import net.javaguides.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
@Tag(
        name = "Employee-Service Controller",
        description = "Employee-Service controller Expose Api for Employee Service "
)
public class EmployeeController {
    private EmployeeService employeeService;


    @Operation(
            description = "Save Employee save the object in dataBase"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Created"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){

       EmployeeDto employeeDto1= employeeService.saveEmployee(employeeDto);
       return  new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }
    @Operation(
            description = "Save Employee save the object in dataBase"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP OK"
    )
    @GetMapping("/{id}")
     public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long id){
        APIResponseDto getEmp=employeeService.getEmployee(id);
        log.debug("id"+id);
        log.info("");
        return new ResponseEntity<>(getEmp,HttpStatus.OK);
     }
}
