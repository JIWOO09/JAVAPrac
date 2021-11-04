package com.cls.diagram1;

	//클래스다이어그램 샘플용 코드

public class DefaultDiagram {

	public int x1;
	int x2 = 10;
	protected String s1;
	private String s2 = "Diagram";
	
	public DefaultDiagram() {
		// 기본 생성자.
	}
	
	public DefaultDiagram(int x) {
		// 매개변수가 있는 생성자.
	}
	
	public void method1() {
		// 메서드.
	}
	
	void method2(int x) {
		// 메서드.
	}
	
	protected String method3() {
		return s1;
	}
	
	private String method4(String s) {
		return s2;
	}
	
}
