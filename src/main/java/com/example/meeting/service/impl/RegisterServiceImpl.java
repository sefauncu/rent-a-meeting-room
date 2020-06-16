package com.example.meeting.service.impl;

import com.example.meeting.constants.MeetingBusinessRule;
import com.example.meeting.domain.Company;
import com.example.meeting.domain.Register;
import com.example.meeting.dto.RegisterDTO;
import com.example.meeting.exception.MeetingBusinessException;
import com.example.meeting.repository.CompanyRepository;
import com.example.meeting.repository.RegisterRepository;
import com.example.meeting.service.RegisterService;
import com.example.meeting.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private CompanyRepository companyRepository;

    private void validate(RegisterDTO registerDTO) {
        if (registerDTO.getTitle() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.REGISTER_TITLE_NOT_FOUND.getDescription());
        }
        if (registerDTO.getCompanyId() == null) {
            throw new MeetingBusinessException(MeetingBusinessRule.COMPANY_NOT_FOUND.getDescription());
        }
        Optional<Company> optionalCompany = companyRepository.findById(registerDTO.getCompanyId());
        if (!optionalCompany.isPresent()) {
            throw new MeetingBusinessException(MeetingBusinessRule.COMPANY_NOT_FOUND.getDescription());
        }

    }


    @Override
    public List<RegisterDTO> findAll() {
        List<Register> registerList = registerRepository.findAll();
        return MappingHelper.mapList(registerList, RegisterDTO.class);
    }

    @Override
    public Long save(RegisterDTO registerDTO) {
        validate(registerDTO);
        Register register = MappingHelper.map(registerDTO, Register.class);
        return registerRepository.save(register).getId();
    }
}
