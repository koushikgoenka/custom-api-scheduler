package com.example.apischeduler.config;

import com.example.apischeduler.entity.ApiEntity;
import com.example.apischeduler.repository.ApiRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.client.RestTemplate;
import org.springframework.scheduling.annotation.SchedulingConfigurer;

import java.util.List;


@Configuration
public class ApiSchedulerConfig {

    @Autowired
    private ApiRepository apiRepository;
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }




}
