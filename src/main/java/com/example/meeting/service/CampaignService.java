package com.example.meeting.service;


import com.example.meeting.dto.CampaignDTO;

import java.util.Date;

public interface CampaignService {

    CampaignDTO saveCampaign(CampaignDTO campaignDTO);

    boolean checkDates(Long campaignId, Date campaignStartDate, Date campaignEndDate);

}
