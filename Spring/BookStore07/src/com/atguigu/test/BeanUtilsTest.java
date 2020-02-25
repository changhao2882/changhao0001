package com.atguigu.test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.atguigu.entity.User;

public class BeanUtilsTest {
	
	@Test
	public void test(){
		//BeanUtils.setProperty(bean, name, value);
		//bean代表要封装的对象,name代表对象属性,value代表值
		User user = new User();
		System.out.println("封装对象前："+user);
		try {
			BeanUtils.setProperty(user, "username", "tomcat");
			BeanUtils.setProperty(user, "age", "abc");
			System.out.println("封装对象后："+user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() throws InstantiationException, NoSuchMethodException{
		//populate(bean, properties);
		//bean代表要封装的对象，Map将map中的key-value按照javaBean的属性匹配进来
		User user = new User();
		Map<String, Object> map = new HashMap<>();
		map.put("username", "zhangsa");
		map.put("age", 19);
		map.put("test", "测试");
		
		try {
			System.out.println("封装对象前："+user);
			BeanUtils.populate(user, map);
			System.out.println("封装对象后："+user);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
