package java01.ex06;

public class LoiclaOP {
		//논리 연산자
	public static void main(String[] args) {

		int i1 = 11;
		int i2 = 22;
		boolean result;
		
		result = (1 < i1) && (i1 < 100);	
		System.out.println("1초과 100미만인가 ? " + result);
		// 둘다 참일 때
		
		result = ((i2 % 2) == 0 ) || ((i2 % 3) == 0);
		System.out.println("2 또는 3의 배수인가 ? " + result);
		// 둘중에 하나라도 참일 때  뒤에 질문은 거짓	
		
		result = !(i1 == 0);
		System.out.println("0인가 ? " + result);
		//참과 거짓을 반대로 출력
		
		result = !(i1 == 11);
		System.out.println("11인가 ? " + result);
		
	}

}
