package com.atguigu.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
/**
 * SpringMVC除过在方法上传入原生的request和session外还能怎么样把数据带给页面
 * 
 * 1）、可以在方法处传入Map、或者Model或者ModelMap。
 * 		给这些参数里面保存的所有数据都会放在请求域中。可以在页面获取
 *   关系：
 *   	Map，Model，ModelMap：最终都是BindingAwareModelMap在工作；
 *   		handle01...map的类型class org.springframework.validation.support.BindingAwareModelMap
 *			handle02...model的类型class org.springframework.validation.support.BindingAwareModelMap
 *			handle03...modelmap的类型class org.springframework.validation.support.BindingAwareModelMap
 *   	相当于给BindingAwareModelMap中保存的东西都会被放在请求域中；
 * 
 * 		Map(interface(jdk))      Model(interface(spring))  
 * 			||							//
 * 			||	（实现）				   //
 * 			\/						  //
 * 		ModelMap(class)			     //
 * 					\\(继承)			//（实现）
 * 					 \\	           //
 * 					ExtendedModelMap
 * 							||  继承（extends）
 * 							\/
 * 					BindingAwareModelMap
 * 
 * 2）、方法的返回值可以变为ModelAndView类型；
 * 			既包含视图信息（页面地址）也包含模型数据（给页面带的数据）；
 * 			而且数据是放在请求域中；
 * 			request（请求一完数据就没了，就很快）、session（运行时间一长就崩了）、application（谁都能看见）；
 * 			
 * 3）、SpringMVC提供了一种可以临时给Session域中保存数据的方式；
 * 	使用一个注解	@SessionAttributes(只能标在类上)
 * 	@SessionAttributes(value="msg"):
 * 		给BindingAwareModelMap中保存的数据，或者ModelAndView中的数据，
 * 		同时给session中放一份；
 * 		value指定保存数据时要给session中放的数据的key；
 * 
 * 	value={"msg"}：只要保存的是这种key的数据，给Session中放一份
 * 	types={String.class}：只要保存的是这种类型的数据，给Session中也放一份
 * 
 *  后来推荐@SessionAttributes就别用了，可能会引发异常；
 * 			给session中放数据请使用原生API；
 *
 */
@SessionAttributes(value={"msg"},types={String.class})
@Controller
public class OutputController {
	@RequestMapping(value="/handle01")
	public String handle01(Map<String, Object> map) {
		map.put("msg", "你好");
		map.put("haha", "哈哈哈");
		System.out.println("handle01...map的类型"+map.getClass());
		return "success";
	}
	
	/**
	 * Model：一个接口
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/handle02")
	public String handle02(Model model) {
		model.addAttribute("msg", "你好啊");
		model.addAttribute("haha", 18);
		System.out.println("handle02...model的类型"+model.getClass());
		return "success";
	}
	
	@RequestMapping(value="/handle03")
	public String handle03(ModelMap modelMap) {
		modelMap.addAttribute("msg", "你好呀");
		System.out.println("handle03...modelmap的类型"+modelMap.getClass());
		return "success";
	}
	
	//返回值是ModelAndView，可以为页面携带数据
	@RequestMapping(value="/handle04")
	public ModelAndView handle04() {
		//之前的返回值我们就叫视图名，视图名：视图解析器是会帮我们最终拼串得到页面的真实地址
		//ModelAndView modelAndView = new ModelAndView("success");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		modelAndView.addObject("msg", "哦哦哦");
		System.out.println("handle04...");
		return modelAndView;
	}
}
