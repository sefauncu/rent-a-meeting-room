package com.example.meeting.testbase.datahelper;

import com.example.meeting.domain.Register;
import com.example.meeting.dto.RegisterDTO;

import java.time.LocalDate;

public class RegisterTestDOFactory {

    public RegisterDTO createRegisterDTO() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setId(1L);
        registerDTO.setCompanyId(1L);
        registerDTO.setCreateDate(LocalDate.now());
        registerDTO.setStatus(true);
        registerDTO.setTitle("Test");
        return registerDTO;
    }

    public Register createRegister() {
        CompanyTestDOFactory doFactory = new CompanyTestDOFactory();
        Register register = new Register();
        register.setId(1L);
        register.setCompany(doFactory.createCompany());
        register.setCreateDate(LocalDate.now());
        register.setStatus(true);
        register.setTitle("Test");
        return register;
    }
}
