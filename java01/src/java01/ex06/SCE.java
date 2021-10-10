package java01.ex06;

public class SCE {
			//논리연산자 시 주의해야할
	public static void main(String[] args) {
		
		int i1 = 0;
		int i2 = 0;
		boolean result;
		
		//result = ((i1 += 10) < 0) && result = ((i2 += 10) > 0)
		//식이 많아지면 생략되어버리는 식이 생기니 식 나눠서
		result = ((i1 += 10) < 0);
		result = ((i2 += 10) > 0);
		System.out.println("result : " + result);
		System.out.println("i1 : " + i1);
		System.out.println("i2 : " + i2);
		
	}

}
