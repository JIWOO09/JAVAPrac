package com.cls.diagram4;

import java.util.ArrayList;
import java.util.List;

//클래스다이어그램 샘플용 코드
class Grade {
	private String title;
	private double grade;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
}

class GradeCalc {
	private List<Grade> grades = new ArrayList<Grade>();
	
	public GradeCalc(String title, double grade) {
		this.insertGrade(title, grade);
	}
	
	public void insertGrade(String title, double grade) {
		Grade g = new Grade();
		g.setTitle(title);
		g.setGrade(grade);
		
		this.grades.add(g);
	}
	
	public double add() {
		// grades에 저장된 성적의 총합을 구하여 반환
		return 0;
	}
	public double avg() {
		// grades에 저장된 성적의 평균을 구하여 반환
		return 0;
	}
	public String getGrades() {
		// 모든 성적 정보를 문자열로 만들어 반환
		return "";
	}
	public String getTitles() {
		// 모든 성적 정보의 title 을 문자열로 만들어 반환
		return "";
	}
	public double getGrade(String title) {
		// 성적 정보에서 title에 해당하는 성적 정보의 성적을 반환
		return 0;
	}
}

public class CompositionClass {
	//클래스다이어그램 샘플용 코드
	public static void main(String[] args) {
		GradeCalc gc = new GradeCalc("국어", 78);
		gc.insertGrade("영어", 88);
		System.out.println(gc.add());
		System.out.println(gc.avg());
	}

}