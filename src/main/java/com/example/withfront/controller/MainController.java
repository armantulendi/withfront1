package com.example.withfront.controller;

import com.example.withfront.model.Calls;
import com.example.withfront.model.MissedCalls;
import com.example.withfront.repo.subscriber.CallRepo;
import com.example.withfront.repo.subscriber.LocationRepo;
import com.example.withfront.repo.subscriber.MissedCallsRepo;
import com.example.withfront.repo.subscriber.SubscriberRepo;
import com.example.withfront.service.ConnectToDB;
import com.example.withfront.service.GetFomDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    @Autowired
    private ConnectToDB connectToDB;
    @Autowired
    private SubscriberRepo subscriberRepo;
    @Autowired
    private LocationRepo locationRepo;
    @RequestMapping
    public String main(Model model){
        long countCalls=subscriberRepo.count();
        long countRegCallers=locationRepo.count();
        model.addAttribute("count",connectToDB.countInTheOneDay());
        model.addAttribute("average",connectToDB.getAverageTimeOfDiscuss());
         model.addAttribute("missedCalls",connectToDB.getCountMissedCalls());
         model.addAttribute("countCalls",subscriberRepo.count());
         model.addAttribute("countRegCallers", locationRepo.countReg());
         model.addAttribute("countNotRegCallers", countCalls-countRegCallers);
        return "index";
    }
}
