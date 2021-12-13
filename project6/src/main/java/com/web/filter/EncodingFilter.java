package com.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*") //모든 요청 인코딩 처리 별찍기
public class EncodingFilter implements Filter {

 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		//체인을 기점으로 해서 위가 요청필터
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		//아래가 응답 필터
		response.setContentType("text/html, charset=utf-8");
	}


}
