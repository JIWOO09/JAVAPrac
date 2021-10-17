package calculate;

import java.util.Scanner;

public class calculate {

	public static void main(String[] args) {
		
		//단순 사칙연산
//		System.out.println("덧셈:" + (5 + 3));
//		System.out.println("뺄셈:" + (5 - 3));
//		System.out.println("곱셈:" + (5 * 3));
//		System.out.println("나누기 몫:" + (5 / 3));
//		System.out.println("나누기 나머지:" + (5 % 3));
//		
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("첫번째 값 입력 : ");
//		int first = scanner.nextInt();
//		
//		System.out.print("두번째 값 입력 : ");
//		int second = scanner.nextInt();
//		
//		System.out.println("두개의 값 덧셈 결과 : " + (first + second));
//		System.out.println("두개의 값 뻴셈 결과 : " + (first - second));
//		System.out.println("두개의 값 곱셈 결과 : " + (first * second));
//		System.out.println("두개의 값 나누기 몫 결과 : " + (first / second));
//		System.out.println("두개의 값 나누기 나머지 결과 : " + (first % second));
//	
		
		//두개의 값과 기호를 입력 받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 값 입력 : ");
		int first = scanner.nextInt();
		
		System.out.print("사칙 연산 기호 입력 : ");
		String symbol = scanner.next(); //문자 하나를 입력 받음
		//입력 받은 연산기호를 symbol이라는 변수에 담는다.
		
		System.out.print("두번째 값 입력 : ");
		int second = scanner.nextInt();
		
		
		
//		if("+".equals(symbol)) {
//			System.out.println("덧셈 값 :" + (first + second));
//		} else if ("-".equals(symbol)) {
//			System.out.println("뺄셈 값 :" + (first - second));
//		} else if ("*".equals(symbol)) {
//			System.out.println("곱셈 값 :" + (first * second));
//		} else if ("/".equals(symbol)) {
//			System.out.println("나누기 몫 값 :" + (first / second));
//		} else if ("%".equals(symbol)) {
//			System.out.println("나누기 나머지 값 :" + (first % second));
//		} else {
//			System.out.println("사칙 연산 기호가 아닙니다.");
//		}
		
		//스위치 문으로 응용하기
		switch (symbol) {
		case "+" :
			System.out.println("덧셈 값 :" + (first + second));
			break;
		case "-" :
			System.out.println("뺄셈 값 :" + (first - second));
			break;
		case "*" :
			System.out.println("곱셈 값 :" + (first * second));
			break;
		case "/" :
			System.out.println("나누기 몫 값 :" + (first / second));
			break;
		case "%" :
			System.out.println("나누기 나머지 값 :" + (first % second));
			break;
		default : System.out.println("사칙 연산 기호가 아닙니다.");
			break;
		}
	
	}

}
