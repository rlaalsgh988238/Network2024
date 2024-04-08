package thread.thread1;

/**
  WhiteBox식 -> Thread 상속해서 이용하는 방법
**/
public class WhiteBox {
    public static void main(String[] args) {
        // 이렇게 하면 FirstThread에 자체적으로 추가한 메소드 사용 가능
        FirstThread t = new FirstThread();
        t.start();
        t.method1();
    }
}

class FirstThread extends Thread{
    // 상속을 통한 재사용
    @Override
    public void run() {
        System.out.println("Thread 클래스 상속");
    }

    public void method1(){
        // 화이트박스의 추가적인 메소드
        System.out.println("method1 사용");
    }
}
