package com.example.meeting.service.impl;

import com.example.meeting.constants.MeetingBusinessRule;
import com.example.meeting.domain.District;
import com.example.meeting.domain.Province;
import com.example.meeting.dto.DistrictDTO;
import com.example.meeting.exception.MeetingBusinessException;
import com.example.meeting.repository.DistrictRepository;
import com.example.meeting.repository.ProvinceRepository;
import com.example.meeting.service.DistrictService;
import com.example.meeting.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    private void validate(DistrictDTO districtDTO) {
        if (districtDTO.getName() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.DISTRICT_NAME_NOT_FOUND.getDescription());
        }
        if (districtDTO.getProvinceId() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.PROVINCE_NOT_FOUND.getDescription());
        }
        Optional<Province> optionalProvince = provinceRepository.findById(districtDTO.getProvinceId());
        if (!optionalProvince.isPresent()) {
            throw new MeetingBusinessException(MeetingBusinessRule.PROVINCE_NOT_FOUND.getDescription());
        }
    }

    @Override
    public List<DistrictDTO> findAll() {
        List<District> districtList = districtRepository.findAll();
        return MappingHelper.mapList(districtList, DistrictDTO.class);
    }

    @Override
    public Long save(DistrictDTO districtDTO) {
        validate(districtDTO);
        District district = MappingHelper.map(districtDTO, District.class);
        return districtRepository.save(district).getId();
    }
}
