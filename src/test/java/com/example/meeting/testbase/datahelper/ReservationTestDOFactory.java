package com.example.meeting.testbase.datahelper;

import com.example.meeting.domain.Reservation;
import com.example.meeting.dto.ReservationDTO;

import java.time.LocalDateTime;

public class ReservationTestDOFactory {

    public ReservationDTO createReservationDTO() {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(1L);
        reservationDTO.setCode("TEST");
        reservationDTO.setStartDate(LocalDateTime.now());
        reservationDTO.setEndDate(LocalDateTime.now().plusHours(3));
        reservationDTO.setCompanyId(1L);
        reservationDTO.setMeetingRoomId(1L);
        return reservationDTO;
    }

    public Reservation createReservation() {
        CompanyTestDOFactory doFactory = new CompanyTestDOFactory();
        MeetingRoomTestDOFactory doFactory2 = new MeetingRoomTestDOFactory();
        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setCode("TEST");
        reservation.setStartDate(LocalDateTime.now());
        reservation.setEndDate(LocalDateTime.now().plusHours(3));
        reservation.setCompany(doFactory.createCompany());
        reservation.setMeetingRoom(doFactory2.createMeetingRoom());
        return reservation;
    }


}
