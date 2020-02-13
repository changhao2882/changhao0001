package com.atguigu.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ValidateAspect {
	@Before("com.atguigu.utils.LogUtils.myPoint()")
	public void logStart(JoinPoint joinPoint){
		//获取到目标方法运行时使用的参数
		Object[] args = joinPoint.getArgs();
		//获取到目标方法运行时使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【ValidateAspect】【"+signature.getName()+"】方法开始执行，用的参数列表"+Arrays.asList(args));
	}
	@AfterReturning(value="com.atguigu.utils.LogUtils.myPoint()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result){
		//获取到目标方法正常执行完毕后使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【ValidateAspect】【"+signature.getName()+"】方法执行完毕，计算结果是："+result);
	}
	@AfterThrowing(value="com.atguigu.utils.LogUtils.myPoint()",throwing="e")
	public void logException(JoinPoint joinPoint,Exception e){
		//获取到目标方法出现异常的时候的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【ValidateAspect】【"+signature.getName()+"】方法出现异常了，异常信息是："+e);
	}
	@After("com.atguigu.utils.LogUtils.myPoint()")
	public void logEnd(JoinPoint joinPoint){
		//获取到目标方法正常执行完成之后使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【ValidateAspect】【"+signature.getName()+"】方法最终结束了");
	}
}
