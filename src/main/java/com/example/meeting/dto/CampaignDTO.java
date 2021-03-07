package com.example.meeting.dto;

import java.util.Date;

public class CampaignDTO {

    private Long campaignId;

    private Date campaignStartDate;

    private Date campaignEndDate;

    private String campaignDescription;

    private MeetingRoomDTO meetingRoom;

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public Date getCampaignStartDate() {
        return campaignStartDate;
    }

    public void setCampaignStartDate(Date campaignStartDate) {
        this.campaignStartDate = campaignStartDate;
    }

    public Date getCampaignEndDate() {
        return campaignEndDate;
    }

    public void setCampaignEndDate(Date campaignEndDate) {
        this.campaignEndDate = campaignEndDate;
    }

    public String getCampaignDescription() {
        return campaignDescription;
    }

    public void setCampaignDescription(String campaignDescription) {
        this.campaignDescription = campaignDescription;
    }

    public MeetingRoomDTO getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoomDTO meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

}
