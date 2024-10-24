package com.example.apischeduler.controller;

import com.example.apischeduler.dto.ApiDto;
import com.example.apischeduler.entity.ApiEntity;
import com.example.apischeduler.service.ApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping("/hello2/{id}")
    public Map<String, Object> getPostById2(@PathVariable Long id) throws JsonProcessingException {
        String jsonString = apiService.getForEntityExample();
        Map<String, Object> json = objectMapper.readValue(jsonString, Map.class);
        return json;
    }

    @GetMapping
    public List<ApiEntity> getAllApis() {
        return apiService.getAllApis();
    }

    @PostMapping("/apis")
    public ApiDto createApi(@RequestBody ApiDto apiDto) {
        System.out.println(apiDto.toString());
        return apiService.createApi(apiDto);
    }

}


