package com.example.apischeduler.service;

import com.example.apischeduler.dto.ApiDto;
import com.example.apischeduler.entity.ApiEntity;
import com.example.apischeduler.repository.ApiRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@org.springframework.stereotype.Service
public class ApiService {

    @Autowired
    private ApiRepository apiRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Scheduled(cron = "0 * * * * *")
    public String getForEntityExample() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;
    }

    public List<ApiEntity> getAllApis(){
        return apiRepository.findAll();
    }

    public ApiDto createApi(ApiDto apiDto) {
        ApiEntity apiEntity = modelMapper.map(apiDto, ApiEntity.class);
        ApiEntity savedApiEntity = apiRepository.save(apiEntity);
        return modelMapper.map(savedApiEntity, ApiDto.class);
    }

    public void executeApiCall(String url) {
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("API Response: " + response);
    }

    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        List<ApiEntity> apis = apiRepository.findAll();
        for (ApiEntity api : apis) {
            taskRegistrar.addCronTask(new Runnable() {
                @Override
                public void run() {
                    executeApiCall(api.getUrl());
                }
            }, api.getCronExpression());
        }
    }
}
