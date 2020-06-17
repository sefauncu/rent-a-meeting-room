package com.example.meeting.service.impl;

import com.example.meeting.constants.MeetingBusinessRule;
import com.example.meeting.domain.District;
import com.example.meeting.dto.DistrictDTO;
import com.example.meeting.exception.MeetingBusinessException;
import com.example.meeting.repository.DistrictRepository;
import com.example.meeting.repository.ProvinceRepository;
import com.example.meeting.testbase.datahelper.DistrictTestDOFactory;
import com.example.meeting.testbase.datahelper.ProvinceTestDOFactory;
import com.example.meeting.util.MappingHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class DistrictServiceImplTest {

    protected static DistrictTestDOFactory doFactory;
    protected static ProvinceTestDOFactory doFactory2;

    @Mock
    private DistrictRepository districtRepository;
    @InjectMocks
    private DistrictServiceImpl districtService;
    @Mock
    private ProvinceRepository provinceRepository;

    @Before
    public void setUp() throws Exception {
        DistrictServiceImplTest.doFactory = new DistrictTestDOFactory();
        DistrictServiceImplTest.doFactory2 = new ProvinceTestDOFactory();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
        List<District> expected = new ArrayList<>();
        District district = doFactory.createDistrict();
        expected.add(district);
        Mockito.when(districtRepository.findAll()).thenReturn(expected);
        int actual = districtService.findAll().size();
        Assert.assertEquals(expected.size(), actual);
    }

    @Test
    public void save() {
        DistrictDTO districtDTO = doFactory.createDistrictDTO();
        District district = MappingHelper.map(districtDTO, District.class);
        Mockito.when(provinceRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(doFactory2.createProvince()));
        Mockito.when(districtRepository.save(any(District.class))).thenReturn(district);
        Long actual = districtService.save(districtDTO);
        Assert.assertEquals(district.getId(), actual);
    }

    @Test
    public void saveFail() {
        try {
            DistrictDTO districtDTO = doFactory.createDistrictDTO();
            districtDTO.setProvinceId(null);
            districtService.save(districtDTO);
            fail(MeetingBusinessRule.PROVINCE_NOT_FOUND + "expected but not thrown");
        } catch (MeetingBusinessException ex) {
            assertEquals(MeetingBusinessRule.PROVINCE_NOT_FOUND.getDescription(), ex.getMessage());
        }
    }
}