package com.example.meeting.service.impl;

import com.example.meeting.constants.MeetingBusinessRule;
import com.example.meeting.domain.Company;
import com.example.meeting.domain.Province;
import com.example.meeting.dto.CompanyDTO;
import com.example.meeting.exception.MeetingBusinessException;
import com.example.meeting.repository.CompanyRepository;
import com.example.meeting.repository.ProvinceRepository;
import com.example.meeting.service.CompanyService;
import com.example.meeting.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    private void validate(CompanyDTO companyDTO) {
        if (companyDTO.getName() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.COMPANY_NAME_NOT_FOUND.getDescription());
        }
        if (companyDTO.getLocationId() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.PROVINCE_NOT_FOUND.getDescription());
        }
        if (companyDTO.getTotalEmployeeNumber() == null || companyDTO.getTotalEmployeeNumber() <= 0) {
            throw new MeetingBusinessException(MeetingBusinessRule.TOTAL_EMPLOYEE_NUMBER_INVALID.getDescription());
        }
        Optional<Province> optionalProvince = provinceRepository.findById(companyDTO.getLocationId());
        if (!optionalProvince.isPresent()) {
            throw new MeetingBusinessException(MeetingBusinessRule.PROVINCE_NOT_FOUND.getDescription());
        }
    }

    @Override
    public List<CompanyDTO> findAll() {
        List<Company> companyList = companyRepository.findAll();
        return MappingHelper.mapList(companyList, CompanyDTO.class);
    }

    @Override
    public Long save(CompanyDTO companyDTO) {
        validate(companyDTO);
        Company company = MappingHelper.map(companyDTO, Company.class);
        return companyRepository.save(company).getId();

    }
}
