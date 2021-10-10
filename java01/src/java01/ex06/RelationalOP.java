package java01.ex06;

public class RelationalOP {
			//관계연산자
	public static void main(String[] args) {
	
		System.out.println("3 >= 2 :" + (3 >= 2));
		System.out.println("3 <= 2 :" + (3 <= 2));
		System.out.println("7.0 == 7 :" + (7.0 == 7));
						//출력값이 true인 이유는 형변환 때문에 > 비교를 해야하면 타입이 일단 같아야한다. > int형으로 비교됨
		System.out.println("7.0 != 7 :" + (7.0 != 7));
						// 둘다 다르니? > 같으니까 거짓
	}

}
