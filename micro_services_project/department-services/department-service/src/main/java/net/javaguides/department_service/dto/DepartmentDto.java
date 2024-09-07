package net.javaguides.department_service.dto;

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
        description = "Department DTO Model Information "
)
public class DepartmentDto {
    private  Long id;
    @Schema(
            description = "Department Name"

    )
    private  String departmentName;
    @Schema(
            description = "Department Description "
    )
    private  String DepartmentDescription;
    @Schema(
            description = "Department code "
    )
    private String departmentCode;
}
