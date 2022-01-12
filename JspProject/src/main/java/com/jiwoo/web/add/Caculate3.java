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
	
		
		//������ ��Ű �о���� : ��Ű�� �������ϱ� �迭�� 
		Cookie[] cookies = request.getCookies();
		
		//����� �Է�
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		String exp ="";
		//���� �ƴ� ����
		if(cookies != null)
			for(Cookie c : cookies) 
				if(c.getName().equals("exp")) {//��Ű�̸��˻�
					exp = c.getValue(); //ã�� �̸��̶�� ������ ����
					break; //ã������ �׸�
				}
		//null�� �ƴϰ� = �ΰ�� -> ��������ϱ�
		if(operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		//C�� ������ �� ������� �Ǹ鼭 ��Ű����	
		} else if(operator != null && operator.equals("C")) {
			 exp ="";
			 
			//= �ƴ� ���	
			}else {
		
				//�� ����
				exp += (value == null)?"" : value;
		
				//null�� �ƴ� �͸� ����
				exp += (operator == null)?"" : operator;
				exp += (dot == null)?"" : dot;
		
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		
		//C�� ������ ��쿡�� 
		if(operator != null && operator.equals("C"))
		expCookie.setMaxAge(0);//��Ű �ٷ� �Ҹ�
		
		response.addCookie(expCookie);
		//������ ��ȯ 
		response.sendRedirect("calcpage");
		}
	}
		
	
	

