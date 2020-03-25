package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Teacher;

public interface TeacherDao {
	public Teacher getTeacherById(Integer id);
	public List<Teacher> getTeachers();

}
