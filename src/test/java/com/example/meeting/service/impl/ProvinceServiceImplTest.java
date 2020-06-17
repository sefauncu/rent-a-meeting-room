package com.example.meeting.service.impl;

import com.example.meeting.domain.Province;
import com.example.meeting.dto.ProvinceDTO;
import com.example.meeting.repository.ProvinceRepository;
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

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ProvinceServiceImplTest {

    protected static ProvinceTestDOFactory doFactory;

    @Mock
    private ProvinceRepository provinceRepository;
    @InjectMocks
    private ProvinceServiceImpl provinceService;

    @Before
    public void setUp() throws Exception {
        ProvinceServiceImplTest.doFactory = new ProvinceTestDOFactory();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
        List<Province> expected = new ArrayList<>();
        Province province = doFactory.createProvince();
        expected.add(province);
        Mockito.when(provinceRepository.findAll()).thenReturn(expected);
        int actual = provinceService.findAll().size();
        Assert.assertEquals(expected.size(), actual);
    }

    @Test
    public void save() {
        ProvinceDTO provinceDTO = doFactory.createProvinceDTO();
        Province province = MappingHelper.map(provinceDTO, Province.class);
        Mockito.when(provinceRepository.save(any(Province.class))).thenReturn(province);
        Long actual = provinceService.save(provinceDTO);
        Assert.assertEquals(province.getId(), actual);
    }
}