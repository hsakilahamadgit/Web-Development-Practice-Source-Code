package net.javaguides.department_service.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = " Department-Service DepartmentController",
        description = "Department Controller Exposes REST APIs for Department Service "
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    @Operation(
            summary = "save Department REST API",
            description = "save Department  REST API is used to save department object in database "
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED "
    )
    @PostMapping
    public ResponseEntity<DepartmentDto>SaveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department=departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @Operation(
            summary = "get Department REST API",
            description = "get Department  REST API is used to get department object in database "
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK "
    )

    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDto>getDepartmentByCode(@PathVariable(value = "code") String departmentCode){
     DepartmentDto department=   departmentService.getDepartmentById(departmentCode);
     return  new ResponseEntity<>(department, HttpStatus.OK);
    }


}
