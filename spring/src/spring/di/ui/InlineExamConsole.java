package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {

	public InlineExamConsole() {
	}
	private Exam exam;
	
	//�����ڸ� ���ؼ� �����޴�
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("total : %d, avg : %f\n", exam.total(), exam.avg());
		
	}

	@Autowired
	@Qualifier("exam1")
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}

}
