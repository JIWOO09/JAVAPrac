package com.cls.diagram3;

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
	
	public double add(List<Grade> grades) {
		// grades에 저장된 성적의 총합을 구하여 반환
		return 0;
	}
	
	public double avg(List<Grade> grades) {
		// grades에 저장된 성적의 평균을 구하여 반환
		return 0;
	}
	
}

public class DependencyClass {
	//클래스다이어그램 샘플용 코드
	public static void main(String[] args) {
		List<Grade> grades = new ArrayList<Grade>();
		Grade g1 = new Grade();
		Grade g2 = new Grade();
		g1.setTitle("국어"); g1.setGrade(78);
		g2.setTitle("영어"); g2.setGrade(88);
		grades.add(g1);	grades.add(g2);
		
		GradeCalc gc = new GradeCalc();
		System.out.println(gc.add(grades));
		System.out.println(gc.avg(grades));
	}
	
}	