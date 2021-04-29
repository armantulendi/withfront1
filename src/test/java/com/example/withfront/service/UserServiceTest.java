package com.example.withfront.service;

import com.example.withfront.model.Location;
import com.example.withfront.model.User;
import com.example.withfront.repo.subscriber.LocationRepo;
import com.example.withfront.repo.subscriber.SubscriberRepo;
import com.example.withfront.repo.user.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepo userRepo;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private LocationRepo locationRepo;
    @Test
    void save() {
        User user =new User();
        user.setUsername("user");
         userRepo.save(user);
//        assertEquals("user",user1.getUsername());

    }
    @Test
    void get() {
//        List<Subscriber> all = (List<Subscriber>) subscriberRepo.findAll();
//        for (Subscriber s:all) {
//            System.out.println(s.getUsername()+s.getLocation());
//        }
    }
    @Test
    void get1() {
        List<Location> location =  locationRepo.findAll();
        for (Location l:location) {
            System.out.println( l.toString());
        }
    }

}