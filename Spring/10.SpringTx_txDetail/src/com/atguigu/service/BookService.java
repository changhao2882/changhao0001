package com.atguigu.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.dao.BookDao;

@Service
public class BookService {
	@Autowired
	BookDao bookDao;
	//结账，传入哪个用户买了哪本书
	
	/**
	 * 事务细节：
	 * 	isolation-Isolation：事务的隔离级别
	 * 	propagation-Propagation：事务的传播行为
	 * 		传播行为(事务的传播+事务的行为)：
	 * 			如果有多个事务进行嵌套运行，子事务是否要和大事务共用一个事务；
	 * 	传播行为：
	 * 	AService{
	 * 		tx_a(){
	 * 			//a的一些方法
	 * 			tx_b(){
	 * 			}
	 * 			tx_c(){
	 * 			}
	 * 		}
	 * 	}
	 * 	当事务方法被另一个事务方法调用时，必须指定事务应该如何传播。
	 * 	例如：方法可能继续在现有事务中运行，也可能开启一个新事务，并在自己的事务中运行。
	 * 	事务的传播行为可以由传播属性指定。Spring定义了7种类传播行为。
	 * 	REQUIRED	支持当前事务，假设当前没有事务。就新建一个事务
	 *  SUPPORTS	支持当前事务，假设当前没有事务，就以非事务方式运行
	 *  MANDATORY	支持当前事务，假设当前没有事务，就抛出异常
	 *  REQUIRES_NEW	新建事务，假设当前存在事务。把当前事务挂起
	 *  NOT_SUPPORTED	以非事务方式运行操作。假设当前存在事务，就把当前事务挂起
	 *  NEVER	以非事务方式运行，假设当前存在事务，则抛出异常
	 *  NESTED	如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
	 * 
	 * 	noRollbackFor-Class[]：哪些异常事务可以不回滚
	 * 	noRollbackForClassName-String[]（String全类名）：
	 * 	rollbackFor-Class[]：哪些异常事务需要回滚
	 * 	rollbackForClassName-String[]：
	 * 
	 * 异常分类：
	 * 		运行时异常（非检查异常）：可以不用处理；（默认都回滚）
	 * 		编译时异常（检查异常）：要么try-catch，要么在方法上声明throws；（默认不回滚）
	 * 
	 * 	readOnly-boolean：设置事务为只读事务
	 * 		可以进行事务优化；
	 * 		readOnly=true，加快查询速度；不用管事务的那一堆操作了
	 * 	timeout-int（秒为单位）：超时；事务超出指定执行时长后自动终止并回滚
	 * @throws FileNotFoundException 
	 */
	//@Transactional(timeout=3,readOnly=false,noRollbackFor={ArithmeticException.class,NullPointerException.class},rollbackFor={FileNotFoundException.class})  //3.给事务方法加注解
	//如果是REQUIRED，事务的属性都是继承于大事务REQUIRES_NEW是可以调整的
	@Transactional(propagation=Propagation.REQUIRED/*,timeout=3*/)
	public void checkout(String userName,String isbn) /*throws FileNotFoundException*/{
		//减库存
		bookDao.updateStock(isbn);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//减余额
		bookDao.updateBalance(userName, bookDao.getPrice(isbn));
		
		//noRollbackFor
//		int i = 10/0;
		
//		new FileInputStream("D://hahaha.txt");
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updatePrice(String isbn,int price){
		bookDao.updatePrice(isbn,price);
//		int i = 10/0;
	}
	
	/**
	 * 根据业务的特性，进行调整
	 */
	@Transactional(readOnly=true,isolation=Isolation.READ_UNCOMMITTED)
	public int getPrice(String isbn){
		return bookDao.getPrice(isbn);
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
