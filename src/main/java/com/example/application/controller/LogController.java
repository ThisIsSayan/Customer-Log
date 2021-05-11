package com.example.application.controller;

import com.example.application.entity.LogModel;
import com.example.application.service.LogModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogController
{
    @Autowired
    private LogModelService logModelService;

    //Check In Implementation
    @GetMapping("/checkIn")
    public void checkIn(@RequestParam String name)
    {
        logModelService.checkIn(name);
    }

    //Check Out Implementation
    @GetMapping("/checkOut")
    public void checkOut(@RequestParam String name)
    {
        logModelService.checkOut(name);
    }

    //Get All Log Implementation
    @GetMapping("/getAllLog")
    public List<LogModel> getAllLog()
    {
        return this.logModelService.getAllLog();
    }

    //Get Log Implementation
    @GetMapping("/getLog")
    public List<LogModel> getLog(@RequestParam String date)
    {
        return this.logModelService.getLog(date);
    }
}
