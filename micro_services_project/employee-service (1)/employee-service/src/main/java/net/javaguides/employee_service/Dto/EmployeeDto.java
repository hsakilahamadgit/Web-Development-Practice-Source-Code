package net.javaguides.employee_service.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(
        description = "Employee Dto Model information"
)
public class EmployeeDto {
    private  Long id;
    @Schema(
            description = "first Name"
    )
    private String firstName;
    @Schema(
            description = "last name"
    )
    private String lastName;
    @Schema(
            description = "email"
    )
    private String email;
    @Schema(
            description = "Department Code"
    )
    private String departmentCode;
    @Schema(
            description = "Organization Code"
    )
    private  String organizationCode;
}
