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
		//�����ϴ� �ð� ���ϱ�
		//��ٸ� ����
		//long start = System.currentTimeMillis();
		
		//����ڿ� ���� �������
		int result = kor + eng + math + com;
		
		//�Ϻη� �ð� �ø���
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//������ �ð� ���ϱ�
		//long end = System.currentTimeMillis();
		
		//String messege = (end - start) + "ms �ð��� �ҿ� �ƽ��ϴ�.";
		//System.out.println(messege);
	
		return result;
	}

	@Override
	public float avg() {
		float result = total() / 4.0f; //�Ҽ��� ��ȯ
		return result;
	}

	@Override
	public String toString() {
		return "NewleckExam [kor=" + kor + ", eng=" + eng + ", math=" + math + ", com=" + com + "]";
	}
	
	

}
