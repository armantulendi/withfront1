package com.example.withfront.service;

import com.example.withfront.model.Location;
import com.example.withfront.model.Subscriber;
import com.example.withfront.model.TablesForTest;
import com.example.withfront.repo.subscriber.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class GetFomDB {

    public static List<TablesForTest> getTablesForTests(List<Subscriber> messages, List<Location> locations) {
        TablesForTest tablesForTest;
        List<TablesForTest> tables=new ArrayList<>();
        for (Subscriber s: messages) {
            tablesForTest=new TablesForTest();
            tablesForTest.setId(s.getId());
            tablesForTest.setUsername(s.getUsername());
            tablesForTest.setDomain(s.getDomain());
            for (Location l: locations) {
                if (s.getUsername().equals(l.getUsername())) {
                    tablesForTest.setServerId(l.getServerId());
                    tablesForTest.setRegistrated(true);
                }
            }
            tables.add(tablesForTest);
        }
        return tables;
    }
}
