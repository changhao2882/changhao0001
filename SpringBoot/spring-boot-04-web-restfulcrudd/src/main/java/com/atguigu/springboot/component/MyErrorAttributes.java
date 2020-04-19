package com.atguigu.springboot.component;


import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

//给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    //返回值的map就是页面和json能获取的所有字段    重写的那个源码在DefaultErrorAttributes中
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //整个定制
//        Map<String, Object> errorAttributes = new LinkedHashMap();
////        errorAttributes.put("timestamp", new Date());
////        errorAttributes.put("status","500");
////
////        errorAttributes.put("company","atguigu");
////        //我们的异常处理器携带的数据
////        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
////        errorAttributes.put("ext",ext);
////        return errorAttributes;
        //部分定制
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        Map<String,Object> map = (Map<String, Object>) super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("message","atguigu");
        map.put("ext",ext);
        return map;
    }

}
