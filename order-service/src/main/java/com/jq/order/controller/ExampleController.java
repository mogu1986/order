package com.jq.order.controller;

import com.mw.distribution.api.ExampleApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Description: Example 的 Feign 入口类
 * @Date: 2019-04-23 16:14
 * @Author: jim
 */
@Slf4j
@RestController
@RefreshScope
public class ExampleController {

    @Value("${timeout:100}")
    private int timeout;

    @Value("${dubbo.config-center.address:no}")
    private String address;

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${foo:null}")
    private String foo;

    @Resource
    ExampleApi exampleApi;

    @RequestMapping(value = "/exec/{str}", method = GET)
    public String exec(@PathVariable String str) {
        log.info("exec {0}", str);
        return exampleApi.echo(str);
    }

    @GetMapping("/nacos")
    public boolean nacos() {
        return this.useLocalCache;
    }

    @GetMapping("/foo")
    public String foo() {
        return foo;
    }

    @RequestMapping("/k8s/health")
    public String healthz(@RequestHeader("X-Custom-Header") String header, HttpServletResponse response) throws IOException {
        log.info("k8s action, header = {}", header);
        if ("jim".equals(header)) {
            response.setStatus(200);
        }
        return "sucess";
    }

}