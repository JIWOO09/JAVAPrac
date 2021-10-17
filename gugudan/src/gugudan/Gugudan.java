package gugudan;

import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {
//		//2단
//		//무식하게 해보기 , 코드작성 시 단축키 활용하기
//		//라인 복사 ctrl + alt + 방향키
//		System.out.println(2 * 1);
//		System.out.println(2 * 2);
//		System.out.println(2 * 3);
//		System.out.println(2 * 4);
//		System.out.println(2 * 5);
//		System.out.println(2 * 6);
//		System.out.println(2 * 7);
//		System.out.println(2 * 8);
//		System.out.println(2 * 9);
//		
//		System.out.println(""); //빈칸
//		System.out.println("3단 -------------");
//		//3단
//		//라인 이동 > alt + 방향키
//		System.out.println(3 * 1);
//		System.out.println(3 * 2);
//		System.out.println(3 * 3);
//		System.out.println(3 * 4);
//		System.out.println(3 * 5);
//		System.out.println(3 * 6);
//		System.out.println(3 * 7);
//		System.out.println(3 * 8);
//		System.out.println(3 * 9);
//		
//		System.out.println("");
//		System.out.println("4단 -------------");
//		//변수 사용하여 4단 출력
//		//정수 데이터 타입의 int 선언
//		//result라는 변수명에 값을 저장
//		//값이 저장된 변수를 출력하면 > 값이 출력
//		int result = 4 * 1;
//		System.out.println(result);
//		int result2 = 4 * 2;
//		System.out.println(result2);
//		int result3 = 4 * 3;
//		System.out.println(result3);
//		int result4 = 4 * 4;
//		System.out.println(result4);
//		int result5 = 4 * 5;
//		System.out.println(result5);
//		int result6 = 4 * 6;
//		System.out.println(result6);
//		int result7 = 4 * 7;
//		System.out.println(result7);
//		int result8 = 4 * 8;
//		System.out.println(result8);
//		int result9 = 4 * 19;
//		System.out.println(result9);
		
//		System.out.println("");
//		System.out.println("5단 -------------");
//		//값을 입력 받아서 구구단 출력
//		//스캐너 기능을 활용하기 
//		
//		System.out.print("출력 할 단의 숫자 입력하세요. : ");
//		Scanner scanner = new Scanner(System.in);
//							        //키보드와 연결된 자바의 표준 입력 스트림
//		int number = scanner.nextInt(); 
//					//정수형을 입력 받을 때 사용
//		//입력 받은 값 number에 저장
//		System.out.println(number * 1);
//		System.out.println(number * 2);
//		System.out.println(number * 3);
//		System.out.println(number * 4);
//		System.out.println(number * 5);
//		System.out.println(number * 6);
//		System.out.println(number * 7);
//		System.out.println(number * 8);
//		System.out.println(number * 9);
		
//		System.out.println("");
//		System.out.println("6단 -------------");
//		//반복문 > 코드의 길이가 짧아진다.
//		//while
//		
//		int i = 1; //시작점
//		while (i < 10) { 
//			//10보다 작을 때 까지 반복 설정
//			System.out.println(6 * i);
//			//1출력 후 
//			//i에 1씩 더하기 > 2, 3, 4, ....
//			i++; //i = i + 1; 
//		}
//		
//		System.out.println("");
//		System.out.println("7단 -------------");	
//		//for >while 문을 한줄로 줄임.
//		
//		//위 변수 i 가 있기 때문에 i 못씀
//		for(int j = 1; j < 10; j++) {
//			System.out.println(7 * j);
//			}
		
		
		System.out.println("8, 9단 -------------");
		//입력과 조건문 
		System.out.print("출력 할 단의 숫자 입력하세요. : ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt(); 
		System.out.println("사용자가 입력 한 값 : " + number);
		
		//2이상 9이하의 조건을 건다.
		if(number < 2) {
			System.out.println("값을 잘못 입력 했습니다. 2이상 입력");
		} else if (number > 9) {
			System.out.println("값을 잘못 입력 했습니다. 9이하 입력");
		} else {
			for(int i = 1; i < 10; i++) {
				System.out.println(number * i);
		}
		}
	}
}

