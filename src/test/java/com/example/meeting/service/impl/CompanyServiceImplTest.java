package com.example.meeting.service.impl;

import com.example.meeting.domain.Company;
import com.example.meeting.domain.Province;
import com.example.meeting.dto.CompanyDTO;
import com.example.meeting.repository.CompanyRepository;
import com.example.meeting.repository.ProvinceRepository;
import com.example.meeting.testbase.datahelper.CompanyTestDOFactory;
import com.example.meeting.testbase.datahelper.ProvinceTestDOFactory;
import com.example.meeting.util.MappingHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceImplTest {

    protected static CompanyTestDOFactory doFactory;
    protected static ProvinceTestDOFactory doFactory2;

    @Mock
    private CompanyRepository companyRepository;
    @InjectMocks
    private CompanyServiceImpl companyService;
    @Mock
    private ProvinceRepository provinceRepository;

    @Before
    public void setUp() throws Exception {
        CompanyServiceImplTest.doFactory = new CompanyTestDOFactory();
        CompanyServiceImplTest.doFactory2 = new ProvinceTestDOFactory();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
        List<Company> expected = new ArrayList<>();
        Company company = doFactory.createCompany();
        expected.add(company);
        Mockito.when(companyRepository.findAll()).thenReturn(expected);
        int actual = companyRepository.findAll().size();
        Assert.assertEquals(expected.size(), actual);
    }

    @Test
    public void save() {
        CompanyDTO companyDTO = doFactory.createCompanyDTO();
        Company company = MappingHelper.map(companyDTO, Company.class);
        Mockito.when(provinceRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(doFactory2.createProvince()));
        Mockito.when(companyRepository.save(any(Company.class))).thenReturn(company);
        Long actual = companyService.save(companyDTO);
        Assert.assertEquals(company.getId(), actual);
    }
}