package com.side.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.side.bean.DateVo;
import com.side.bean.ExamVo;
import com.side.service.TestServiceImpl;

import javassist.expr.Instanceof;

@Controller
public class MainController {
	
	@Autowired
	TestServiceImpl testService;
	
	public MainController() {
		System.out.println("MainController");
	}
	
	@RequestMapping(value= {"/index", "/" })
	public String index() {
		System.out.println("index");
		return "index";
	}
	
	@RequestMapping(value="/result")
	public String action(DateVo dateVo, Model model) {
		System.out.println("------------");
		int result = testService.insert(dateVo);
		System.out.println(result);
		
		DateVo vo = testService.select();
		model.addAttribute("vo", vo);
		
		return "result";
	}
}
