package com.xc;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class SpuConApp {
    public static void main(String[] args) {
        SpringApplication.run(SpuConApp.class,args);
    }
}
