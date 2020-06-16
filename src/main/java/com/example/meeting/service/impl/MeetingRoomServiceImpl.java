package com.example.meeting.service.impl;

import com.example.meeting.constants.MeetingBusinessRule;
import com.example.meeting.domain.District;
import com.example.meeting.domain.MeetingRoom;
import com.example.meeting.domain.Province;
import com.example.meeting.dto.MeetingRoomDTO;
import com.example.meeting.exception.MeetingBusinessException;
import com.example.meeting.repository.DistrictRepository;
import com.example.meeting.repository.MeetingRoomRepository;
import com.example.meeting.repository.ProvinceRepository;
import com.example.meeting.service.MeetingRoomService;
import com.example.meeting.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

    @Autowired
    private MeetingRoomRepository meetingRoomRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    private void validate(MeetingRoomDTO meetingRoomDTO) {
        if (meetingRoomDTO.getName() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.MEETING_ROOM_NAME_NOT_FOUND.getDescription());
        }
        if (meetingRoomDTO.getProvinceId() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.PROVINCE_NOT_FOUND.getDescription());
        }
        if (meetingRoomDTO.getDistrictId() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.DISTRICT_NOT_FOUND.getDescription());
        }
        Optional<District> optionalDistrict = districtRepository.findById(meetingRoomDTO.getDistrictId());
        if (!optionalDistrict.isPresent()) {
            throw new MeetingBusinessException(MeetingBusinessRule.DISTRICT_NOT_FOUND.getDescription());
        }
        Optional<Province> optionalProvince = provinceRepository.findById(meetingRoomDTO.getProvinceId());
        if (!optionalProvince.isPresent()) {
            throw new MeetingBusinessException(MeetingBusinessRule.PROVINCE_NOT_FOUND.getDescription());
        }
        District district = optionalDistrict.get();
        if (!meetingRoomDTO.getProvinceId().equals(district.getProvince().getId())) {
            throw new MeetingBusinessException(MeetingBusinessRule.PROVINCE_DOES_NOT_MATCH.getDescription());
        }
    }

    @Override
    public List<MeetingRoomDTO> findAll() {
        List<MeetingRoom> meetingRoomList = meetingRoomRepository.findAll();
        return MappingHelper.mapList(meetingRoomList, MeetingRoomDTO.class);
    }

    @Override
    public Long save(MeetingRoomDTO meetingRoomDTO) {
        validate(meetingRoomDTO);
        MeetingRoom meetingRoom = MappingHelper.map(meetingRoomDTO, MeetingRoom.class);
        return meetingRoomRepository.save(meetingRoom).getId();
    }
}
