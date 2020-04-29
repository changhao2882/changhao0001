package com.atguigu.cache.controller;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DeptService deptepartmentService;

    @RequestMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        Department dept = deptepartmentService.getDeptById(id);
        return dept;
    }
}
