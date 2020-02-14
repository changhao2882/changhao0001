package com.atguigu.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class LogUtils {
	
	
	public static void logStart(JoinPoint joinPoint){
		//获取到目标方法运行时使用的参数
		Object[] args = joinPoint.getArgs();
		//获取到目标方法运行时使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【LogUtils】【"+signature.getName()+"】方法开始执行，用的参数列表"+Arrays.asList(args));
	}
	
	public static void logReturn(JoinPoint joinPoint,Object result){
		//获取到目标方法正常执行完毕后使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【LogUtils】【"+signature.getName()+"】方法执行完毕，计算结果是："+result);
	}
	
	public static void logException(JoinPoint joinPoint,Exception e){
		//获取到目标方法出现异常的时候的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【LogUtils】【"+signature.getName()+"】方法出现异常了，异常信息是："+e);
	}
	
	public static void logEnd(JoinPoint joinPoint){
		//获取到目标方法正常执行完成之后使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【LogUtils】【"+signature.getName()+"】方法最终结束了");
	}
	
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
		
		Object[] args = pjp.getArgs();
		String name = pjp.getSignature().getName();
		
		Object proceed = null;
		try {
			System.out.println("【环绕前置通知】【"+name+"】方法开始，传入的参数为："+Arrays.asList(args));
			//就是利用反射调用目标方法,就是method.invoke(obj,args);
			proceed = pjp.proceed(args);
			System.out.println("【环绕返回通知】【"+name+"】方法开始，结果为："+proceed);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("【环绕异常通知】【"+name+"】方法开始，异常信息为："+e);
			//为了让外界能知道这个异常，这个异常一定抛出去
			throw new RuntimeException(e);
		}finally{
			System.out.println("【环绕后置通知】【"+name+"】方法结束");
		}
		
		//反射调用后的返回值也一定返回出去
		return proceed;
	}
	
	
}
