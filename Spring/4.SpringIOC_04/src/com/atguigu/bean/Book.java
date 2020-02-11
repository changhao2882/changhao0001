package com.atguigu.bean;

import org.springframework.stereotype.Component;

@Component
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
	

}
