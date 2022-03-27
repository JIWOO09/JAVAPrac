package com.newlecture.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//인터페이스 구현
public class IndexController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("index contriller");
		//담기
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", "Hi MVC");
		//컨트롤를 통해야만 페이지 볼 수 있다.
		mv.setViewName("/WEB-INF/view/index.jsp");
		
		return mv;
	}

	
}
