package calculate;

import java.util.Scanner;

public class calculatclass {

	static int calculatemethod(int first, String symbol, int second) {
		
		int result = 0;
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
		}
		return first;
	}
		
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int first = Input.getFirstValue(scanner);
		int result = first;
		
		while(true) {
			String symbol = Input.getSymbol(scanner);
						//다른클래스(Input)의 메소드 호출하기
			//종료
			if(symbol.equals("quit")) {
				Output.print(result);
				break;
			}
			
			int second = Input.getSecondValue(scanner);
			result = calculatemethod(result, symbol, second);
		}					
	}
}

