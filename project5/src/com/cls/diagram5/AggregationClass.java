package com.cls.diagram5;

import java.util.ArrayList;
import java.util.List;

//클래스다이어그램 샘플용 코드
class Grade {
	// 성적 : 특정 과목의 점수를 관리하기 위한 객체
	private String title;
	private double grade;
	
	public Grade(String title, double grade) {
		this.title = title;
		this.grade = grade;
	}
	
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

class GradeTable {
	// 성적표 : 성적을 성적표 형태로 구하기 위한 객체
	private List<Grade> grades;
	public GradeTable(List<Grade> grades) {
		this.grades = grades;
	}
	public void addGrade(Grade grade) {
		// 성적표에 추가할 성적 등록
		grades.add(grade);
	}
	public void totalGrade() {
	}
	
	public void avgGrade() {
	}
}


public class AggregationClass {
	//클래스다이어그램 샘플용 코드
		public static void main(String[] args) {
			List<Grade> grades = new ArrayList<Grade>();
			
			GradeTable gc = new GradeTable(grades);
			gc.addGrade(new Grade("국어", 78));
			gc.addGrade(new Grade("영어", 88));
		}

}