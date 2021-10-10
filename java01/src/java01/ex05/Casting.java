package java01.ex05;

public class Casting {

	public static void main(String[] args) {

		double pi = 3.1415;
		int i1 = (int)pi;
		//double형을 int형으로 형변환
		
		System.out.println(i1);
		
		long l1 = 300_000_000L;
		int num1 =(int)l1;
		System.out.println(num1);
		//long형을 int형으로 변환
		
		long l2 = 3_000_000_000L;
		int num2 =(int)l2;
		System.out.println(num2);
		//int형 > -2_147_483_648에서 2_147_483_647 이하의 숫자를 쓸 수 있다. 오버플로우 Overflow
	}

}
