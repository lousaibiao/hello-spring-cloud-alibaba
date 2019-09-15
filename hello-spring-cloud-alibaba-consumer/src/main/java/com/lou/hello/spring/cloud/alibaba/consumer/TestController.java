package com.lou.hello.spring.cloud.alibaba.consumer;

import com.lou.hello.spring.cloud.alibaba.consumer.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ProviderService providerService;

    @Value("${person.name}")
    private String personName;


    @GetMapping("getPersonName")
    public String getPersonName(){
        return personName;
    }

}
