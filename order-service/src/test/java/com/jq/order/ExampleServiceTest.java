package com.jq.order;


import com.jq.order.service.ExampleInnerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleServiceTest {

    @Resource
    ExampleInnerService helloInnerService;

    @Test
    public void saveTest() {
        log.info("service . value : {}", this.helloInnerService);
    }
}
