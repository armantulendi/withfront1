package com.example.withfront.controller;

import com.example.withfront.model.Calls;
import com.example.withfront.repo.subscriber.CallRepo;
import com.example.withfront.service.ControlService;
import com.example.withfront.service.DateService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("cdr")
public class CDRController {
    private final CallRepo callRepo;
    private final DateService dateService;
    public CDRController(ControlService controlService, CallRepo callRepo, DateService dateService) {
        this.callRepo = callRepo;
        this.dateService = dateService;
    }

    @SneakyThrows
    @RequestMapping
    public String greeting(@RequestParam(required=false,defaultValue="") String filter,
                           @RequestParam(required=false  ) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                           @RequestParam(required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2, Model model ) {
        List<Calls> data;
        if(date1!=null  || date2!=null) {
            data=dateService.filterByDate(date1,date2);}
        else if (filter!=null&&!filter.isEmpty())
            data = callRepo.findAllByCaller1(filter);
        else
            data = callRepo.findByCurrentTimeAfter();

        model.addAttribute("calls",data);
        return "cdr";
    }
//    @GetMapping("/page/{pageNo}")
//    public String findPaginated(@PathVariable(value="pageNo")int pageNo,Model model){
//        int pageSize=5;
//        pageNo=5;
//        Page<Calls> page=callRepo.findPaginated(pageNo,pageSize);
//        List<Calls> listCalls=page.getContent();
//        model.addAttribute("currentPage",pageNo);
//        model.addAttribute("totalPages",page.getTotalPages());
//        model.addAttribute("totalItems",page.getTotalElements());
//        model.addAttribute("calls",listCalls);
//        return "cdr";
//    }

}
