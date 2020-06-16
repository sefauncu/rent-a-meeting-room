package com.example.meeting.service;

import com.example.meeting.dto.ReservationDTO;
import com.example.meeting.response.ReservationMessageResponse;

import java.util.List;

public interface ReservationService {

    List<ReservationDTO> findAll();

    ReservationMessageResponse save(ReservationDTO reservationDTO);
}
