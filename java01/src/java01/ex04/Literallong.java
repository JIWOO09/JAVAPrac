package java01.ex04;

public class Literallong {

	public static void main(String[] args) {

		/*
		int i1 = 12_345_678_912;
		int i2 = 12_345_678_912;
		길이가 길어서 에러
		*/
		
		long l1 = 12_345_678_912L;
		long l2 = 12_345_678_912L;
		//20억 이상이면 long 끝에 L붙이기
		System.out.println(l1 + l2);
		
		
	}

}
