package gugudan;


public class GugudanArray {
	public static void main(String[] args) {
		//배열로 구구단
		int[] result = new int[9];
		//9개의 데이터를 result 변수에 저장할 수 있는 배열
		for(int i = 0; i < result.length; i++) {
							//9개의 길이 만큼 반복
			result[i] = 2 * (i + 1);
			//0부터 시작이기 때문에 0 + 1 연산식 만들어서 2단 출력
		}
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		int[] result3 = new int[9];
		for(int i = 0; i < result3.length; i++) {
			result3[i] = 3 * (i + 1);
		}
		for(int i = 0; i < result3.length; i++) {
			System.out.println(result3[i]);
		}
		int[] result4 = new int[9];
		for(int i = 0; i < result4.length; i++) {
			result4[i] = 4 * (i + 1);
		}
		for(int i = 0; i < result4.length; i++) {
			System.out.println(result4[i]);
		}
	}
}	