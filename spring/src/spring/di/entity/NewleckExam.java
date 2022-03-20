package spring.di.entity;

public class NewleckExam implements Exam {

	private int kor;
	private int eng;
	private int math;
	private int com;
	
	
	
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {
		return kor + eng + math + com;
	}

	@Override
	public float avg() {
		return total() / 4.0f; //소수점 반환
	}

}
