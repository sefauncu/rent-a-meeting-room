package com.example.meeting.controller;

import com.example.meeting.constants.ApiEndpoints;
import com.example.meeting.constants.ApiGroups;
import com.example.meeting.dto.MeetingRoomDTO;
import com.example.meeting.service.MeetingRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiEndpoints.MEETING_ROOM_API_URL, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = ApiGroups.MeetingRoomOperationApi.NAME)
public class MeetingRoomController {

    @Autowired
    private MeetingRoomService meetingRoomService;


    @ApiOperation(value = "", notes = "findAll")
    @GetMapping(value = "/meeting-room", consumes = MediaType.ALL_VALUE)
    public List<MeetingRoomDTO> findAll() {
        return meetingRoomService.findAll();
    }

    @ApiOperation(value = "", notes = "save")
    @PostMapping("/meeting-room")
    public Long save(@RequestBody MeetingRoomDTO meetingRoomDTO) {
        return meetingRoomService.save(meetingRoomDTO);
    }
}
