package com.example.apischeduler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiDto {
    private String apiTask;
    private String method;
    private String url;
    private String cronExpression;
}
