package com.jq.order.controller.api;

import com.jq.order.service.OrderInnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: Example 的 Feign 入口类
 * @Date: 2019-04-23 16:14
 * @Author: jim
 */
@Slf4j
@RestController
@RequestMapping("/api")
@RefreshScope
public class ExampleApiController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${foo:null}")
    private String foo;

    @GetMapping("/nacos")
    public boolean nacos() {
        return this.useLocalCache;
    }

    @Resource
    private OrderInnerService orderInnerService;

    @GetMapping("hello")
    public String hello() {
        String rs = this.orderInnerService.get("jim");
        log.info("rs = {}", rs);
        return rs;
    }

}