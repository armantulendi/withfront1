package com.example.withfront.repo.subscriber;

import com.example.withfront.model.Location;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//@DataJpaTest
//@RunWith(SpringRunner.class)
//class LocationRepoTest {
//    @Autowired
//    private LocationRepo locationRepo;
//    @Test
//    public LocationRepo getLocationRepo() {
//         List<Location> location=locationRepo.findAll();
//
//        return locationRepo;
//    }
//}