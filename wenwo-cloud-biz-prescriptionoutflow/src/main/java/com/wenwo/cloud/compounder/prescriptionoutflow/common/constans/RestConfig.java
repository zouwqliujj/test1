package com.wenwo.cloud.compounder.prescriptionoutflow.common.constans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wanqiang.zou
 * @description: TODO
 * @date 2021/1/415:33
 */
@Configuration
public class RestConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
