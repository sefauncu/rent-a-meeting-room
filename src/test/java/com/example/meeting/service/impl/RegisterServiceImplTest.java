package com.example.meeting.service.impl;

import com.example.meeting.repository.RegisterRepository;
import com.example.meeting.testbase.datahelper.RegisterTestDOFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RegisterServiceImplTest {

    protected static RegisterTestDOFactory doFactory;

    @Mock
    private RegisterRepository registerRepository;
    @InjectMocks
    private RegisterServiceImpl registerService;

    @Before
    public void setUp() throws Exception {
        RegisterServiceImplTest.doFactory = new RegisterTestDOFactory();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
    }
}