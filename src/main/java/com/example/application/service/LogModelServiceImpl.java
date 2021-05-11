package com.example.application.service;

import com.example.application.dao.LogDao;
import com.example.application.entity.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

@Service
public class LogModelServiceImpl implements LogModelService
{
    @Autowired
    private LogDao logDao;

    @Override
    public void checkIn(String name) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String strDate= formatter.format(date);
        Format f = new SimpleDateFormat("hh:mm:ss");
        String strResult = f.format(new Date());
        logDao.save(new LogModel(name+strResult, name, "IN", strDate, strResult));
    }

    @Override
    public void checkOut(String name) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String strDate= formatter.format(date);
        Format f = new SimpleDateFormat("hh:mm:ss");
        String strResult = f.format(new Date());
        logDao.save(new LogModel(name+strResult, name, "OUT", strDate, strResult));
    }

    @Override
    public List<LogModel> getAllLog()
    {
        return logDao.findAll();
    }

    @Override
    public List<LogModel> getLog(String date)
    {
        List<LogModel> fetch = logDao.findAll();
        List<LogModel> logList = new ArrayList<>();
        for(LogModel logModel : fetch)
        {
            if(logModel.getDate().equals(date))
            {
                logList.add(logModel);
            }
        }
        return logList;
    }
}
