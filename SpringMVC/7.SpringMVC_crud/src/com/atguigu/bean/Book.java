package com.atguigu.bean;

import org.springframework.stereotype.Repository;


public class Book {
	private String bookName;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + "]";
	}

	public Book(String bookName) {
		super();
		this.bookName = bookName;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

}
