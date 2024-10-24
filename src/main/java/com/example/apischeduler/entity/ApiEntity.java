package com.example.apischeduler.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="api")
@Getter
@Setter
public class ApiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apiId;
    @Column(nullable = false)
    private String apiTask;
    @Column(nullable = false)
    private String method;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String cronExpression;
}
