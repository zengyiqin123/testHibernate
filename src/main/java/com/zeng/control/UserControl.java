package com.zeng.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zeng.entity.Users;

@Controller
@RequestMapping("uc")
public class UserControl {
	/*@RequestMapping(value="islogin",method=RequestMethod.POST)
	public String islogin(String loginname,String loginpwd){
		System.out.println("loginname:"+loginname+",loginpwd:"+loginpwd);;
		return "user/suc";
	}*/
	/*@RequestMapping(value="islogin",method=RequestMethod.POST)
	public String islogin(Users users){
		System.out.println(users);
		return "user/suc";
	}*/
	@RequestMapping(value="checklogin",method=RequestMethod.GET)
	public String islogin(Model model){
		model.addAttribute(new Users());
		System.out.println("经过了islogin");
		return "user/login2";
	}
	@RequestMapping(value="checklogin",method=RequestMethod.POST)
	public String islogin(Users user){
		System.out.println("经过了islogin");
		System.out.println(user);
		return "user/suc";
	}
	@RequestMapping(value="chainlogin",method=RequestMethod.GET)
	public ModelAndView chainlogin(Users users){
		ModelAndView mav = new ModelAndView();
		System.out.println(users.getLoginname()+","+users.getLoginpwd());
		users.setSex("man");
		mav.addObject(users);
		mav.setViewName("redirect:/uc/showinfo");
		return mav;
	}
	
	@RequestMapping(value="showinfo",method=RequestMethod.GET)
	public String showinfo(Model model){
		model.addAttribute("msg", "用户信息");
		return "user/suc";
	}
}
