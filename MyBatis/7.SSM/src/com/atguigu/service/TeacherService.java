package com.atguigu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Teacher;
import com.atguigu.dao.TeacherDao;

@Service
public class TeacherService {
	//@Autowired
	//SqlSessionFactory sqlSessionFactory;
	@Autowired
	private TeacherDao teacherDao;
	
	public Teacher getTeacher(Integer id) {
		// TODO Auto-generated method stub
		Teacher teacherById = teacherDao.getTeacherById(id);
		return teacherById;
	}

	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		List<Teacher> teachers = teacherDao.getTeachers();
		return teachers;
	}
	
}
