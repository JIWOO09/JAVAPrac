package com.jiwoo.web.add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet{
//
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) 
//					throws ServletException, IOException {
//	
//		//조건 : get인지 아닌지 반환하는 메소드
//		if(request.getMethod().equals("GET")) {
//				System.out.println("GET 요청이 왔습니다");
//				
//			}else if(request.getMethod().equals("POST")) {
//				System.out.println("POST 요청이 왔습니다");
//	
//			}	
//	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {

		String exp = "0"; //쿠키값 없는 경우 기본값 0
		//서버로 쿠키 읽어오기 : 쿠키가 여러개니까 배열로 
		Cookie[] cookies = request.getCookies();
		
		//널이 아닌 조건
		if(cookies != null)
			for(Cookie c : cookies) 
				if(c.getName().equals("exp")) {//쿠키이름검색
					exp = c.getValue(); //찾는 이름이라면 변수에 담자
					break; //찾았으면 그만
				}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//문자열 출력
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<Style>"); 
		out.write(	"input{"); 
		out.write(	" width : 50px;"); 
		out.write(	" height : 50px;"); 
		out.write(	"}"); 
		out.write(	".output{"); 
		out.write(	" height : 50px;"); 
		out.write(	" background : #e9e9e9;"); 
		out.write(	" font-size : 24px;"); 
		out.write(	" font-weight : bold;"); 
		out.write(	" text-align : right;"); 
		out.write(	" padding : 0px 5px;"); 
		out.write(	"}"); 
		out.write("</Style>");
		out.write("</head>");
	
		out.write("<body>");
		out.write(	"<div>");                         
		out.write(		"<form method =\"post\">");
		out.write(			"<table>");
		out.write(				"<tr>");								//문자열
		out.printf(					"<td class = \"output\" colspan =\"4\">%s</td>", exp);
		out.write(				"</tr>");
					
		out.write(				"<tr>");
		out.write(					"<td><input type=\"submit\" name=\"operator\" value=\"CE\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"operator\" value=\"C\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"operator\" value=\"BS\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"operator\" value=\"/\"/></td>");
		out.write(				"</tr>");
					
		out.write(				"<tr>");
		out.write(					"<td><input type=\"submit\" name=\"value\" value=\"7\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"value\" value=\"8\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"value\" value=\"9\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"operator\" value=\"*\"/></td>");
		out.write(				"</tr>");
					
		out.write(				"<tr>");
		out.write(					"<td><input type=\"submit\" name=\"value\" value=\"4\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"value\" value=\"5\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"value\" value=\"6\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"operator\" value=\"-\"/></td>");
		out.write(				"</tr>");                            
					
		out.write(				"<tr>");
		out.write(					"<td><input type=\"submit\" name=\"value\" value=\"1\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"value\" value=\"2\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"value\" value=\"3\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"operator\" value=\"+\"/></td>");
		out.write(				"</tr>");
					
		out.write(				"<tr>");
		out.write(					"<td></td>");
		out.write(					"<td><input type=\"submit\" name=\"value\" value=\"0\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"dot\" value=\".\"/></td>");
		out.write(					"<td><input type=\"submit\" name=\"operator\" value=\"=\"/></td>");
		out.write(				"</tr>");
		out.write(			"</table>");
		out.write(		"</form>");
		out.write(	"</div>");
		out.write("</body>");
		out.write("</html>");
	}	
		
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
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
				
				
				expCookie.setPath("calculator");//해당 url만 쿠키 전달 path는 하나만 설정가능
				
				response.addCookie(expCookie);
			
				//페이지 전환 
				response.sendRedirect("calculator");
				}
}

			



