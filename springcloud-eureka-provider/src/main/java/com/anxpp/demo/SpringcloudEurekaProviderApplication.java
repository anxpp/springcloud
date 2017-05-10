package com.anxpp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient	//激活eureka中的DiscoveryClient实现
@SpringBootApplication
public class SpringcloudEurekaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaProviderApplication.class, args);
	}
}
