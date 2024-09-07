package net.javaguides.organization_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = " Organization Dto Model information"

)
public class OrganizationDto {


    private  Long id;
    @Schema(
            description = "Organization_Name"
    )

    private String organizationName;
    @Schema(
            description = "Organization Description"
    )
    private  String organizationDescription;

    @Schema(
            description = "Organization Code"
    )

    private  String organizationCode;
     @Schema(
             description = "Date"
     )
    private LocalDateTime createDate;

}
