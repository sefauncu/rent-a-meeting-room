package com.example.meeting.controller;

import com.example.meeting.constants.ApiEndpoints;
import com.example.meeting.constants.ApiGroups;
import com.example.meeting.dto.ReservationDTO;
import com.example.meeting.response.ReservationMessageResponse;
import com.example.meeting.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiEndpoints.RESERVATION_API_URL, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = ApiGroups.ReservationOperationApi.NAME)
public class ReservationController {

    @Autowired
    ReservationService reservationService;


    @ApiOperation(value = "", notes = "findAll")
    @GetMapping(value = "/reservation", consumes = MediaType.ALL_VALUE)
    public List<ReservationDTO> findAll() {
        return reservationService.findAll();
    }

    @ApiOperation(value = "", notes = "save")
    @PostMapping("/reservation")
    public ReservationMessageResponse save(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.save(reservationDTO);
    }
}
