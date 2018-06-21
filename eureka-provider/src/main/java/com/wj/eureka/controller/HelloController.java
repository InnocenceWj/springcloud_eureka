package com.wj.eureka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;


@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public int hello() {
        ServiceInstance instance = client.getLocalServiceInstance();
        int a=1;
        int c=a+9;
        logger.info("/add , post:"+instance.getPort()+" service_id:"+instance.getServiceId()+" result:"+c);
        return c;
    }
}
