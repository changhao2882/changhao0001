package com.atguigu.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.bean.Teacher;
import com.atguigu.dao.TeacherDao;


public class MyBatisCRUDTest {
	
	//工厂来一个就行了
	SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void initSqlSessionFactory() throws IOException{
		//1.根据全局配置文件创建一个sqlSessionFactory
		//SqlSessionFactory：是SqlSession工厂，负责创建SqlSession对象；
		//SqlSession：sql会话（代表和数据库的一次会话）
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//public Teacher getTeacherById(Integer id);
	@Test
	public void test() {
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			TeacherDao mapper = openSession.getMapper(TeacherDao.class);
			
			Teacher teacher = new Teacher();
			teacher = mapper.getTeacherById(1);
			System.out.println(teacher);
			
		} finally {
			openSession.close();
		}
	}
	
	//public List<Teacher> getTeacherByCondition(Teacher teacher);  查询符合条件的teacher
	@Test
	public void test01() {
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			TeacherDao mapper = openSession.getMapper(TeacherDao.class);
			
			Teacher teacher = new Teacher();
			teacher.setId(1);
			//teacher.setName("%a%");
			teacher.setBirth(new Date());
			List<Teacher> teachers = mapper.getTeacherByCondition(teacher);
			System.out.println(teachers);
			
		} finally {
			openSession.close();
		}
	}
	
	//public List<Teacher> getTeacherByIdIn(List<Integer> ids);
	@Test
	public void test02() {
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			TeacherDao mapper = openSession.getMapper(TeacherDao.class);
			
			List<Teacher> teachers = mapper.getTeacherByIdIn(Arrays.asList(1,2,3,4,5));
			System.out.println(teachers);
			
		} finally {
			openSession.close();
		}
	}
		
	//public List<Teacher> getTeacherByConditionChoose(Teacher teacher);
	@Test
	public void test03() {
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			TeacherDao mapper = openSession.getMapper(TeacherDao.class);
			
			Teacher teacher2 = new Teacher();
			//teacher2.setId(1);
			//teacher2.setName("admin");
			List<Teacher> list = mapper.getTeacherByConditionChoose(teacher2);
			System.out.println(list);
			
		} finally {
			openSession.close();
		}
	}
	
	//public int updateTeacher(Teacher teacher);
	@Test
	public void test04() {
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			TeacherDao mapper = openSession.getMapper(TeacherDao.class);
			
			Teacher teacher = new Teacher();
			teacher.setId(1);
			teacher.setName("hahaha");
			int updateTeacher = mapper.updateTeacher(teacher);
			System.out.println(updateTeacher);
			
			Teacher teacher1 = new Teacher();
			teacher1 = mapper.getTeacherById(1);
			System.out.println(teacher1);
			
			openSession.commit();
		} finally {
			openSession.close();
		}
	}
		
		
}
