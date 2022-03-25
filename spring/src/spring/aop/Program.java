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
		
		
		//모든 구성요소의 제어 작업을 담당한다. : XML을 쓸것이다.
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring/aop/setting.xml");
				
				Exam exam = (Exam) context.getBean("exam");
					
				System.out.printf("total is %d\n", ((Exam) exam).total());		
				System.out.printf("avg is %f\n", ((Exam) exam).avg());		

		
				/*(Exam proxy = (Exam) context.getBean("proxy");
				
				System.out.printf("total is %d\n", ((Exam) proxy).total());		
				System.out.printf("avg is %f\n", ((Exam) proxy).avg());		
				 */
				//모든 구성요소의 제어 작업을 담당한다. : 어노테이션을 쓸것이다.
		//ApplicationContext context =
				//new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				
		//Exam exam = new NewlecExam(1,1,1,1);
		
	
		//공통된 기능과 로직 연결하기 
//		Object proxy = Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), 
//									new Class[] {Exam.class}, 
//									new InvocationHandler() {
//										
//										@Override
//										public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//											
//											long start = System.currentTimeMillis();
//											
//											//기능 호출
//											Object result = method.invoke(exam, args);
//											
//											long end = System.currentTimeMillis();
//											
//											String messege = (end - start) + "ms 시간이 소요 됐습니다.";
//											System.out.println(messege);
//											return result;
//										}
//									} 
//								);
//		
		
	}

}
