package com.example.meeting.testbase.datahelper;

import com.example.meeting.domain.Province;
import com.example.meeting.dto.ProvinceDTO;

public class ProvinceTestDOFactory {

    public ProvinceDTO createProvinceDTO() {
        ProvinceDTO provinceDTO = new ProvinceDTO();
        provinceDTO.setId(1L);
        provinceDTO.setName("Istanbul");
        return provinceDTO;
    }

    public Province createProvince() {
        Province province = new Province();
        province.setId(1L);
        province.setName("Istanbul");
        return province;
    }
}
