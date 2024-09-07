package net.javaguides.organization_service.mapper;

import net.javaguides.organization_service.dto.OrganizationDto;
import net.javaguides.organization_service.entity.Organization;

public class OrganizationMapper {
    public static OrganizationDto mapToOrganizationToDto(Organization organization){
        OrganizationDto organizationDto=new OrganizationDto(organization.getId()
                ,organization.getOrganizationName()
                ,organization.getOrganizationDescription()
                ,organization.getOrganizationCode(),
                organization.getCreateDate());
        return organizationDto;

    }
    public static Organization mapToDtoToOrganization(OrganizationDto organizationDto){
        Organization organization=new Organization(organizationDto.getId()
                ,organizationDto.getOrganizationName()
                ,organizationDto.getOrganizationDescription()
                ,organizationDto.getOrganizationCode()
               ,organizationDto.getCreateDate());
        return  organization;
    }
}
