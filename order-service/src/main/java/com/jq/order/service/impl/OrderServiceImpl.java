package com.jq.order.service.impl;

import com.jq.order.service.OrderInnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description: Example Service 实现类
 * @Date: 2019-04-23 16:14
 * @Author: jim
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderInnerService {

    @Cacheable(value = "RedisTest")
    public String get(String key){
        System.out.println("进入get方法");
        return key;
    }

    /**
     * @Description: 回声测试
     * @author: jim
     * @date: 2019-04-23 16:14
     * @return String
     */
    @Override
    public String echo(String echo) {
        return "echo : " + echo;
    }

}