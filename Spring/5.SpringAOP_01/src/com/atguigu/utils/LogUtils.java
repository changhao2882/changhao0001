package com.atguigu.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtils {
	/**
	 * Object ...objects这种参数定义是在不确定方法参数的情况下的一种多态表现形式。
	 * 即这个方法可以传递多个参数，这个参数的个数是不确定的。
	 * 这样你在方法体中需要相应的做些处理。因为Object是基类，
	 * 所以使用Object ...objects这样的参数形式，允许一切继承自Object的对象作为参数。
	 * 这种方法在实际中应该还是比较少用的。
	 * @param method
	 * @param args
	 */
	public static void logStart(Method method,Object... args){
		System.out.println("【"+method.getName()+"】方法开始执行，用的参数列表"+Arrays.asList(args));
	}
	public static void logReturn(Method method,Object... result){
		System.out.println("【"+method.getName()+"】方法执行完毕，计算结果是："+Arrays.asList(result));
	}
	public static void logException(Method method,Exception e){
		System.out.println("【"+method.getName()+"】方法出现异常了，异常信息是："+e.getCause());
	}
	public static void logEnd(Method method,Object... args){
		System.out.println("【"+method.getName()+"】方法最终结束了");
	}

}
