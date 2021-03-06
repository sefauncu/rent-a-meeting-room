package com.example.meeting.testbase.datahelper;

import com.example.meeting.domain.Company;
import com.example.meeting.dto.CompanyDTO;

public class CompanyTestDOFactory {

    public CompanyDTO createCompanyDTO() {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(1L);
        companyDTO.setName("Test");
        companyDTO.setLocationId(1L);
        companyDTO.setTotalEmployeeNumber(10);
        return companyDTO;
    }

    public CompanyDTO saveCompanyDTO() {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(null);
        companyDTO.setName("Test");
        companyDTO.setLocationId(1L);
        companyDTO.setTotalEmployeeNumber(10);
        return companyDTO;
    }

    public Company createCompany() {
        ProvinceTestDOFactory doFactory = new ProvinceTestDOFactory();
        Company company = new Company();
        company.setId(1L);
        company.setName("Test");
        company.setLocation(doFactory.createProvince());
        company.setTotalEmployeeNumber(10);
        return company;
    }

}
