package com.example.withfront.controller;

import com.example.withfront.model.Calls;
import com.example.withfront.repo.subscriber.CallRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class SubscribeControllerTest {
    @Autowired
    private CallRepo callRepo;
    @Test
    void greeting() {

        for (Calls ca:callRepo.findAll()
        ) {
            System.out.println(ca.getStartTime());
        };
    }
}