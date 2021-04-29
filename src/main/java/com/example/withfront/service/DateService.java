package com.example.withfront.service;

import com.example.withfront.model.Calls;
import com.example.withfront.repo.subscriber.CallRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DateService {
    private final CallRepo callRepo;

    public DateService(CallRepo callRepo) {
        this.callRepo = callRepo;
    }

    @SneakyThrows
    public List<Calls> filterByDate(Date date1,Date date2) {
        List<Calls> calls;
        if (date1!=null&&date2!=null){
            date2.setHours(24);
            calls= callRepo.findByStartTimeBetween(date1,date2);
        }
        else if (date1!=null){
            calls= callRepo.findAllByStartTimeAfter(date1);
        }
        else{
            date2.setHours(24);
            calls= callRepo.findByStartTimeBefore(date2);}
        return calls;
    }


}
