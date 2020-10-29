package com.jq.order.controller.feign;

import com.jq.order.api.OrderApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/inner/order")
public class ExampleFeignController implements OrderApi {

    @Override
    public String echo(@RequestParam String echo) {
        log.info("echo = {}", echo);
        return echo;
    }

}
