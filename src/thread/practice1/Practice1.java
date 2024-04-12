package thread.practice1;
import java.util.LinkedList;
import java.util.Queue;
public class Practice1 {
    public static void main(String args[]) {
        Queue<Integer> que = new LinkedList<Integer>();
        Thread proTh = new Producer(que);
        Thread conTh1 = new Consumer(que,"김민호");
        Thread conTh2 = new Consumer(que,"황정안");
        Thread conTh3 = new Consumer(que,"구준모");

        // 김민호 우선순위 10
        conTh1.setPriority(Thread.MAX_PRIORITY);

        // 스레드 시작
        proTh.start();
        conTh1.start();
        conTh2.start();
        conTh3.start();

        try {
            // 3초 기다림
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 모든 스레드 중단
        proTh.interrupt();
        conTh1.interrupt();
        conTh2.interrupt();
        conTh3.interrupt();
    }

}

class Consumer extends Thread{
    Queue<Integer> market;
    String name;

    public Consumer(Queue<Integer> market, String consumerName){
        this.market = market;
        this.name = consumerName;
    }

    public void run(){
        int item; // 상품
        int totalItem = 0; // 내가 소비한 총 상품 개수

        while(!Thread.currentThread().isInterrupted()) {
            synchronized(market){
                if(market.peek() == null) {
                // peek(): 맨 첫번쨰의 값을 반환, 비어있으면 null반환
                // element(): 큐의 맨 앞의 값 반환, 비어있으면 exception 발생
                    try {
                        System.out.println(name + " 대기");
                        market.wait(); // 대기
                    } catch (InterruptedException e){
                        System.out.println(name+" 총 소비 개수 : " + totalItem);
                        Thread.currentThread().interrupt();
                    }
                }
                else {
                    item = market.poll();
                    // poll(): 큐의 첫번째 요소를 삭제하고, 반환한다.
                    // remove:() 큐의 첫번째 요소를 삭제한다.
                    // clear(): 큐를 그냥 비운다.
                    System.out.println(name + ": " + item +"소비");
                    totalItem++;
                }
            }
        }
    }
}

class Producer extends Thread{
    Queue<Integer> market;
    int itemNum = 0;
    public Producer(Queue<Integer> market){
        this.market = market;
    }

    public void run(){
        while(!Thread.interrupted()){
            putItem(produceItem());
        }
    }

    private int produceItem(){
        itemNum++;
        return itemNum;
    }

    private void putItem(int itemNum){
        synchronized (market){
            market.offer(itemNum);
            // offer(): 큐 맨 뒤에 값 삽입, 추가 성공 시 true, 실패시 false
            // add(): 큐 맨 뒤에 값 삽입, 추가 성공 시 true. 실패시 exception발생
            System.out.println("생산: "+itemNum);
            market.notify();
        }
        try {
            Thread.sleep((int)(Math.random() * 10));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 인터럽트 상태 다시 설정
        }
    }
}

