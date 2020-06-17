package com.example.meeting.testbase.datahelper;

import com.example.meeting.domain.District;
import com.example.meeting.dto.DistrictDTO;

public class DistrictTestDOFactory {

    public DistrictDTO createDistrictDTO() {
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setId(1L);
        districtDTO.setName("Test");
        districtDTO.setProvinceId(1L);
        return districtDTO;
    }

    public District createDistrict() {
        ProvinceTestDOFactory doFactory = new ProvinceTestDOFactory();
        District district = new District();
        district.setId(1L);
        district.setName("Test");
        district.setProvince(doFactory.createProvince());
        return district;
    }

}
