package com.atguigu.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.service.BookService;
import com.atguigu.service.MulService;

public class TxTest {
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");
	//有事务的业务逻辑，容器中保存的是这个业务逻辑的代理对象:class com.atguigu.service.BookService$$EnhancerByCGLIB$$22af933f
	@Test
	public void test() throws FileNotFoundException {
		BookService bean = ioc.getBean(BookService.class);
//		bean.checkout("Tom", "ISBN-001");
		int price = bean.getPrice("ISBN-001");
		System.out.println("读取到的数据："+price);
		System.out.println(bean.getClass());
	}
	/**
	 * mulTx(){
	 * 		//REQUIRED
	 * 		A(){
	 * 			//REQUIRES_NEW
	 * 			B(){}
	 * 			//REQUIRED
	 * 			C(){}
	 * 		}
	 * 		//REQUIRES_NEW
	 * 		D(){
	 * 			DDD(){}  //REQUIRES_NEW不崩   REQUIRED崩
	 * 			//REQUIRED
	 * 			E(){
	 * 				//REQUIRES_NEW
	 * 				F(){
	 * 					int a = 10/0;
	 * 				}
	 * 			}
	 * 			//REQUIRES_NEW
	 * 			G(){}
	 * 		}
	 * 		int b = 10/0;
	 * }
	 * 
	 * //如果是REQUIRED，事务的属性都是继承于大事务REQUIRES_NEW是可以调整的
	 * REQUIRED：将之前事务用的connection传递给这个方法使用
	 * REQUIRES_NEW，这个方法直接使用新的connection
	 */
	@Test
	public void test01() {
		MulService bean = ioc.getBean(MulService.class);
		bean.mulTx();
	}
	
	/**
	 * MulServiceProxy.mulTx(){
			bookServiceProxy.checkout("Tom", "ISBN-001");
			bookServiceProxy.updatePrice("ISBN-002", 998);
	   }
	 * 本类方法的嵌套调用就是一个事务
	 * BookServiceProxy.mulTx(){
	 * 		checkout();
	 * 		updatePrice();
	 * 		//相当于
	 * 		bookDao.updateStock(isbn);
	 * 		bookDao.updateBalance(userName, bookDao.getPrice(isbn));
	 * 
	 * 		bookDao.updatePrice(isbn,price);
	 * }
	 */

}
