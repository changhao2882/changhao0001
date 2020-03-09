package com.atguigu.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping("/upload")
	public String upload(Model model,@RequestParam(value="username",required=false)String username,
			@RequestParam("headerimg")MultipartFile file[]){
		
		System.out.println("上传的文件的信息");
		for (MultipartFile multipartFile : file) {
			if(!multipartFile.isEmpty()){
				//文件保存
				try {
					multipartFile.transferTo(new File("D:\\"+multipartFile.getOriginalFilename()));
					model.addAttribute("msg", "文件上传成功");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					model.addAttribute("msg", "文件上传失败"+e.getMessage());
				}
			}
		}
		
		return "forward:/index.jsp";
	}
	
	
//	@RequestMapping("/upload")
//	public String upload(Model model,@RequestParam(value="username",required=false)String username,
//			@RequestParam("headerimg")MultipartFile file){
//		System.out.println("上传的文件的信息");
//		System.out.println("文件项的名字"+file.getName());
//		System.out.println("文件的名字"+file.getOriginalFilename());
//		
//		//文件保存
//		try {
//			file.transferTo(new File("D:\\"+file.getOriginalFilename()));
//			model.addAttribute("msg", "文件上传成功");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			model.addAttribute("msg", "文件上传失败"+e.getMessage());
//		}
//		
//		return "forward:/index.jsp";
//	}
}
