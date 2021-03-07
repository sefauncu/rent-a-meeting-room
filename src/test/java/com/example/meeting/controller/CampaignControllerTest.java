package com.example.meeting.controller;

import com.example.meeting.dto.CampaignDTO;
import com.example.meeting.service.CampaignService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;

public class CampaignControllerTest {

    @InjectMocks
    CampaignController campaignController;

    @Mock
    CampaignService campaignService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveCampaign(){
        when(campaignService.saveCampaign(any(CampaignDTO.class))).thenReturn(new CampaignDTO());
        CampaignDTO campaignDTO = new CampaignDTO();
        campaignDTO.setCampaignId(1L);
        CampaignDTO response = campaignController.saveCampaign(campaignDTO);
        assertNotNull(response);
    }


}
