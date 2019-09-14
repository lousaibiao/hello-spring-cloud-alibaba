package com.lou.hello.spring.cloud.alibaba.consumer;

import com.lou.hello.spring.cloud.alibaba.consumer.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class HelloSpringCloudAlibabaConsumerApplication {

    @Autowired
    private ProviderService providerService;

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringCloudAlibabaConsumerApplication.class, args);
    }

    @GetMapping("feignGetHello")
    public String feignGetHello(@RequestParam(value = "name") String name) {
        return providerService.getName(name);
    }

    @GetMapping("getHello")
    public String getHello(@RequestParam(value = "name") String name) {
        return restTemplate.getForObject("http://hello-spring-cloud-alibaba-provider/getName?test=" + name, String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
