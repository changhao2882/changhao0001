package com.atguigu.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/**
 * 如何将这个类（切面类）中的这些方法（通知方法）动态的在目标方法运行的各个位置切入
 * @author 67557
 *
 */
//告诉Spring到底哪个是切面类
@Aspect

@Component
public class LogUtils {
	/**
	 * 告诉Spring每个方法都什么时候运行
	 * try{
	 * 		@Before
	 * 		method.invoke(obj,args);
	 * 		@AfterReturning
	 * }catch(e){
	 * 		@AfterThrowing
	 * }finally{
	 * 		@After
	 * }
	 * 
	 * @Before:在目标方法之前运行					前置通知
	 * @After:在目标方法结束之后运行				后置通知
	 * @AfterReturning:在目标方法正常返回之后		返回通知
	 * @AfterThrowing:在目标方法抛出异常之后		异常通知
	 * @Around:环绕								环绕通知
	 */
	
	//想在执行目标方法之前运行,写切入点表达式
	//execution(访问权限 返回值类型 方法签名)
	@Before("execution(public int com.atguigu.impl.MyMathCalculator.*(..))")
	public static void logStart(JoinPoint joinPoint){
		//获取到目标方法运行时使用的参数
		Object[] args = joinPoint.getArgs();
		//获取到目标方法运行时使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【"+signature.getName()+"】方法开始执行，用的参数列表"+Arrays.asList(args));
	}
	/**
	 * 切入点表达式的写法
	 * 固定写法：execution(访问权限 返回值类型 方法全类名（参数表）)
	 * 	通配符：
	 * 		*：
	 * 			1)匹配一个或多个字符execution(public int com.atguigu.impl.MyMath*r.*(int, int))
	 * 			2）匹配任意一个参数，第一个是int类型，第二个参数任意类型：（值匹配）
	 * 				execution(public int com.atguigu.impl.MyMath*r.*(int, *))
	 * 			3）只能匹配一层路径
	 * 				execution(public int com.atguigu.*.MyMath*r.*(..))
	 * 			4）权限位置不能*表示（不写就是任意权限）【public可选】
	 * 		..：
	 * 			1）匹配任意多个参数，任意类型参数
	 * 				execution(public int com.atguigu.impl.MyMath*r.*(..))
	 * 			2）匹配任意多层路径
	 * 				execution(public int com.atguigu..MyMath*r.*(..))
	 * 记住两种：
	 * 	最精确的：execution(public int com.atguigu.impl.MyMathCalculator.add(int,int))
	 * 	最模糊的：execution(* *.*(..));千万别写
	 * 
	 * ③在AspectJ中，切入点表达式可以通过 “&&”、“||”、“!”等操作符结合起来。
	 * 表达式	execution (* *.add(int,..)) || execution(* *.sub(int,..))
	 * 含义	任意类中第一个参数为int类型的add方法或sub方法
	 * 
	 */
	//想在目标方法正常执行完毕后执行
	@AfterReturning(value="execution(public int com.atguigu..MyMath*.*(..))",returning="result")
	//告诉Spring （Object result用来接收返回值(returning="result")）
	public static void logReturn(JoinPoint joinPoint,Object result){
		//获取到目标方法正常执行完毕后使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【"+signature.getName()+"】方法执行完毕，计算结果是："+result);
	}
	
	/**
	 * 细节四：我们可以在通知方法运行时，拿到目标方法的详细信息；
	 * 1）只需要为通知方法的参数列表上写一个参数；
	 * 		JoinPoint joinPoint:封装了当前目标方法的详细信息
	 * 2）告诉Spring哪个参数用来接收异常
	 * 3）Exception e：指定通知方法可以接收哪些异常，写小了走不到这一步；上面result也一样
	 * 
	 * ajax接收服务器数据
	 * 	$.post(url,function(abc){
	 * 		alert(abc)
	 * 	})
	 */
	//想在目标方法出现异常的时候执行
	@AfterThrowing(value="execution(public int com.atguigu.impl.MyMathCalculator.*(..))",throwing="e")
	public static void logException(JoinPoint joinPoint,Exception e){
		//获取到目标方法出现异常的时候的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【"+signature.getName()+"】方法出现异常了，异常信息是："+e);
	}
	
	/**
	 * Spring对通知方法的要求不严格
	 * 唯一要求的就是方法的参数列表一定不能乱写？
	 * 	通知方法是Spring利用反射调用的，每次方法调用得确定这个方法的参数表的值
	 * 	参数表上的每一个参数，Spring都得知道是什么？
	 * 	JoinPoint：认识
	 * 	不知道的参数一定告诉Spring这是什么？
	 * @param joinPoint
	 */
	//想在目标方法正常执行完成之后执行
	@After("execution(public int com.atguigu.impl.MyMathCalculator.*(..))")
	public static void logEnd(JoinPoint joinPoint){
		//获取到目标方法正常执行完成之后使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【"+signature.getName()+"】方法最终结束了");
	}

}
