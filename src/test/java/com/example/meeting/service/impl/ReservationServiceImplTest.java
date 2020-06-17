package com.example.meeting.service.impl;

import com.example.meeting.constants.MeetingBusinessRule;
import com.example.meeting.domain.Reservation;
import com.example.meeting.dto.ReservationDTO;
import com.example.meeting.exception.MeetingBusinessException;
import com.example.meeting.repository.CompanyRepository;
import com.example.meeting.repository.MeetingRoomRepository;
import com.example.meeting.repository.ReservationRepository;
import com.example.meeting.response.ReservationMessageResponse;
import com.example.meeting.testbase.datahelper.CompanyTestDOFactory;
import com.example.meeting.testbase.datahelper.MeetingRoomTestDOFactory;
import com.example.meeting.testbase.datahelper.ReservationTestDOFactory;
import com.example.meeting.util.MappingHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceImplTest {

    protected static ReservationTestDOFactory doFactory;
    protected static CompanyTestDOFactory doFactory2;
    protected static MeetingRoomTestDOFactory doFactory3;

    @Mock
    private ReservationRepository reservationRepository;
    @InjectMocks
    private ReservationServiceImpl reservationService;
    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private MeetingRoomRepository meetingRoomRepository;

    @Before
    public void setUp() throws Exception {
        ReservationServiceImplTest.doFactory = new ReservationTestDOFactory();
        ReservationServiceImplTest.doFactory2 = new CompanyTestDOFactory();
        ReservationServiceImplTest.doFactory3 = new MeetingRoomTestDOFactory();
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void findAll() {
        List<Reservation> expected = new ArrayList<>();
        Reservation reservation = doFactory.createReservation();
        expected.add(reservation);
        Mockito.when(reservationRepository.findAll()).thenReturn(expected);
        int actual = reservationService.findAll().size();
        Assert.assertEquals(expected.size(), actual);
    }

    @Test
    public void save() {
        ReservationDTO reservationDTO = doFactory.createReservationDTO();
        Reservation reservation = MappingHelper.map(reservationDTO, Reservation.class);
        Mockito.when(companyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(doFactory2.createCompany()));
        Mockito.when(meetingRoomRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(doFactory3.createMeetingRoom()));
        Mockito.when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);
        ReservationMessageResponse reservationMessageResponse = reservationService.save(reservationDTO);
        Assert.assertEquals(reservation.getId(), reservationMessageResponse.getId());
    }

    @Test
    public void saveFail() {
        try {
            ReservationDTO reservationDTO = doFactory.createReservationDTO();
            Reservation reservation = MappingHelper.map(reservationDTO, Reservation.class);
            reservation.setStartDate(LocalDateTime.now().plusHours(3));
            List<Reservation> reservationList = new ArrayList<>();
            reservationList.add(reservation);
            Mockito.when(companyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(doFactory2.createCompany()));
            Mockito.when(meetingRoomRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(doFactory3.createMeetingRoom()));
            Mockito.when(reservationRepository.findByMeetingRoomIdAndCompanyId(Mockito.anyLong(), Mockito.anyLong())).thenReturn(new ArrayList<>());
            Mockito.when(reservationRepository.findByMeetingRoomId(Mockito.anyLong())).thenReturn(reservationList);
            reservationDTO.setStartDate(LocalDateTime.now());
            reservationService.save(reservationDTO);
            fail(MeetingBusinessRule.MEETING_ROOM_HAS_BEEN_RESERVED_PLEASE_TRY_FOR_OTHER_TIMES + "expected but not thrown");
        } catch (MeetingBusinessException ex) {
            assertEquals(MeetingBusinessRule.MEETING_ROOM_HAS_BEEN_RESERVED_PLEASE_TRY_FOR_OTHER_TIMES.getDescription(), ex.getMessage());
        }

    }
}