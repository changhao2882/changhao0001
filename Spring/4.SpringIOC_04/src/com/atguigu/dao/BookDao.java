package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atguigu.bean.Book;

@Repository
public class BookDao extends BaseDao<Book>{
	@Autowired
	private Book book;
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("BookDao保存了图书...");
		book.setBookName("哈哈哈");
		System.out.println(book.toString());
	}

}
