package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice  implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		long start = System.currentTimeMillis();

		Object result = invocation.proceed();
		
		long end = System.currentTimeMillis();
		
		String messege = (end - start) + "ms �ð��� �ҿ� �ƽ��ϴ�.";
		System.out.println(messege);
		return result;
	}

}
