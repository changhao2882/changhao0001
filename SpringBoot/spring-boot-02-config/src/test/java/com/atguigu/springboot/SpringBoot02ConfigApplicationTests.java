package com.atguigu.springboot;

import com.atguigu.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * SpringBoot的单元测试
 */
@SpringBootTest
class SpringBoot02ConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test   //主配置类上加：@ImportResource(locations = {"classpath:beans.xml"})或者配置MyAppConfig类
    public void testHelloService(){
        boolean helloService = ioc.containsBean("helloService");
        System.out.println(helloService);
    }

}
