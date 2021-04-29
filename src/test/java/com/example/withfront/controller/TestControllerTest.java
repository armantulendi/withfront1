package com.example.withfront.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
 @SpringBootTest
public class TestControllerTest {

    @Test
      void  get(){
    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl
            = "http://192.168.17.81:8080/RPC";
    ResponseEntity<String> response
            = restTemplate.getForEntity(fooResourceUrl  , String.class);
    assertThat(response.getStatusCode());
    }
}