package java01.ex04;

public class Constants {

	public static void main(String[] args) {

		final int MAX_SIZE = 100;
		final char CONST_CHAR = '상';
		//상수화 > 변경 불가능

		final int CONST_ASSIGNED;
		//*선언만 하고 값은 할당하지 않은 상태
		
		CONST_ASSIGNED = 12; 
		//할당하지 않았던 상수의 값 할당 할 수 있는 기회를 1번 준다.
		
		System.out.println("상수1 : " + MAX_SIZE);
		System.out.println("상수2 : " + CONST_CHAR);
		System.out.println("상수3 : " + CONST_ASSIGNED);
	}

}
