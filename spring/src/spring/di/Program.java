package spring.di;

import java.util.ArrayList;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
	
		/*스프링에게 지시하는 방법으로 코드를 변경
		//인터페이스부모		   데이터 구현 객체
		Exam exam = new NewleckExam(); //부품
		//ExamConsole console = new InlineExamConsole(exam); //DI, 결합
		ExamConsole console = new GridExamConsole(exam);
		
		console.setExam(exam);
		*/
		
		//모든 구성요소의 제어 작업을 담당한다. : XML을 쓸것이다.
		//ApplicationContext context =
				//new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		//모든 구성요소의 제어 작업을 담당한다. : 어노테이션을 쓸것이다.
		ApplicationContext context =
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);
		
		//Exam exam = context.getBean(Exam.class);
		//System.out.println(exam.toString());
		
		ExamConsole console = (ExamConsole) context.getBean("console");
		//ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
		
		//List<Exam> exams = (List<Exam>)context.getBean("exams");//new ArrayList<>();
		//exams.add(new NewlecExam(1,1,1,1));
		
		//for(Exam e : exams)
			//System.out.println(e);
		
	}

}
