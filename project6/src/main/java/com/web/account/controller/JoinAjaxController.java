package com.web.account.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.web.account.model.*;

@WebServlet("/account/ajax/join")
public class JoinAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
							//요청 -> 뭐를? 유저네임을 -> 서버로 슝
		String username = request.getParameter("username");
		
		JoinDTO dto = new JoinDTO(username, null);
		JoinService service = new JoinService(dto);
		
		//데이터를 주고 받기 위한 JSON 객체
		JSONObject json = new JSONObject();
		if(service.isExisted()) { //is는 참, 거짓을 반환
			response.setStatus(400); //응답한다. 에러코드 400을 (Status는 개발자모드로 확인한다.)
		} else {
			json.put("msg", "사용 가능한 아이디 입니다.");
			response.setStatus(200);
		}
		
		response.setContentType("application/json; charset=utf-8");
			//응답한다. -> utf-8 쓸거니까 이걸로 응답해줘
		PrintWriter out = response.getWriter();
		 //텍스트 출력 , 작성자를 응답 out에 담기
		out.print(json.toJSONString());
		out.flush();
		//출력 스트림을 비우고 버퍼 된 출력 바이트를 강제로 기록
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
