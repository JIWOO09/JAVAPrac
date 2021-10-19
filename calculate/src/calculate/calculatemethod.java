package calculate;

import java.util.Scanner;

//메소드 분리하기
public class calculatemethod {
	static Scanner scanner = new Scanner(System.in);
	private static String symbol;
	//정적멤버 선언 방법 > 메소드 앞에 static을 앞에 붙이면 된다.
	//클래스만으로 메소드호출
	
	static int getFirstValue(Scanner scanner) {
		int first;
		System.out.print("첫번째 값 입력 : ");
		first = scanner.nextInt();
		return first;
	}
	
	static String getSymbol(Scanner scanner) {
		String symbol;
		System.out.println("기호 입력 : ");
		symbol = scanner.next();
		return symbol;
	}	
	
	static int getSecondValue(Scanner scanner) {
		int second;
		System.out.print("두번째 값 입력 : ");
		second = scanner.nextInt();
		return second;
	}
	
	
	
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
		
		int first = getFirstValue(scanner);
		int result = first;
		
		while(true) {
			String symbol = getSymbol(scanner);
			//종료
			if(symbol.equals("quit")) {
				break;
			}
			
			int second = getSecondValue(scanner);
			result = calculatemethod(result, symbol, second);
		}					
	}
}

