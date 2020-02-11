package com.atguigu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.atguigu.inter.Calculator;
import com.atguigu.utils.LogUtils;
/**
 * 帮Calculator.java生成代理对象的类
 * Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 * @author 67557
 *
 */
public class CalculatorProxy {
	/**
	 * 为传入的参数对象创建一个动态代理对象
	 * @param calculator
	 * @return
	 * Calculator calculator：被代理对象
	 * 返回的：代理对象
	 */
	public static Calculator getProxy(final Calculator calculator) {
		//被代理对象的类加载器
		ClassLoader loader = calculator.getClass().getClassLoader();
		//对象所实现的所有接口
		Class<?>[] interfaces = calculator.getClass().getInterfaces();
		//方法执行器。帮我们目标对象执行目标方法
		InvocationHandler h = new InvocationHandler() {
			/**
			 * Object proxy:代理对象，给jdk使用，任何时候都不要动这个对象
			 * Method method:当前要执行的目标对象的方法
			 * Object[] args:这个方法调用是外界传入的参数值
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				Object result = null;
				try {
					LogUtils.logStart(method, args);
					result = method.invoke(calculator, args);
					LogUtils.logReturn(method, result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					LogUtils.logException(method, e);
				}finally{
					LogUtils.logEnd(method, args);
				}
				//返回值必须返回出去外界才能拿到真正执行后的返回值
				return result;
			}
		};
		// TODO Auto-generated method stub
		//Proxy为目标创建代理对象
		Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
		return (Calculator) proxy;
	}

}
