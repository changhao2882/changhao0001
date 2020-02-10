package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 1）编写后置处理器的实现类
 * 2）将后置处理器注册在配置文件中
 * @author 67557
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor{
	
	/**
	 * postProcessBeforeInitialization:初始化方法之前调用
	 * 	Object bean:将要初始化的bean
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("["+beanName+"]将要调用初始化方法了...bean是这样的："+bean);
		//返回传入的bean
		return bean;
	}
	
	/**
	 * postProcessAfterInitialization：初始化方法之后调用
	 * String beanName：bean在xml中2配置的ID
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("["+beanName+"]调用完初始化方法了...AfterInitialization。。。bean是这样的："+bean);
//		初始化之后返回的bean
		return bean;
	}

	

}
