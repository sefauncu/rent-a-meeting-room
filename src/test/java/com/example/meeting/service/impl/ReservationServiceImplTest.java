package com.example.meeting.service.impl;

import com.example.meeting.repository.ReservationRepository;
import com.example.meeting.testbase.datahelper.ReservationTestDOFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceImplTest {

    protected static ReservationTestDOFactory doFactory;

    @Mock
    private ReservationRepository reservationRepository;
    @InjectMocks
    private ReservationServiceImpl reservationService;

    @Before
    public void setUp() throws Exception {
        ReservationServiceImplTest.doFactory = new ReservationTestDOFactory();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
    }
}