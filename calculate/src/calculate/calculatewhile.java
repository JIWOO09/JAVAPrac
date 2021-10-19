package calculate;

import java.util.Scanner;

public class calculatewhile {

	public static void main(String[] args) {
		
		
		//여러개의 값과 여러개의 기호를 입력 받는다.
		Scanner scanner = new Scanner(System.in);
		String symbol = "";
		int first, second;
		
		System.out.print("첫번째 값 입력 : ");
		first = scanner.nextInt();

		
		//어디 부분이 반복되는지 찾기 > 두번째 값, 기호
		while(true) {
			System.out.print("사칙 연산 기호 입력 : ");
			symbol = scanner.next(); //문자 하나를 입력 받음
			//입력 받은 연산기호를 symbol이라는 변수에 담는다.
			
			//종료
			if(symbol.equals("quit")) {
				break;
			}
			
			System.out.print("두번째 값 입력 : ");
			second = scanner.nextInt();
		
			if(symbol.equals("+")) {
				first = (first + second);
				System.out.println("덧셈 값 :" + first);
			} else if (symbol.equals("-")) {
				first = (first - second);
				System.out.println("뺄셈 값 :" + first);
			} else if (symbol.equals("*")) {
				first = (first * second);
				System.out.println("곱셈 값 :" + first);
			} else if (symbol.equals("/")) {
				first = (first / second);
				System.out.println("나누기 몫 값 :" +first);
			} else if (symbol.equals("%")) {
				first = (first % second);
				System.out.println("나누기 나머지 값 :" + first);
			} else {
				System.out.println("사칙 연산 기호가 아닙니다.");
				break;
			}
		}
		System.out.println("연산 결과: " + first);
	}
}

