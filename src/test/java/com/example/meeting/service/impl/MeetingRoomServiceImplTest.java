package com.example.meeting.service.impl;

import com.example.meeting.constants.MeetingBusinessRule;
import com.example.meeting.domain.MeetingRoom;
import com.example.meeting.dto.MeetingRoomDTO;
import com.example.meeting.exception.MeetingBusinessException;
import com.example.meeting.repository.DistrictRepository;
import com.example.meeting.repository.MeetingRoomRepository;
import com.example.meeting.repository.ProvinceRepository;
import com.example.meeting.testbase.datahelper.DistrictTestDOFactory;
import com.example.meeting.testbase.datahelper.MeetingRoomTestDOFactory;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class MeetingRoomServiceImplTest {

    protected static MeetingRoomTestDOFactory doFactory;
    protected static DistrictTestDOFactory doFactory2;
    protected static ProvinceTestDOFactory doFactory3;


    @Mock
    private MeetingRoomRepository meetingRoomRepository;
    @InjectMocks
    private MeetingRoomServiceImpl meetingRoomService;
    @Mock
    private DistrictRepository districtRepository;
    @Mock
    private ProvinceRepository provinceRepository;


    @Before
    public void setUp() throws Exception {
        MeetingRoomServiceImplTest.doFactory = new MeetingRoomTestDOFactory();
        MeetingRoomServiceImplTest.doFactory2 = new DistrictTestDOFactory();
        MeetingRoomServiceImplTest.doFactory3 = new ProvinceTestDOFactory();

        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void findAll() {
        List<MeetingRoom> expected = new ArrayList<>();
        MeetingRoom meetingRoom = doFactory.createMeetingRoom();
        expected.add(meetingRoom);
        Mockito.when(meetingRoomRepository.findAll()).thenReturn(expected);
        int actual = meetingRoomService.findAll().size();
        Assert.assertEquals(expected.size(), actual);
    }

    @Test
    public void save() {
        MeetingRoomDTO meetingRoomDTO = doFactory.createMeetingRoomDTO();
        MeetingRoom meetingRoom = MappingHelper.map(meetingRoomDTO, MeetingRoom.class);
        Mockito.when(districtRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(doFactory2.createDistrict()));
        Mockito.when(provinceRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(doFactory3.createProvince()));
        Mockito.when(meetingRoomRepository.save(any(MeetingRoom.class))).thenReturn(meetingRoom);
        Long actual = meetingRoomService.save(meetingRoomDTO);
        Assert.assertEquals(meetingRoom.getId(), actual);
    }

    @Test
    public void saveFail() {
        try {
            MeetingRoomDTO meetingRoomDTO = doFactory.createMeetingRoomDTO();
            meetingRoomDTO.setPersonCapacity(-1);
            meetingRoomService.save(meetingRoomDTO);
            fail(MeetingBusinessRule.PERSON_CAPACITY_INVALID + "expected but not thrown");
        } catch (MeetingBusinessException ex) {
            assertEquals(MeetingBusinessRule.PERSON_CAPACITY_INVALID.getDescription(), ex.getMessage());
        }
    }
}