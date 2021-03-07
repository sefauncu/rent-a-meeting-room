package com.example.meeting.service.impl;

import com.example.meeting.domain.Campaign;
import com.example.meeting.domain.MeetingRoom;
import com.example.meeting.dto.CampaignDTO;
import com.example.meeting.dto.MeetingRoomDTO;
import com.example.meeting.repository.CampaignRepository;
import com.example.meeting.service.CampaignService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CampaignServiceImplTest {

    @InjectMocks
    CampaignServiceImpl campaignService;

    @Mock
    CampaignRepository campaignRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Test
    public void saveCampaign() throws ParseException {
        when(campaignRepository.save(any(Campaign.class))).thenReturn(new Campaign());
        CampaignDTO campaign = new CampaignDTO();
        campaign.setCampaignId(1L);
        campaign.setCampaignStartDate(sdf.parse("01-09-2021 10:00:00"));
        campaign.setCampaignEndDate(sdf.parse("07-09-2021 10:00:00"));
        MeetingRoomDTO meetingRoom = new MeetingRoomDTO();
        meetingRoom.setId(1L);
        campaign.setMeetingRoom(meetingRoom);
        campaign.setCampaignDescription("10% Discount!");
        CampaignDTO response = campaignService.saveCampaign(campaign);
        assertNotNull(response);
    }

    @Test
    public void checkDates() throws ParseException {
        List<Campaign> temp = new ArrayList<>();
        when(campaignRepository.getAllByMeetingRoom_IdAndDates(any(), any(), any())).thenReturn(temp);
        List<Campaign> list = campaignRepository.getAllByMeetingRoom_IdAndDates(1L, sdf.parse("01-09-2021 10:00:00"), sdf.parse("07-09-2021 10:00:00"));
        assertEquals(0, list.size());
        List<Campaign> list2 = campaignRepository.getAllByMeetingRoom_IdAndDates(1L, sdf.parse("02-09-2021 10:00:00"), sdf.parse("06-09-2021 10:00:00"));
        assertEquals(0, list2.size());
        List<Campaign> list3 = campaignRepository.getAllByMeetingRoom_IdAndDates(1L, sdf.parse("30-08-2021 10:00:00"), sdf.parse("10-09-2021 10:00:00"));
        assertEquals(0, list3.size());
        List<Campaign> list4 = campaignRepository.getAllByMeetingRoom_IdAndDates(1L, sdf.parse("12-09-2021 10:00:00"), sdf.parse("16-09-2021 10:00:00"));
        assertEquals(0, list4.size());
    }

}
