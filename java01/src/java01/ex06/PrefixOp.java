package java01.ex06;

public class PrefixOp {
			//증감연산자
	public static void main(String[] args) {

		int i1 = 7;
		
		System.out.println(++i1); //8
		System.out.println(++i1); //9
		System.out.println(i1); //9
		System.out.println("------------------");
		System.out.println(i1++);//9
		System.out.println(i1++);//10
		System.out.println(i1);//11
		System.out.println("------------------");
		System.out.println(--i1); //10
		System.out.println(--i1); //9
		System.out.println(i1); //9
		System.out.println("------------------");
		System.out.println(i1--);//9
		System.out.println(i1--);//8
		System.out.println(i1);//7
	}

}
