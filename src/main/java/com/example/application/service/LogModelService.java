package com.example.application.service;

import com.example.application.entity.LogModel;

import java.util.List;

public interface LogModelService
{
    public List<LogModel> getAllLog();
    public List<LogModel> getLog(String date);
    public void checkIn(String name);
    public void checkOut(String name);
}
