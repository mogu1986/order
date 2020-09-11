package com.jq.order.service;


import com.jq.order.api.OrderApi;

/**
 * @Description: mybatis-plush 配置类
 * @Date: 2019-04-23 16:14
 * @Author: jim
 */
public interface OrderInnerService extends OrderApi {

    String get(String key);

}