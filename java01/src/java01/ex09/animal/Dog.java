package java01.ex09.animal;



public class Dog {
    public void welcom(java01.ex09.zoo.Cat c) {
    					//파일 이름명 그대로 점.으로 불러오기 
        c.makeSound();     // 호출 가능! 컴파일 성공!
       // c.makeHappy();     // 호출 불가! 컴파일 오류! -> default로 선언 되어있기 때문에
    }
}
