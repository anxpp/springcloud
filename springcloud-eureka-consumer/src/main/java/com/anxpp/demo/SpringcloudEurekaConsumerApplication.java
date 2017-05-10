package com.anxpp.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudEurekaConsumerApplication {

    private Logger log = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaConsumerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(DiscoveryClient discoveryClient) {
        //获取到当前所有注册的springcloud-eureka-provider服务
        return args -> discoveryClient.getInstances("springcloud-eureka-provider").forEach(
                consumer -> log.info(String.format("Found %s %s:%s", consumer.getServiceId(), consumer.getHost(), consumer.getPort()))
        );
    }
}
