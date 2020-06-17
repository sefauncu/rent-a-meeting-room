package com.example.meeting.controller;

import com.example.meeting.constants.ApiEndpoints;
import com.example.meeting.constants.ApiGroups;
import com.example.meeting.dto.DistrictDTO;
import com.example.meeting.service.DistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiEndpoints.DISTRICT_API_URL, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = ApiGroups.DistrictOperationApi.NAME)
public class DistrictController {

    @Autowired
    private DistrictService districtService;


    @ApiOperation(value = "", notes = "findAll")
    @GetMapping(value = "/district", consumes = MediaType.ALL_VALUE)
    public List<DistrictDTO> findAll() {
        return districtService.findAll();
    }

    @ApiOperation(value = "", notes = "save")
    @PostMapping("/district")
    public Long save(@RequestBody DistrictDTO districtDTO) {
        return districtService.save(districtDTO);
    }
}
