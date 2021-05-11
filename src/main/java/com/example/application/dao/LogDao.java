package com.example.application.dao;

import com.example.application.entity.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDao extends JpaRepository<LogModel, String> {
}
