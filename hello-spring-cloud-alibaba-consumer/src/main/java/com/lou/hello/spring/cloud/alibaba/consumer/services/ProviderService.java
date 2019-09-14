package com.lou.hello.spring.cloud.alibaba.consumer.services;

import com.lou.hello.spring.cloud.alibaba.consumer.services.fallback.ProviderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value ="feignClient" ,name = "hello-spring-cloud-alibaba-provider", fallback = ProviderServiceFallback.class)
public interface ProviderService {
    @GetMapping("getName")
    String getName(@RequestParam(value = "test") String test);
}
