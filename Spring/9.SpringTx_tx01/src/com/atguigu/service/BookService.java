package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.dao.BookDao;

@Service
public class BookService {
	@Autowired
	BookDao bookDao;
	//结账，传入哪个用户买了哪本书
	@Transactional  //3.给事务方法加注解
	public void checkout(String userName,String isbn){
		//减库存
		bookDao.updateStock(isbn);
		//减余额
		bookDao.updateBalance(userName, bookDao.getPrice(isbn));
	}
}
