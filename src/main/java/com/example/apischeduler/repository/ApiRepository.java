package com.example.apischeduler.repository;

import com.example.apischeduler.entity.ApiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<ApiEntity, Long> {
}
