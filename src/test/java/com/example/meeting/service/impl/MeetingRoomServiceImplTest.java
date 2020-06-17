package com.example.meeting.service.impl;

import com.example.meeting.repository.MeetingRoomRepository;
import com.example.meeting.testbase.datahelper.MeetingRoomTestDOFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MeetingRoomServiceImplTest {

    protected static MeetingRoomTestDOFactory doFactory;

    @Mock
    private MeetingRoomRepository meetingRoomRepository;
    @InjectMocks
    private MeetingRoomServiceImpl meetingRoomService;


    @Before
    public void setUp() throws Exception {
        MeetingRoomServiceImplTest.doFactory = new MeetingRoomTestDOFactory();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
    }
}