package java01.ex07;

public class WhileInFor {

	public static void main(String[] args) {
		
		//while문에 for문 중첩
		int i = 0;
		while (i < 10) {
			for(int j = 0; j < 10; j++)
			System.out.println(i + "x" + j + "=" + i * j);
			i++;
			
		}
	}

}
