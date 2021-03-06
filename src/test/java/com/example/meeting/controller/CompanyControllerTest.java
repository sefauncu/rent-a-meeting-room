package com.example.meeting.controller;

import com.example.meeting.dto.CompanyDTO;
import com.example.meeting.repository.ProvinceRepository;
import com.example.meeting.testbase.datahelper.CompanyTestDOFactory;
import com.example.meeting.testbase.datahelper.ProvinceTestDOFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private CompanyController companyController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProvinceRepository provinceRepository;

    protected static CompanyTestDOFactory companyTestDOFactory;
    protected static ProvinceTestDOFactory provinceTestDOFactory;

    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        this.objectMapper = new ObjectMapper();
        CompanyControllerTest.companyTestDOFactory = new CompanyTestDOFactory();
        CompanyControllerTest.provinceTestDOFactory = new ProvinceTestDOFactory();
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void contextLoads() {
        assertThat(companyController).isNotNull();
    }

    @Test
    public void save() throws Exception {

        CompanyDTO company = companyTestDOFactory.saveCompanyDTO();
        String requestBody = this.objectMapper.writeValueAsString(company);
        Mockito.when(provinceRepository.findById(company.getLocationId())).thenReturn(Optional.of(provinceTestDOFactory.createProvince()));


        this.mockMvc.perform(post("/api/company/company")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void save_not_acceptable() throws Exception {

        CompanyDTO company = companyTestDOFactory.createCompanyDTO();
        String requestBody = this.objectMapper.writeValueAsString(company);


        this.mockMvc.perform(post("/api/company/company")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isNotAcceptable());
    }
}