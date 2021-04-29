package com.example.withfront.controller;

import com.example.withfront.exception.RecordNotFoundException;
import com.example.withfront.model.Location;
import com.example.withfront.model.Subscriber;
import com.example.withfront.model.TablesForTest;
import com.example.withfront.repo.subscriber.LocationRepo;
import com.example.withfront.repo.subscriber.SubscriberRepo;
import com.example.withfront.service.ConnectToDB;
import com.example.withfront.service.GetFomDB;
import com.example.withfront.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/table-basic")
public class SubscribeController {
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private ConnectToDB connectToDB;
    private final SubscriberRepo subscriberRepo;
    private final SubscriberService subscriberService;

    public SubscribeController(SubscriberRepo subscriberRepo, SubscriberService subscriberService) {
        this.subscriberRepo = subscriberRepo;
        this.subscriberService = subscriberService;
    }

    @GetMapping
    public String greeting( @RequestParam(required=false,defaultValue="") String filter, Model model ) {
        List<Subscriber> messages;
        List<Location> locations;


        TablesForTest tablesForTest;
        locations = locationRepo.findAllByServerIdIsNot(0);
        if (filter==null||filter.isEmpty()){
            messages = (List<Subscriber>) subscriberRepo.findAll();
        }
        else {
            messages = subscriberRepo.findAllByUsername(filter);
        }
        List<TablesForTest> tables = GetFomDB.getTablesForTests(messages, locations);
        model.addAttribute("subscribers",tables);

        return "table-basic";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"},method = RequestMethod.GET)
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Integer> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            Subscriber subscriber = subscriberService.getSubscriberById(id.get());
            model.addAttribute("subscriber", subscriber);
        } else {
            model.addAttribute("subscriber", new Subscriber());
        }
        return "table-basic-add";
    }

    @RequestMapping(path = {"/add"},method = RequestMethod.POST)
    public String createOrUpdate(@ModelAttribute Subscriber subscriber)  {
        try {
            subscriberService.createOrUpdateEmployee(subscriber);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage()   );
        }
        return "redirect:/table-basic";

    }

    @RequestMapping("/delete/{id}")
    public String postDelete(@PathVariable(value = "id")Integer id, Model model){
        subscriberRepo.deleteById(id);
        return "redirect:/table-basic";
    }


}
