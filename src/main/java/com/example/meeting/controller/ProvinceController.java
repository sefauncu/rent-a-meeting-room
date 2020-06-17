package com.example.meeting.controller;

import com.example.meeting.constants.ApiEndpoints;
import com.example.meeting.constants.ApiGroups;
import com.example.meeting.dto.ProvinceDTO;
import com.example.meeting.service.ProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiEndpoints.PROVINCE_API_URL, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = ApiGroups.ProvinceOperationApi.NAME)
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;


    @ApiOperation(value = "", notes = "findAll")
    @GetMapping(value = "/province", consumes = MediaType.ALL_VALUE)
    public List<ProvinceDTO> findAll() {
        return provinceService.findAll();
    }

    @ApiOperation(value = "", notes = "save")
    @PostMapping("/province")
    public Long save(@RequestBody ProvinceDTO provinceDTO) {
        return provinceService.save(provinceDTO);
    }
}
