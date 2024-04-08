package thread.thread2;

/**
 * 인터럽트를 통해서 스레드를 종료하는 방식
 */
public class StopThread2 {
    public static void main(String[] args) {
        RunningThread2 t = new RunningThread2();
        t.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        t.interrupt();
        // 스레드 인터럽트
    }
}

class RunningThread2 extends Thread{
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            // !있는 것 주의할 것.
            System.out.println("스레드 작동 중");
        }
        System.out.println("스레드 종료");
    }
}
