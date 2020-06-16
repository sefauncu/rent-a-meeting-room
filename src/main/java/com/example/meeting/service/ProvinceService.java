package com.example.meeting.service;

import com.example.meeting.dto.ProvinceDTO;

import java.util.List;

public interface ProvinceService {

    List<ProvinceDTO> findAll();

    Long save(ProvinceDTO provinceDTO);
}
