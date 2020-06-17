package com.example.meeting.testbase.datahelper;

import com.example.meeting.domain.MeetingRoom;
import com.example.meeting.dto.MeetingRoomDTO;

public class MeetingRoomTestDOFactory {

    public MeetingRoomDTO createMeetingRoomDTO() {
        MeetingRoomDTO meetingRoomDTO = new MeetingRoomDTO();
        meetingRoomDTO.setId(1L);
        meetingRoomDTO.setName("Test");
        meetingRoomDTO.setDistrictId(1L);
        meetingRoomDTO.setPersonCapacity(10);
        meetingRoomDTO.setProvinceId(1L);
        return meetingRoomDTO;
    }

    public MeetingRoom createMeetingRoom() {
        ProvinceTestDOFactory doFactory = new ProvinceTestDOFactory();
        DistrictTestDOFactory doFactory2 = new DistrictTestDOFactory();
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setId(1L);
        meetingRoom.setName("Test");
        meetingRoom.setDistrict(doFactory2.createDistrict());
        meetingRoom.setPersonCapacity(10);
        meetingRoom.setProvince(doFactory.createProvince());
        return meetingRoom;
    }

}
