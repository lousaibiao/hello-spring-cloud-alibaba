package com.lou.hello.spring.cloud.alibaba.consumer.services.fallback;

import com.lou.hello.spring.cloud.alibaba.consumer.services.ProviderService;
import org.springframework.stereotype.Component;

@Component
public class ProviderServiceFallback implements ProviderService {
    @Override
    public String getName(String test) {
        return "出错了";
    }
}
