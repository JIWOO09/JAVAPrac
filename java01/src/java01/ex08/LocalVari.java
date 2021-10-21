package java01.ex08;

public class LocalVari {

	public static void main(String[] args) {

		boolean ste = true;
		int num1 = 11;
		
		if(ste) {
			//int num1 = 22; 영역이 중복되기 때문에 에러 
			int num3 = 22;
			num1++;
			System.out.println(num1);
		}
		
	{
		int num2 =33;
		num2++;
		System.out.println(num2);
	}
	
		//System.out.println(num2); 영역을 벗어 났기 때문에 에러
	}

}
