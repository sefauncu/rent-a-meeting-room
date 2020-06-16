package com.example.meeting.service;

import com.example.meeting.dto.RegisterDTO;

import java.util.List;

public interface RegisterService {

    List<RegisterDTO> findAll();

    Long save(RegisterDTO registerDTO);
}
