package com.example.meeting.repository;

import com.example.meeting.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findOneByCode(String code);

    List<Reservation> findByMeetingRoomIdAndCompanyId(Long meetingId, Long companyId);

    List<Reservation> findByMeetingRoomId(Long meetingId);

}
