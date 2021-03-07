package com.example.meeting.repository;

import com.example.meeting.domain.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {


    @Query(value = "select campaign_id, campaign_start_date, campaign_end_date, campaign_description, campaign_meeting_room_id  from campaign " +
            "where campaign_id = :campaignId and ((:campaignStartDate between campaign_start_date and campaign_end_date) " +
            "or (:campaignEndDate between campaign_start_date and campaign_end_date))", nativeQuery = true)
    List<Campaign> getAllByMeetingRoom_IdAndDates(Long campaignId, Date campaignStartDate, Date campaignEndDate);

}
