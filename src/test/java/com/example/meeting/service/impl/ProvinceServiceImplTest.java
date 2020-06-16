package com.example.meeting.service.impl;

import com.example.meeting.domain.Province;
import com.example.meeting.repository.ProvinceRepository;
import com.example.meeting.testbase.datahelper.ProvinceTestDOFactory;
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

@RunWith(MockitoJUnitRunner.class)
public class ProvinceServiceImplTest {

    protected static ProvinceTestDOFactory doFactory;

    @Mock
    ProvinceRepository provinceRepository;
    @InjectMocks
    ProvinceServiceImpl provinceService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ProvinceServiceImplTest.doFactory = new ProvinceTestDOFactory();
    }

    @Test
    public void saveTest() {
        List<Province> expected = new ArrayList<>();
        Province province = doFactory.createProvince();
        expected.add(province);
        Mockito.when(provinceRepository.findAll()).thenReturn(expected);
        int actual = provinceService.findAll().size();
        Assert.assertEquals(expected.size(), actual);
    }
}