package com.macro.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: MallNacosConfigApplication
 * @description: TODO
 * @author: gjm
 * @date: 2020-04-25 16 02
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class MallNacosConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallNacosConfigApplication.class, args);
	}
}
