package java01.ex04;

public class Literal {

	public static void main(String[] args) {
		
		int num1 = 123; //10진수
		int num2 = 0123; //0을 붙이면 8진수
		int num3 = 0x0123; //0x를 붙이면 16진수

		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		//코드상에서 8진수 16진수지만 출력은 10진수로 표현되어 출력 된다.
		
		System.out.println("11 + 22 + 33 = " + (11 + 22 + 33));
		System.out.println("011 + 022 + 033 = " + (011 + 022 + 033));
		System.out.println("0x11 + 0x22 + 0x33 = " + (0x11 + 0x22 + 0x33));
	}

}