package com.tt.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("comsumer")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("test1")
    public String test1() {
        String forObject = restTemplate.getForObject("http://PROVIDER1/test/test1", String.class);
        return forObject;
    }
}
