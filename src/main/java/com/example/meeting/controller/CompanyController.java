package com.example.meeting.controller;

import com.example.meeting.constants.ApiEndpoints;
import com.example.meeting.constants.ApiGroups;
import com.example.meeting.dto.CompanyDTO;
import com.example.meeting.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiEndpoints.COMPANY_API_URL, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = ApiGroups.CompanyOperationApi.NAME)
public class CompanyController {

    @Autowired
    CompanyService companyService;


    @ApiOperation(value = "", notes = "findAll")
    @GetMapping(value = "/company", consumes = MediaType.ALL_VALUE)
    public List<CompanyDTO> findAll() {
        return companyService.findAll();
    }

    @ApiOperation(value = "", notes = "save")
    @PostMapping("/company")
    public Long save(@RequestBody CompanyDTO companyDTO) {
        return companyService.save(companyDTO);
    }
}
