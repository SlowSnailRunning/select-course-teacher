package edu.snail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.snail.model.SysUser;
import edu.snail.service.TestService;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/SpringMVC")
	public String SpringMVC(Model model) {
		model.addAttribute("msg","Spring MVC can work");
		return "test";
	}
	
	@RequestMapping("/MyBatis")
	@ResponseBody
	public List<SysUser> MyBatis() {
		List<SysUser> userList = null;
		try {
			userList=testService.findAllUser();
			System.out.println("MyBatis and fastjson can work");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
}
