package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 减余额
	 * 
	 * 减去某个用户的余额
	 */
	public void updateBalance(String userName,int price){
		String sql="UPDATE account SET balance=balance-? WHERE username=?";
		jdbcTemplate.update(sql, price,userName);
	}
	
	//获取某本图书的价格
	public int getPrice(String isbn){
		String sql="SELECT price FROM book WHERE isbn=?";
		Integer queryForObject = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return queryForObject;
	}
	
	//减库存,减去某本书的库存
	public void updateStock(String isbn){
		String sql="UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
		jdbcTemplate.update(sql, isbn);
	}
	
	//更新图书价格
	public void updatePrice(String isbn,int price){
		String sql="UPDATE book SET price=? WHERE isbn=?";
		jdbcTemplate.update(sql, price,isbn);
	}
	
	
}
