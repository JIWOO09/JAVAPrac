package java01.ex06;

public class ComAssignmentOper {
		//복합 대입 연산자
	public static void main(String[] args) {
		 
		short s = 10;
		s = (short)(s + 77L);
		int rate = 3;
		rate = (int)(rate * 3.5);
		System.out.println(s);
		System.out.println(rate);
	
// 		아래 코드도 가능 하지만 웬만하면 위처럼 자세하게			
//		short s = 10;
//		s += 77L;
//		int rate = 3;
//		rate *= 3.5;
//		System.out.println(s);
//		System.out.println(rate);
	}

}
