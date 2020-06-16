package com.example.meeting.service;

import com.example.meeting.dto.DistrictDTO;

import java.util.List;

public interface DistrictService {

    List<DistrictDTO> findAll();

    Long save(DistrictDTO districtDTO);
}
