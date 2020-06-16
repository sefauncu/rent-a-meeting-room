package com.example.meeting.service.impl;

import com.example.meeting.constants.MeetingBusinessRule;
import com.example.meeting.domain.Province;
import com.example.meeting.dto.ProvinceDTO;
import com.example.meeting.exception.MeetingBusinessException;
import com.example.meeting.repository.ProvinceRepository;
import com.example.meeting.service.ProvinceService;
import com.example.meeting.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    private void validate(ProvinceDTO provinceDTO) {
        if (provinceDTO.getName() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.PROVINCE_NAME_NOT_FOUND.getDescription());
        }
    }


    @Override
    public List<ProvinceDTO> findAll() {
        List<Province> provinceList = provinceRepository.findAll();
        return MappingHelper.mapList(provinceList, ProvinceDTO.class);
    }

    @Override
    public Long save(ProvinceDTO provinceDTO) {
        validate(provinceDTO);
        Province province = MappingHelper.map(provinceDTO, Province.class);
        return provinceRepository.save(province).getId();
    }
}
