package com.atguigu.controller;

import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.Employee;
import com.atguigu.bean.Msg;
import com.atguigu.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn){
		
		//引入PageHelper插件
		PageHelper.startPage(pn, 5);
		List<Employee> emps = employeeService.getAll();
		
		PageInfo<Employee> page = new PageInfo<>(emps, 5);
		
		
		return Msg.success().add("pageInfo",page);
	}
	
	
	
	//查询员工数据
	//@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		
		//引入PageHelper插件
		PageHelper.startPage(pn, 5);
		List<Employee> emps = employeeService.getAll();
		
		PageInfo<Employee> page = new PageInfo<>(emps, 5);
		System.out.println("当前页码："+page.getPageNum());
		System.out.println("总页码："+page.getPages());
		System.out.println("总记录数："+page.getTotal());
		System.out.println("当前页有几条记录："+page.getSize());
		System.out.println("当前页的pageSize："+page.getPageSize());
		System.out.println("前一页："+page.getPrePage());
		System.out.println("结果："+page.getList());//查询结果
		int[] nums = page.getNavigatepageNums();
		
		model.addAttribute("pageInfo", page);
		return "list";
	}
	
	//保存员工数据
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			//校验失败应该返回失败，在模态框中显示校验失败的错误信息
			HashMap<String, Object> hashMap = new HashMap<>();
			List<FieldError> error = bindingResult.getFieldErrors();
			for (FieldError fieldError : error) {
				System.out.println("错误的字段名："+fieldError.getField());
				System.out.println("错误的信息："+fieldError.getDefaultMessage());
				hashMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", hashMap);
		}else{
			employeeService.saveEmp(employee);
			return Msg.success();
		}
		
	}
	
	
	//校验用户名是否重复
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("empName")String empName){
		
		//先判断用户名是否是合法的表达式
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!empName.matches(regx)){
			return Msg.fail().add("va_msg", "用户名应为2-5位中文，或者6-16位英文和数字");
		}
		
		boolean b = employeeService.checkUser(empName);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "用户重复");
		}
	}
	
	//查询单个员工信息
	@ResponseBody
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public Msg getEmp(@PathVariable("id")Integer id){
			
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}
		
	//保存员工数据
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg saveEmp(Employee employee){
		employeeService.updateEmp(employee);
		return Msg.success();
			
	}
	
	//删除单个和多个员工
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//组装id的数组
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			employeeService.deleteBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}
		return Msg.success();
	}
	
	
//	@RequestMapping("/getall")
//	public String getAll(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
//		//紧跟他的查询就是一个分页查询
//		PageHelper.startPage(pn, 5);
//		List<Teacher> list = teacherService.getAll();
//		
//		//我们可以将查询的结果使用；将查询的结果放在pageinfo中这个pageInfo就有非常多能够用的
//		//第二份传入连续要显示的页码
//		PageInfo<Teacher> info = new PageInfo<>(list, 6);
//		System.out.println("当前页码："+info.getPageNum());
//		System.out.println("总页码："+info.getPages());
//		System.out.println("总记录数："+info.getTotal());
//		System.out.println("当前页有几条记录："+info.getSize());
//		System.out.println("当前页的pageSize："+info.getPageSize());
//		System.out.println("前一页："+info.getPrePage());
//		System.out.println("结果："+info.getList());//查询结果
//		int[] nums = info.getNavigatepageNums();
//		
//		model.addAttribute("info", info);
//		return "success";
//	}
	
}
