package java01.ex06;

public class Operater {

	public static void main(String[] args) {

		int i1 = 7;
		int i2 = 3;
		
		System.out.println("i1 + i2 = " + i1 + i2);
									//괄호가 없으면 문자형으로 결합 > -는 괄호가 없으면 에러
		System.out.println("i1 + i2 = " + (i1 + i2));
		System.out.println("i1 - i2 = " + (i1 - i2));
		System.out.println("i1 * i2 = " + (i1 * i2));
		System.out.println("i1 / i2 = " + (i1 / i2)); // 몫
		System.out.println("i1 % i2 = " + (i1 % i2)); //나머지

		
		System.out.println("i1 / i2 = " + (7.0 % 3.0));
								//실수형 나눗셈
	
	 
	}

}
