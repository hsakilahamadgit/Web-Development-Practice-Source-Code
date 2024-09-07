package net.javaguides.organization_service.service.serviceImpl;

import lombok.AllArgsConstructor;
import net.javaguides.organization_service.dto.OrganizationDto;
import net.javaguides.organization_service.entity.Organization;
import net.javaguides.organization_service.mapper.OrganizationMapper;
import net.javaguides.organization_service.repository.OrganizationRepository;
import net.javaguides.organization_service.service.OrganizationService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization= OrganizationMapper.mapToDtoToOrganization(organizationDto);
        Organization savedOrganization=organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationToDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization=organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationToDto(organization);
    }
}
