package com.atguigu.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.atguigu.bean.Employee;
import com.github.pagehelper.PageInfo;

/**
 * 使用Spring测试模块提供的测试请求功能，测试CRUD请求的正确性
 * Spring4测试的时候，需要servlet3.0的支持
 * @author 67557
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  //web的ioc容器也能用
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MVCTest {
	
	//传入SpringMVC的ioc
	@Autowired
	WebApplicationContext context;
	
	//虚拟mvc请求，获取到处理结果
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception{
		//模拟请求拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
		
		//请求成功以后，请求域中会有pageInfo,我们取出pageInfo来验证
		MockHttpServletRequest request = result.getRequest();
		PageInfo page = (PageInfo) request.getAttribute("pageInfo");
		
		System.out.println("当前页码："+page.getPageNum());
		System.out.println("总页码："+page.getPages());
		System.out.println("总记录数："+page.getTotal());
		System.out.println("当前页有几条记录："+page.getSize());
		System.out.println("当前页的pageSize："+page.getPageSize());
		System.out.println("前一页："+page.getPrePage());
		System.out.println("结果："+page.getList());//查询结果
		
		int[] nums = page.getNavigatepageNums();
		for (int i : nums) {
			System.out.print(" "+i);
		}
		
		//获取员工数据
		List<Employee> list = page.getList();
		for (Employee employee : list) {
			System.out.println("ID:"+employee.getEmpId()+" Name"+employee.getEmpName());
		}
		
		
		
	}
	
	
	
	
	
	
	
}
