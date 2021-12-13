package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//로그인이 필요한 서비스에 대해 여러개 등록 
//@WebFilter(urlPatterns = {"/board/*", "/comment/*"}) 
public class LoginFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		//요청을 받을 때 전달 받은 정보를 HttpServletRequest객체를 생성하여 저장
		HttpServletRequest req = (HttpServletRequest) request; 
		
		//웹브라우저에게 응답을 돌려줄 HttpServletResponse객체를 생성
		HttpServletResponse resp = (HttpServletResponse) response; 
		
		
		//로그인을 했는지 안했는지 - 세션
		HttpSession session = req.getSession(); //로그인 정보 얻어오기
		//String logined = (String) session.getAttribute("logined");
		
		boolean logined  = false;
		if(session.getAttribute("logined") != null) {
			logined = (boolean)session.getAttribute("logined");
		}
		 if(logined) {
			 chain.doFilter(request, response); // 로그인 되면 다음 필터로 다음 필터가 없다면 컨트롤러로
		} else {
			resp.sendRedirect(req.getContextPath() + "/login"); //안되면 로그인으로 리다이렉트
		}
	}
		
		

}
