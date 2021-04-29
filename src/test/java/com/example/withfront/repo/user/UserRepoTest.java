package com.example.withfront.repo.user;

import com.example.withfront.model.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

//Тестируем interface UserRepo
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    public void name() {
        User user1 = userRepo.findByUsername("admin");
        assertEquals("admin",user1.getUsername());
        User user=new User();
        user.setUsername("arman");
        user.setId(1L);
        assertEquals("arman",user.getUsername());
    }

    @Test
    public void isEmptyDefaultAdmin() {
//        assertEquals("admin",user.getUsername());
        //Входные данные
//        User user=new User();
//        user.setUsername("admin");
//        user.setId(100L);
//        user.setRoles(Collections.singleton(Role.ADMIN));
//        userRepo.save(user);

        //Проверка
//        assertEquals("",userRepo.findByUsername("admin").getUsername());
//    assertTrue(userRepo.existsById(1000L));
    }

    @Test
    public void isExists() {


    }
}