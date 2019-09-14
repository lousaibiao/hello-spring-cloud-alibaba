package com.lou.hello.spring.cloud.alibaba.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class HelloSpringCloudAlibabaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringCloudAlibabaProviderApplication.class, args);
    }

    @Value("${person.name:default}")
    private String name;

    @Value("${server.port}")
    private String port;

    @GetMapping("getName")
    public String getName(@RequestParam(value = "test") String test) {
        return name + "---" + test + "---来自端口:" + port;
    }

}
