package gugudan;


public class GugudanMain {
		public static void main(String[] args) {
			
	for(int i = 2; i < 10; i++) {
		int[] result = GugudanMethod.calaulate(i);
		GugudanMethod.print(result);
		//다른 클래스에 있는 메소드(클래스파일명 기재)를 메인클래스에 소환
		}
	}
}