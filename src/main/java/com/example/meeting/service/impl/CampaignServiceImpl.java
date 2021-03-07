package com.example.meeting.service.impl;

import com.example.meeting.domain.Campaign;
import com.example.meeting.dto.CampaignDTO;
import com.example.meeting.exception.MeetingRoomAlreadyHasCampaignException;
import com.example.meeting.repository.CampaignRepository;
import com.example.meeting.service.CampaignService;
import com.example.meeting.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public CampaignDTO saveCampaign(CampaignDTO campaignDTO) {

        if (!checkDates(campaignDTO.getCampaignId(), campaignDTO.getCampaignStartDate(), campaignDTO.getCampaignEndDate()))
            throw new MeetingRoomAlreadyHasCampaignException("This meeting room already has a campaign between this dates!");

        Campaign campaign = MappingHelper.map(campaignDTO, Campaign.class);
        Campaign saved = campaignRepository.save(campaign);
        CampaignDTO  res = MappingHelper.map(saved, CampaignDTO.class);
        return res;
    }

    @Override
    public boolean checkDates(Long campaignId, Date campaignStartDate, Date campaignEndDate) {
        List<Campaign> list = campaignRepository.getAllByMeetingRoom_IdAndDates(campaignId, campaignStartDate, campaignEndDate);
        if (list.size() > 0) return false;
        return true;
    }
}
