package com.zeng.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="abc")
public class MyControl {
	/*@RequestMapping(value="show")
	public String show(){
		System.out.println("������show..");
		
		return "main";
	}
*/
	/*//���ղ����ĵ�һ�ַ�ʽ
	 @RequestMapping(value="show")
	public String show(@RequestParam(name="name",required=false,defaultValue="lisi")String str){
		System.out.println("name:"+str);
		return "main";
	}*/
	/*//���ղ����ĵڶ��ַ�ʽ�������봫�ݵĲ�������ͬ���β���
	@RequestMapping(value="show")
	public String show(String name){
		System.out.println("name:"+name);
		return "main";
	} */
	/*
	//�����ö�����ղ���
	@RequestMapping(value="show")
	public String show(HttpServletRequest request){
		System.out.println("name:"+request.getParameter("name"));
		return "main";
	}*/
	
	/*//�����ܵĲ������ݸ�ҳ��
	@RequestMapping(value="show")
	public String show(String name,Model model){
		System.out.println("name:"+name);
		model.addAttribute("name", name);
		return "main";
	}*/
	
	/*@RequestMapping(value="show")
	public String show(String name,HttpServletRequest request){
		System.out.println("name:"+name);
		request.setAttribute("name", name);
		return "main";
	}*/
	@RequestMapping(value="show")
	public String show(Model model){
		String msg="hello";
		model.addAttribute("msg", msg);
		return "main";
	}
	@RequestMapping(value="show")
	public String show3(Model model){
		String msg="hello";
		model.addAttribute("msg", msg);
		return "main";
	}
	
	@RequestMapping(value="show")
	public String show4(Model model){
		String msg="hello";
		model.addAttribute("msg", msg);
		return "main";
	}
	@RequestMapping(value="show")
	public String show6(Model model){
		String msg="hello";
		model.addAttribute("msg", msg);
		return "main";
	}
	
}