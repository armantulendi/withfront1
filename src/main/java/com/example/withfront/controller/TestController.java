package com.example.withfront.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.Collections;

@RestController
@RequestMapping(value = "/test",produces = "application/json")
public class TestController {
    private WebClient webClient;
    final MultiValueMap<String, String> formData;
    private LinkedMultiValueMap map1;
    TestController(){
         formData = new LinkedMultiValueMap<>();
        formData.add("jsonrpc", "2.0");
        formData.add("method", "dlg.stats_active");
    }

    @PostConstruct
    private void setUpWebClient(){
        webClient = WebClient.builder()
                .baseUrl("http://192.168.17.81:8080/RPC")
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("RPC", "http://192.168.17.81:8080"))
                .build();

    }

    @RequestMapping(value = "/result",method = RequestMethod.GET,
            produces ="application/json")
    @ResponseBody
    public String post() {
        map1 = new LinkedMultiValueMap();
        map1.add("jsonrpc", "2.0");
        map1.add("method", "ul.dump");
        return webClient.post()
                .body(BodyInserters.fromMultipartData(map1))
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }

}
