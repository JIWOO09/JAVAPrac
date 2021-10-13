package java01.ex07;

public class Continue {

	public static void main(String[] args) {

		int num = 0;
		int count = 0;
		
		while((num++) < 100) {
			if(((num % 5) !=0) || ((num %7) != 0)) 
				//5의 배수가 아닐때 참, 7의 배수가 아닐 때 참
				
				continue; //5, 7의 배수가 아니라면 건너뛰고 다시 조건식으로 돌아간다.
			
			count++;//5와 7의 배수일 때만 카운트 한다.
			System.out.println(num);//5와 7의 배수일 때만 실행한다.
		}
		System.out.println("count : " + count);
	}

}
