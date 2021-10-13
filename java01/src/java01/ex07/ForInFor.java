package java01.ex07;

public class ForInFor {

	public static void main(String[] args) {
		//for문 중첩
		//바깥쪽 for
		for(int i = 0; i < 3; i++) {
			System.out.println("------------");
			
			//안쪽 for
			for(int j = 0; j < 3; j++) {
				System.out.println("[" + i + "," + j + "]");
				//안쪽 for문을 만족하면 바깥쪽 for문으로 돌아간다.
			}
			System.out.println('\n');
		}
	}

}
