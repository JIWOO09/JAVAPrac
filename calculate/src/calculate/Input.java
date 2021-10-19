package calculate;

import java.util.Scanner;

public class Input {
	static int getFirstValue(Scanner scanner) {
		int first;
		System.out.print("첫번째 값 입력 : ");
		first = scanner.nextInt();
		return first;
	}
	
	static String getSymbol(Scanner scanner) {
		String symbol;
		System.out.print("기호 입력 : ");
		symbol = scanner.next();
		return symbol;
	}	
	
	static int getSecondValue(Scanner scanner) {
		int second;
		System.out.print("두번째 값 입력 : ");
		second = scanner.nextInt();
		return second;
	}
	
}
