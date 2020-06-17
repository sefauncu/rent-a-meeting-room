package com.example.meeting.controller;

import com.example.meeting.constants.ApiEndpoints;
import com.example.meeting.constants.ApiGroups;
import com.example.meeting.dto.RegisterDTO;
import com.example.meeting.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiEndpoints.REGISTER_API_URL, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = ApiGroups.RegisterOperationApi.NAME)
public class RegisterController {

    @Autowired
    private RegisterService registerService;


    @ApiOperation(value = "", notes = "findAll")
    @GetMapping(value = "/register", consumes = MediaType.ALL_VALUE)
    public List<RegisterDTO> findAll() {
        return registerService.findAll();
    }

    @ApiOperation(value = "", notes = "save")
    @PostMapping("/register")
    public Long save(@RequestBody RegisterDTO registerDTO) {
        return registerService.save(registerDTO);
    }
}
