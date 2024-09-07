package net.javaguides.organization_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.organization_service.dto.OrganizationDto;
import net.javaguides.organization_service.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "Organization-Service OrganizationController",
        description = "Organization Service expose Rest API for Organization Service"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private OrganizationService organizationService;

    @Operation(
            summary = "  SaveOrganization Rest Api  ",
            description = "by using saveOrganization Rest API  to save object in database"
    )
    @ApiResponse(
          responseCode = "201",
            description = "HTTP 200 CREATED"
    )


    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization=organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }
    @Operation(
            summary = " GetOrganization Rest Api  ",
            description = "by using GetOrganization Rest API  to get  object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP 200 Ok"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto>getOrganization(@PathVariable(value = "code") String organizationCode){
      OrganizationDto organizationDto= organizationService.getOrganizationByCode(organizationCode);
      return new ResponseEntity<>(organizationDto,HttpStatus.OK);
    }

}
