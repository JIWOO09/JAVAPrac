package gugudan;


public class GugudanMethod {
		//구현하고 싶은 단의 숫자를 (int num에)입력하면 배열에 담아 반환하는 메서드
	
	public static int[] calaulate(int num) {
		int[] result = new int[9];
		for(int i = 0; i < result.length; i++) {
			result[i] = num * (i + 1);
		}
		return result;
	}
	
	//프린트 코드 메소드 만들기 (반환 값이 없기 때문에 void)
	public static void print(int[] result) {
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}		
			
//	public static void main(String[] args) {
//		
//		for(int i = 2; i < 10; i++) {
//			int[] result =calaulate(i);
//			print(result);
//		}
//		
//		//아래 코드가 반복되니 반복문(위코드)으로 변경
////		int[] result =calaulate(2);
////		print(result); // 프린트 코드도 메소드로 
////		
////		int[] result3 =calaulate(3);
////		print(result3);
////		
////		int[] result4 =calaulate(4);
////		print(result4);
//		}
	}
	