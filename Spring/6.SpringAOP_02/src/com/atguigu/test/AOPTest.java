package com.atguigu.test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.impl.MyMathCalculator;
import com.atguigu.inter.Calculator;

public class AOPTest {
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void test() {
		//有接口jdk帮我们创建好代理对象
		//1.从容器中拿到目标对象；注意：如果想要用类型，一定用他的接口类型，不要用他本类
		//com.atguigu.impl.MyMathCalculator@6ae5aa72
		//class com.sun.proxy.$Proxy12
		//aop的底层就是动态代理，容器中保存的组件是他的代理对象；$Proxy12，当然不是本类的类型
		/*
		Calculator bean = ioc.getBean(Calculator.class);
		bean.add(3, 6);
		System.out.println(bean);
		System.out.println(bean.getClass());
		System.out.println(Arrays.asList(bean.getClass().getGenericInterfaces()));
		
		Calculator bean2 = (Calculator) ioc.getBean("myMathCalculator");
		System.out.println(bean.getClass());
		*/
		
		//没有接口就是本类类型
		//class com.atguigu.impl.MyMathCalculator$$EnhancerByCGLIB$$9cf8934c
		//cglib帮我们创建好的代理对象
		MyMathCalculator bean3 = ioc.getBean(MyMathCalculator.class);
		bean3.add(2, 5);
		System.out.println(bean3.getClass());
		
		MyMathCalculator bean4 = (MyMathCalculator) ioc.getBean("myMathCalculator");
		bean4.add(2, 5);
		System.out.println(bean4.getClass());
		
	}
	
	@Test
	public void test2(){
		MyMathCalculator bean = (MyMathCalculator) ioc.getBean("myMathCalculator");
		bean.add(2, 5.5);
		int a = 5;
		double c = 2.2;
		System.out.println(a+c);
		//7.2
		
		//11
		BigInteger bg = BigInteger.valueOf(5);
		bg = bg.add(BigInteger.valueOf(6));
		System.out.println(bg);
		
	}
	
	@Test
	public void test3(){
		/**
		 * 通知方法的执行顺序：
		 * try{
		 * 		@Before
		 * 		method.invoke(obj,args);
		 * 		@AfterReturning
		 * }catch(e){
		 * 		@AfterThrowing
		 * }finally{
		 * 		@After
		 * }
		 * 正常执行：@Before（前置通知）----@After（后置通知）------@AfterReturning（返回通知）
		 * 异常执行：@Before（前置通知）----@After（后置通知）------@@AfterThrowing（异常通知）
		 */
		MyMathCalculator bean = (MyMathCalculator) ioc.getBean("myMathCalculator");
		bean.add(2, 1);
		/**
		 * 多切面运行顺序：按首字母排序LogUtils先
		 * LogUtils》ValidateAspect》目标方法》ValidateAspect》LogUtils
		 * 	【LogUtils】【add】方法开始执行，用的参数列表[2, 1]
			【ValidateAspect】【add】方法开始执行，用的参数列表[2, 1]
			方法内部执行...
			【ValidateAspect】【add】方法最终结束了
			【ValidateAspect】【add】方法执行完毕，计算结果是：3
			【LogUtils】【add】方法最终结束了
			【LogUtils】【add】方法执行完毕，计算结果是：3
		 */
		/**
		 * 环绕通知的顺序只跟所在切面类中通知比（环绕只是影响当前切面）
		 * 	【环绕前置通知】【add】方法开始，传入的参数为：[2, 1]
			【LogUtils】【add】方法开始执行，用的参数列表[2, 1]
			【ValidateAspect】【add】方法开始执行，用的参数列表[2, 1]
			方法内部执行...
			【ValidateAspect】【add】方法最终结束了
			【ValidateAspect】【add】方法执行完毕，计算结果是：3
			【环绕返回通知】【add】方法开始，结果为：3
			【环绕后置通知】【add】方法结束
			【LogUtils】【add】方法最终结束了
			【LogUtils】【add】方法执行完毕，计算结果是：3
		 */
		
		System.out.println("===========");
		bean.div(2, 0);
		/**
		 * 	【LogUtils】【div】方法开始执行，用的参数列表[2, 0]
			【ValidateAspect】【div】方法开始执行，用的参数列表[2, 0]
			【ValidateAspect】【div】方法最终结束了
			【ValidateAspect】【div】方法出现异常了，异常信息是：java.lang.ArithmeticException: / by zero
			【LogUtils】【div】方法最终结束了
			【LogUtils】【div】方法出现异常了，异常信息是：java.lang.ArithmeticException: / by zero
		 */
		/**
		 * 	【环绕前置通知】【div】方法开始，传入的参数为：[2, 0]
			【LogUtils】【div】方法开始执行，用的参数列表[2, 0]
			【ValidateAspect】【div】方法开始执行，用的参数列表[2, 0]
			【ValidateAspect】【div】方法最终结束了
			【ValidateAspect】【div】方法出现异常了，异常信息是：java.lang.ArithmeticException: / by zero
			【环绕异常通知】【div】方法开始，异常信息为：java.lang.ArithmeticException: / by zero
			【环绕后置通知】【div】方法结束
			【LogUtils】【div】方法最终结束了
			【LogUtils】【div】方法出现异常了，异常信息是：java.lang.RuntimeException: java.lang.ArithmeticException: / by zero
		 */
		
	}

}
