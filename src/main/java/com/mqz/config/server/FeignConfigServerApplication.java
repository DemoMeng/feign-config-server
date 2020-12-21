package com.mqz.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author mqz
 * @since 2020年12月18日
 * @description 分布式配置中心-服务端
 * @abount https://github.com/DemoMeng
 */
//@EnableEurekaClient
@SpringBootApplication
@EnableConfigServer
public class FeignConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConfigServerApplication.class, args);
    }

}
