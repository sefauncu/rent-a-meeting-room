package com.example.meeting.service;

import com.example.meeting.dto.MeetingRoomDTO;

import java.util.List;

public interface MeetingRoomService {

    List<MeetingRoomDTO> findAll();

    Long save(MeetingRoomDTO meetingRoomDTO);
}
