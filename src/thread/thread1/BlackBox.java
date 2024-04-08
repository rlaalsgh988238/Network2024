package thread.thread1;

/**
 * BloackBOx ->  Runnable 인터페이스 구현하는 방법
 * 스레드의 생성자
 * Thread() -> 그냥 스레드
 * Thread(String name) -> 스레드에 이름
 * Thread(Runnable target) -> 블랙박스 기본 방식
 * Thread(Runnable target, string name) -> 이름 지정
 * Thread(ThreadGroup grOUP, Runnable target) -> 그룹과 인터페이스
 * Thread(ThreadGroup group, Runnable target, String name)
 * Thread(ThreadGroup group, Runnable target, String names long stackSize)
 * Thread(ThreadGroup groups, String name)
 *
 *
 */
public class BlackBox {
    public static void main(String[] args) {
        // 스레드 생성자에 runnable 인텋페이스를 인자로 생성한다.
        // 이렇게 사용하면 Thread의 퍼블릭 메소드밖에 사용할 수 없음
        Thread t = new Thread(new FirstThread2());
        t.start();
    }
}

class FirstThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable 인터페이스 구현");
    }
}
