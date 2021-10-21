package java01.ex08;

public class Method {

	public static void main(String[] args) {

		int result;
		result = adder(4,5);
		System.out.println("adder 메소드 호출의 값 : " + result);
		System.out.println("square 메소드 호출의 값 : " + square(4.0));
		
		divide(8, 4);
		
	}

	public static int adder (int num1, int num2) {
		int addResult = num1 + num2;
		return addResult;
		//메소드 호출문을 대체 하여 결과값 반환한다.
	}
	
	public static double square (double num) {
		return num * num;
	}
	
	public static void divide(int num3, int num4) {
		if(num3 == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
			return; //값의 반환 없이 메소드만 종료한다 라는 의미
		}
		System.out.println("나눗셈 결과 : " + (num3 / num4));
	}
	
}
