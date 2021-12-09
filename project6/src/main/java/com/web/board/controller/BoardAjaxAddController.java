package com.web.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet("/board/ajax/add")
public class BoardAjaxAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String val = request.getParameter("val");
		
		response.setContentType("application/json; charset=UTF-8");
		//response.setStatus(400); //HTTP Response 보낼 때 상태 코드를 설정하여 보내기 위해 사용
		PrintWriter out = response.getWriter();
		
		//데이터를 주고 받기 위한 JSON 객체
		JSONObject jsonObj = new JSONObject();
			//키와 값 요소 추가
		jsonObj.put("firstName", "Duke");
		jsonObj.put("lastName", "Java");
		jsonObj.put("age", "18");
		jsonObj.put("streetAddress", "100 Internet Dr");
		jsonObj.put("city", "JavaTown");
		jsonObj.put("state", "Ja");
		jsonObj.put("postalCode", "12345");
		
		//JOSN외의 다른 데이터를 넣기 위해 Array
		//폰넘버 넣기 위한 배열
		JSONArray jsonArr = new JSONArray();
		
		JSONObject obj1 = new JSONObject();
		obj1.put("Mobile", "111-111-1111");
		
		JSONObject obj2 = new JSONObject();
		obj2.put("Home", "222-222-2222");
		
		jsonArr.add(obj1);
		jsonArr.add(obj2);
		
		jsonObj.put("phoneNumbers", jsonArr);
		
		out.print(jsonObj.toJSONString());
		out.flush();
		
		//Stirng을 json형태로 변환
		//String json = "{\"result\" : \"데이터를 잘 받았습니다.\"}";
		//out.print(json);
		//out.flush();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
