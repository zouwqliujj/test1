package com.wenwo.cloud.compounder.prescriptionoutflow;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.wenwo.common.domain.web.security.helper.EnableGatewayAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableGatewayAuth
@EnableEurekaClient
@EnableFeignClients(basePackages = {
        "com.wenwo.cloud.compounder.prescriptionoutflow"
})
@EnableApolloConfig
@SpringBootApplication
public class WenwoCloudBizPrescriptionoutflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(WenwoCloudBizPrescriptionoutflowApplication.class, args);
        System.out.println("\n===================@@@@@@@@@@@@@======================");
    }
}
