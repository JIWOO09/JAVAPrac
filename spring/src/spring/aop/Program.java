package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.aop.framework.AopContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;
import spring.di.NewlecDIConfig;

public class Program {

	public static void main(String[] args) {
		
		
		//��� ��������� ���� �۾��� ����Ѵ�. : XML�� �����̴�.
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring/aop/setting.xml");
				
				Exam exam = (Exam) context.getBean("exam");
					
				System.out.printf("total is %d\n", ((Exam) exam).total());		
				System.out.printf("avg is %f\n", ((Exam) exam).avg());		

		
				/*(Exam proxy = (Exam) context.getBean("proxy");
				
				System.out.printf("total is %d\n", ((Exam) proxy).total());		
				System.out.printf("avg is %f\n", ((Exam) proxy).avg());		
				 */
				//��� ��������� ���� �۾��� ����Ѵ�. : ������̼��� �����̴�.
		//ApplicationContext context =
				//new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				
		//Exam exam = new NewlecExam(1,1,1,1);
		
	
		//����� ��ɰ� ���� �����ϱ� 
//		Object proxy = Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), 
//									new Class[] {Exam.class}, 
//									new InvocationHandler() {
//										
//										@Override
//										public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//											
//											long start = System.currentTimeMillis();
//											
//											//��� ȣ��
//											Object result = method.invoke(exam, args);
//											
//											long end = System.currentTimeMillis();
//											
//											String messege = (end - start) + "ms �ð��� �ҿ� �ƽ��ϴ�.";
//											System.out.println(messege);
//											return result;
//										}
//									} 
//								);
//		
		
	}

}
