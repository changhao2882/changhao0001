package com.atguigu.cache.mapper;

import com.atguigu.cache.bean.Department;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id = #{id}")
    Department getDeptById(Integer id);
}
