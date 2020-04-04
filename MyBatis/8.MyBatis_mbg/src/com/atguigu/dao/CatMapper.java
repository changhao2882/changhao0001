package com.atguigu.dao;

import com.atguigu.bean.Cat;
import com.atguigu.bean.CatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cat
     *
     * @mbggenerated Wed Mar 25 20:47:12 CST 2020
     */
    int countByExample(CatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cat
     *
     * @mbggenerated Wed Mar 25 20:47:12 CST 2020
     */
    int deleteByExample(CatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cat
     *
     * @mbggenerated Wed Mar 25 20:47:12 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cat
     *
     * @mbggenerated Wed Mar 25 20:47:12 CST 2020
     */
    int insert(Cat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cat
     *
     * @mbggenerated Wed Mar 25 20:47:12 CST 2020
     */
    int insertSelective(Cat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cat
     *
     * @mbggenerated Wed Mar 25 20:47:12 CST 2020
     */
    List<Cat> selectByExample(CatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cat
     *
     * @mbggenerated Wed Mar 25 20:47:12 CST 2020
     */
    Cat selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cat
     *
     * @mbggenerated Wed Mar 25 20:47:12 CST 2020
     */
    int updateByExampleSelective(@Param("record") Cat record, @Param("example") CatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cat
     *
     * @mbggenerated Wed Mar 25 20:47:12 CST 2020
     */
    int updateByExample(@Param("record") Cat record, @Param("example") CatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cat
     *
     * @mbggenerated Wed Mar 25 20:47:12 CST 2020
     */
    int updateByPrimaryKeySelective(Cat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cat
     *
     * @mbggenerated Wed Mar 25 20:47:12 CST 2020
     */
    int updateByPrimaryKey(Cat record);
}