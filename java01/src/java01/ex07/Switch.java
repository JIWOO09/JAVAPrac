package java01.ex07;

public class Switch {

	public static void main(String[] args) {

		//책의 목차 같은? 원하는 목차를 찾아가는거랑 비슷하다.
		int i = 4;
		
		switch(4) {
		case 1:
		case 2:
		case 3:
			System.out.println("case 1, 2, 3");
			break;
		default :
		System.out.println("other case");
			
		}
	}

}
