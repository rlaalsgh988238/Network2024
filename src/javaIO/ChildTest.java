package javaIO;

class Parent2{
    int i=7;
    public int get(){
        return i;
    }
}
class Child2 extends Parent2{
    int i =5;
    public int get(){
        return i;
    }
}
public class ChildTest {
    public static void print(Parent2 p) {
        System.out.println(p.i);
        System.out.println(p.get());
    }

    public static void main(String[] args) {
        Parent2 p = new Parent2();
        System.out.println("1번");
        System.out.println(p.i); // 7
        System.out.println(p.get()); // 7

        Child2 c = new Child2();
        System.out.println("2번");
        System.out.println(c.i); // 5
        System.out.println(c.get()); // 5

        Parent2 p2 = new Child2();
        // new로 인해서 Child2는 힙에 올라가고 이를 참조하는 변수 형식은 Parent2임
        // 참조변수가 Parent2면 필드는 Parent2를 사용. 오버라이딩 된 경우는 부모 메소드의 코드는 사라지고 자식 메소드의 코드만 남음
        System.out.println("3번");
        System.out.println(p2.i); // 7 부모의 필드값
        System.out.println(p2.get()); // 5 부모의 메소드를 오버라이딩한 자식의 메소드

        System.out.println("4번");
        print(c); //  7  5
        print(p2);
    }
}
