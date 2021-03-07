package com.example.meeting.controller;

import com.example.meeting.constants.ApiEndpoints;
import com.example.meeting.constants.ApiGroups;
import com.example.meeting.dto.CampaignDTO;
import com.example.meeting.service.CampaignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiEndpoints.CAMPAIGN_API_URL, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = ApiGroups.CampaignOperationApi.NAME)
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @ApiOperation(value = "", notes = "save")
    @PostMapping("/campaign")
    public CampaignDTO saveCampaign(@RequestBody CampaignDTO campaignDTO) {
        return campaignService.saveCampaign(campaignDTO);
    }

}
