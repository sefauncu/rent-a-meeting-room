package com.example.meeting.service.impl;

import com.example.meeting.constants.MeetingBusinessRule;
import com.example.meeting.domain.Company;
import com.example.meeting.domain.MeetingRoom;
import com.example.meeting.domain.Register;
import com.example.meeting.domain.Reservation;
import com.example.meeting.dto.ReservationDTO;
import com.example.meeting.exception.MeetingBusinessException;
import com.example.meeting.repository.CompanyRepository;
import com.example.meeting.repository.MeetingRoomRepository;
import com.example.meeting.repository.RegisterRepository;
import com.example.meeting.repository.ReservationRepository;
import com.example.meeting.response.ReservationMessageResponse;
import com.example.meeting.service.ReservationService;
import com.example.meeting.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private MeetingRoomRepository meetingRoomRepository;
    @Autowired
    private RegisterRepository registerRepository;

    private void validate(ReservationDTO reservationDTO) {
        if (reservationDTO.getStartDate() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.START_DATE_NOT_FOUND.getDescription());
        }
        if (reservationDTO.getEndDate() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.END_DATE_NOT_FOUND.getDescription());
        }
        if (reservationDTO.getCode() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.RESERVATION_CODE_NOT_FOUND.getDescription());
        }
        if (reservationDTO.getCompanyId() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.COMPANY_NOT_FOUND.getDescription());
        }
        if (reservationDTO.getMeetingRoomId() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.MEETING_ROOM_NOT_FOUND.getDescription());
        }
        if (reservationDTO.getStartDate().isAfter(reservationDTO.getEndDate())) {
            throw new MeetingBusinessException(MeetingBusinessRule.DATE_RANGE_IS_INVALID.getDescription());
        }
        Optional<Company> optionalCompany = companyRepository.findById(reservationDTO.getCompanyId());
        if (!optionalCompany.isPresent()) {
            throw new MeetingBusinessException(MeetingBusinessRule.COMPANY_NOT_FOUND.getDescription());
        }
        Register registerByCompanyId = registerRepository.findByCompanyId(reservationDTO.getCompanyId());
        if (registerByCompanyId == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.COMPANY_NOT_A_MEMBER.getDescription());
        }

        Optional<MeetingRoom> optionalMeetingRoom = meetingRoomRepository.findById(reservationDTO.getMeetingRoomId());
        if (!optionalMeetingRoom.isPresent()) {
            throw new MeetingBusinessException(MeetingBusinessRule.MEETING_ROOM_NOT_FOUND.getDescription());
        }
        Company company = optionalCompany.get();
        MeetingRoom meetingRoom = optionalMeetingRoom.get();
        if (company.getTotalEmployeeNumber() > meetingRoom.getPersonCapacity()) {
            throw new MeetingBusinessException(MeetingBusinessRule.THIS_MEETING_ROOMS_CAPACITY_RESTRICTED.getDescription() +
                    " " + meetingRoom.getPersonCapacity() + " " + MeetingBusinessRule.PEOPLE);
        }
        if (!company.getLocation().getId().equals(meetingRoom.getProvince().getId())) {
            throw new MeetingBusinessException(MeetingBusinessRule.PROVINCE_DOES_NOT_MATCH.getDescription());
        }
        Reservation reservationByCode = reservationRepository.findOneByCode(reservationDTO.getCode());

        if (Optional.ofNullable(reservationByCode).isPresent()) {
            throw new MeetingBusinessException(MeetingBusinessRule.MEETING_ROOM_HAS_BEEN_RESERVED_PLEASE_TRY_FOR_OTHER_TIMES.getDescription());
        }
        List<Reservation> reservationListByRoomAndCompanyId = reservationRepository.findByMeetingRoomIdAndCompanyId(reservationDTO.getMeetingRoomId(), reservationDTO.getCompanyId());
        for (Reservation reservation : reservationListByRoomAndCompanyId) {
            if (reservationDTO.getStartDate().isBefore(reservation.getEndDate())) {
                throw new MeetingBusinessException(MeetingBusinessRule.MEETING_ROOM_HAS_BEEN_RESERVED_PLEASE_TRY_FOR_OTHER_TIMES.getDescription());
            }
        }
        if (reservationListByRoomAndCompanyId.isEmpty()) {
            List<Reservation> reservationListByRoomId = reservationRepository.findByMeetingRoomId(reservationDTO.getMeetingRoomId());
            for (Reservation reservation : reservationListByRoomId) {
                if (reservationDTO.getStartDate().isBefore(reservation.getEndDate())) {
                    throw new MeetingBusinessException(MeetingBusinessRule.MEETING_ROOM_HAS_BEEN_RESERVED_PLEASE_TRY_FOR_OTHER_TIMES.getDescription());
                }
            }
        }
    }

    @Override
    public List<ReservationDTO> findAll() {
        List<Reservation> reservationList = reservationRepository.findAll();
        return MappingHelper.mapList(reservationList, ReservationDTO.class);
    }

    @Override
    public ReservationMessageResponse save(ReservationDTO reservationDTO) {
        validate(reservationDTO);
        Reservation reservation = MappingHelper.map(reservationDTO, Reservation.class);
        ReservationMessageResponse reservationMessageResponse = new ReservationMessageResponse();
        reservationMessageResponse.setId(reservationRepository.save(reservation).getId());
        reservationMessageResponse.setMessage(MeetingBusinessRule.THE_MEETING_ROOM_HAS_BEEN_RESERVED_SUCCESSFULLY.getDescription());
        return reservationMessageResponse;
    }
}
