package com.cls.diagram2;


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

class GradeLevel {
	// 성적 등급 : 성적의 등급을 구하기 위한 객체
	private Grade grade;
	
	public String level() {
		return "";
	}
	public void setGrades(Grade grade) {
		// 성적 정보를 멤버 변수에 저장
		this.grade = grade;
	}
}


public class AssociationClass {
	
	// 클래스 다이어그램 연관관계 샘플용.
			public static void main(String[] args) {
				Grade g1 = new Grade("국어", 78);
				
				GradeLevel gc = new GradeLevel();
				gc.setGrades(g1);
				
				System.out.println(gc.level());
			}

}
