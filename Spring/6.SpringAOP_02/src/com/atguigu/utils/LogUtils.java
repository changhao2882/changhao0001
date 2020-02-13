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
/**
 * 如何将这个类（切面类）中的这些方法（通知方法）动态的在目标方法运行的各个位置切入
 * @author 67557
 *
 */
//告诉Spring到底哪个是切面类
@Aspect

@Component
@Order(1)//使用Order改变切面顺序，数值越小优先级越高
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
	 * 
	 * 抽取可重用的切入点表达式：
	 * 1.随便声明一个没有实现的返回void的空方法
	 * 2.给方法上标注@Pointcut注解
	 */
	
	@Pointcut("execution(public int com.atguigu..MyMath*.*(..))")
	public void myPoint(){};
	
	//想在执行目标方法之前运行,写切入点表达式
	//execution(访问权限 返回值类型 方法签名)
	@Before("myPoint()")
	public static void logStart(JoinPoint joinPoint){
		//获取到目标方法运行时使用的参数
		Object[] args = joinPoint.getArgs();
		//获取到目标方法运行时使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【LogUtils】【"+signature.getName()+"】方法开始执行，用的参数列表"+Arrays.asList(args));
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
	@AfterReturning(value="myPoint()",returning="result")
	//告诉Spring （Object result用来接收返回值(returning="result")）
	public static void logReturn(JoinPoint joinPoint,Object result){
		//获取到目标方法正常执行完毕后使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【LogUtils】【"+signature.getName()+"】方法执行完毕，计算结果是："+result);
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
	@AfterThrowing(value="myPoint()",throwing="e")
	public static void logException(JoinPoint joinPoint,Exception e){
		//获取到目标方法出现异常的时候的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【LogUtils】【"+signature.getName()+"】方法出现异常了，异常信息是："+e);
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
	@After("myPoint()")
	public static void logEnd(JoinPoint joinPoint){
		//获取到目标方法正常执行完成之后使用的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("【LogUtils】【"+signature.getName()+"】方法最终结束了");
	}
	
	/**
	 * @throws Throwable 
	 * @Around:环绕								环绕通知
	 * 		是Spring中最强大的通知
	 * 		动态代理
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
	 * 四合一通知就是环绕通知
	 * 环绕通知有一个参数：ProceedingJoinPoint pjp
	 */
	@Around("myPoint()")
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
	
	
	/**
	 * 环绕通知优先于普通通知执行
	 * 	【环绕前置通知】【add】方法开始，传入的参数为：[2, 1]
		【add】方法开始执行，用的参数列表[2, 1]
		方法内部执行...
		【环绕返回通知】【add】方法开始，结果为：3
		【环绕后置通知】【add】方法结束
		【add】方法最终结束了
		【add】方法执行完毕，计算结果是：3
		===========
		【环绕前置通知】【div】方法开始，传入的参数为：[2, 0]
		【div】方法开始执行，用的参数列表[2, 0]
		【环绕异常通知】【div】方法开始，异常信息为：java.lang.ArithmeticException: / by zero
		【环绕后置通知】【div】方法结束
		【div】方法最终结束了
		【div】方法执行完毕，计算结果是：null   (环绕通知先运行，他感受到异常并吃掉了，往下感受不到了)
	 */
	
}
