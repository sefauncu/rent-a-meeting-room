package com.example.meeting.service;

import com.example.meeting.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> findAll();

    Long save(CompanyDTO companyDTO);
}
