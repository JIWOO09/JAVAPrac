package java01.ex07;

public class Break {

	public static void main(String[] args) {

		int num = 1;
		boolean search = false;
		
		//5의 배수이자 7의 배수 찾기 -> 5단, 7단 둘다 같은 수 나오는
		while(num < 100) {
			if(((num % 5) == 0) && ((num % 7) == 0)) {
				search = true;
				break; //찾는 정수가 나오면 빠져나간다.
			}
			num++; //if문 밖 while문 안
		}
		//while문 밖
		if(search) {
			System.out.println("찾는 정수 : " + num);
		} else {
			System.out.println("찾는 정수가 아닙니다.");
		}
	}

}
