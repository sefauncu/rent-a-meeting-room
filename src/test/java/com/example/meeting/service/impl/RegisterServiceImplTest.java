package com.example.meeting.service.impl;

import com.example.meeting.constants.MeetingBusinessRule;
import com.example.meeting.domain.Register;
import com.example.meeting.dto.RegisterDTO;
import com.example.meeting.exception.MeetingBusinessException;
import com.example.meeting.repository.CompanyRepository;
import com.example.meeting.repository.RegisterRepository;
import com.example.meeting.testbase.datahelper.CompanyTestDOFactory;
import com.example.meeting.testbase.datahelper.RegisterTestDOFactory;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class RegisterServiceImplTest {

    protected static RegisterTestDOFactory doFactory;
    protected static CompanyTestDOFactory doFactory2;

    @Mock
    private RegisterRepository registerRepository;
    @InjectMocks
    private RegisterServiceImpl registerService;
    @Mock
    private CompanyRepository companyRepository;

    @Before
    public void setUp() throws Exception {
        RegisterServiceImplTest.doFactory = new RegisterTestDOFactory();
        RegisterServiceImplTest.doFactory2 = new CompanyTestDOFactory();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
        List<Register> expected = new ArrayList<>();
        Register register = doFactory.createRegister();
        expected.add(register);
        Mockito.when(registerRepository.findAll()).thenReturn(expected);
        int actual = registerService.findAll().size();
        Assert.assertEquals(expected.size(), actual);
    }

    @Test
    public void save() {
        RegisterDTO registerDTO = doFactory.createRegisterDTO();
        Register register = MappingHelper.map(registerDTO, Register.class);
        Mockito.when(companyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(doFactory2.createCompany()));
        Mockito.when(registerRepository.save(any(Register.class))).thenReturn(register);
        Long actual = registerService.save(registerDTO);
        Assert.assertEquals(register.getId(), actual);
    }

    @Test
    public void saveFail() {
        try {
            RegisterDTO registerDTO = doFactory.createRegisterDTO();
            registerDTO.setTitle(null);
            registerService.save(registerDTO);
            fail(MeetingBusinessRule.REGISTER_TITLE_NOT_FOUND + "expected but not thrown");
        } catch (MeetingBusinessException ex) {
            assertEquals(MeetingBusinessRule.REGISTER_TITLE_NOT_FOUND.getDescription(), ex.getMessage());
        }
    }
}