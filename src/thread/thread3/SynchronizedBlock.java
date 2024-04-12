package thread.thread3;

import java.util.LinkedList;
import java.util.Queue;

/** practice가 훨씬 설명 잘 되어있음.
 * 생산자 소비자 패턴
 *
 * */
public class SynchronizedBlock {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        // LinkedList 생성자로 만들어야 함

        synchronized (queue){// queue 객체의 락을 검사한다
        // 임계영역: 여러개의 스레드가 동시에 접근할 수 없는 영역

        }
    }

}

class EtcThread extends Thread{
    String name;
    public EtcThread(String name){
        this.name = name;
    }
    public void run() {
    // 스레드가 종료될 때 까지 자신의 이름 출력
        while(!Thread.currentThread().isInterrupted()){
            printName();
        }
    }

    private void printName(){
        System.out.println(name+": 실행 중");
    }
}

class Selecter{
    public Selecter(EtcThread etcThread){

    }
}

