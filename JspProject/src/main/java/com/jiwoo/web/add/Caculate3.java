package com.jiwoo.web.add;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Caculate3 extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
	
		
		//서버로 쿠키 읽어오기 : 쿠키가 여러개니까 배열로 
		Cookie[] cookies = request.getCookies();
		
		//사용자 입력
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		String exp ="";
		//널이 아닌 조건
		if(cookies != null)
			for(Cookie c : cookies) 
				if(c.getName().equals("exp")) {//쿠키이름검색
					exp = c.getValue(); //찾는 이름이라면 변수에 담자
					break; //찾았으면 그만
				}
		//null이 아니고 = 인경우 -> 최종계산하기
		if(operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		//C를 눌렀을 때 숫자취소 되면서 쿠키삭제	
		} else if(operator != null && operator.equals("C")) {
			 exp ="";
			 
			//= 아닌 경우	
			}else {
		
				//값 누적
				exp += (value == null)?"" : value;
		
				//null이 아닌 것만 누적
				exp += (operator == null)?"" : operator;
				exp += (dot == null)?"" : dot;
		
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		
		//C를 눌렀을 경우에만 
		if(operator != null && operator.equals("C"))
		expCookie.setMaxAge(0);//쿠키 바로 소멸
		
		response.addCookie(expCookie);
		//페이지 전환 
		response.sendRedirect("calcpage");
		}
	}
		
	
	

