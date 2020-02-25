package com.atguigu.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.entity.Book;
import com.atguigu.entity.Cart;
import com.atguigu.entity.Order;
import com.atguigu.entity.OrderItem;
import com.atguigu.entity.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.service.impl.UserServiceImpl;

public class CartTest {
	BookDao bd = new BookDaoImpl();
	OrderService os = new OrderServiceImpl();
	UserService us = new UserServiceImpl();
	@Test
	public void test1(){
		Book book = new Book();
		book.setId(1);
		
		//从数据库中拿到一本图书
		Book one0 = bd.getOne(book);
		book.setId(4);
		Book one1 = bd.getOne(book);
		
		
		Cart cart = new Cart();
		//添加
		cart.addBook2Cart(one0);
		cart.addBook2Cart(one0);
		cart.addBook2Cart(one1);
		System.out.println("购物车总数："+cart.getTotalCount());
		System.out.println("购物车总金额："+cart.getTotalMoney());
		System.out.println("购物车中的购物项:"+cart.getAllItems());
		
		//修改
		cart.updateCount("4", "3");
		System.out.println("修改之后.............");
		System.out.println("购物车总数："+cart.getTotalCount());
		System.out.println("购物车总金额："+cart.getTotalMoney());
		System.out.println("购物车中的购物项:"+cart.getAllItems());
		
		//删除
		cart.deleteItem("4");
		System.out.println("删除之后....");
		System.out.println("购物车总数："+cart.getTotalCount());
		System.out.println("购物车总金额："+cart.getTotalMoney());
		System.out.println("购物车中的购物项:"+cart.getAllItems());
		
		//清空购物车
		cart.clear();
		System.out.println("清空之后....");
		System.out.println("购物车总数："+cart.getTotalCount());
		System.out.println("购物车总金额："+cart.getTotalMoney());
		System.out.println("购物车中的购物项:"+cart.getAllItems());
	}
	
	
	@Test
	public void test2(){
		long i =1;
		for(long j=1;j<220;j++){
			i*=j;
		}
		System.out.println("结果："+i);
	}
	
	@Test
	public void test3(){
		double i=0.1;
		double j=0.2;
		System.out.println("打印："+i);
		System.out.println("结果："+(i+j));
	}
	
	@Test
	public void test4(){
		
		
		BigDecimal decimal = new BigDecimal(1);
		
		//加法：add   乘法：multiply
		//减法：subtract   除法：divide
		//这些方法里面需要传入一个BigDecimal对象
		for (int i = 1; i < 200; i++) {
			decimal = decimal.multiply(new BigDecimal(i));
		}
		System.out.println(decimal);
	}
	
	@Test
	public void test5(){
		double i=0.1;
		double j=0.2;
		
		BigDecimal bigDecimal = new BigDecimal(i);
		BigDecimal bigDecimal2 = new BigDecimal(j);
		System.out.println(bigDecimal.add(bigDecimal2));
		
		
		//浮点数运算，我们以后都是推荐使用String构造器
		BigDecimal bigDecimal3 = new BigDecimal(i+"");
		BigDecimal bigDecimal4 = new BigDecimal("");
		System.out.println(bigDecimal3.add(bigDecimal4));
	}
	
	@Test
	public void test6(){
		String orderid = System.currentTimeMillis()+""+123;
		String format = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
		System.out.println(format);
	}
	
	@Test
	public void test7(){
		
		//1、用户登陆
		User user = new User();
		user.setUsername("admin666");
		user.setPassword("123456");
		User login = us.login(user);
		
		//2、添加到购物车
		Book book = new Book();
		book.setId(7);
		
		//从数据库中拿到一本图书
		Book one0 = bd.getOne(book);
		book.setId(8);
		Book one1 = bd.getOne(book);
		
		
		Cart cart = new Cart();
		//添加
		cart.addBook2Cart(one0);
		cart.addBook2Cart(one0);
		cart.addBook2Cart(one1);
		cart.addBook2Cart(one1);
		System.out.println("购物车总数："+cart.getTotalCount());
		System.out.println("购物车总金额："+cart.getTotalMoney());
		System.out.println("购物车中的购物项:"+cart.getAllItems());
		
		
		//结账
		String checkout = os.checkout(login, cart);
		System.out.println("结账完成:"+checkout);
	}

	@Test
	public void test8(){
		List<Order> list = os.getAllOrders();
		/*System.out.println("订单数量："+list.size());
		System.out.println("订单详情："+list);*/
		
		User user = new User();
		user.setId(2);
		List<Order> orders = os.getMyOrders(user);
		//System.out.println(orders);
		Order order = new Order();
		order.setId("201607271134084212");
		List<OrderItem> info = os.getOrderInfo(order);
		System.out.println(info);
		
		
		//os.recevied(order);
		os.send(order);
	}
}
