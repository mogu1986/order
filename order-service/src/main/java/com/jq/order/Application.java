package com.jq.order;

import com.jq.boot.feign.FeignConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: 启动类
 * @Date: 2019-04-23 16:14
 * @Author: jim
 */
@Slf4j
@EnableCaching
@EnableFeignClients(defaultConfiguration= FeignConfig.class)
@SpringBootApplication(scanBasePackages = {"com.jq"})
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(WebApplicationType.SERVLET).run(args);
        log.info("order server start...");
    }

}