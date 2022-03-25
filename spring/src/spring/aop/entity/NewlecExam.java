package spring.aop.entity;


public class NewlecExam implements Exam {

	private int kor;
	private int eng;
	private int math;
	private int com;
	
	public NewlecExam() {
	}
	
	public NewlecExam(int kor, int eng, int math, int com) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
	}


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
		//시작하는 시간 구하기
		//곁다리 업무
		//long start = System.currentTimeMillis();
		
		//사용자에 의해 만들어진
		int result = kor + eng + math + com;
		
		//일부러 시간 늘리기
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//끝나는 시간 구하기
		//long end = System.currentTimeMillis();
		
		//String messege = (end - start) + "ms 시간이 소요 됐습니다.";
		//System.out.println(messege);
	
		return result;
	}

	@Override
	public float avg() {
		float result = total() / 4.0f; //소수점 반환
		return result;
	}

	@Override
	public String toString() {
		return "NewleckExam [kor=" + kor + ", eng=" + eng + ", math=" + math + ", com=" + com + "]";
	}
	
	

}
