package thread.thread2;

/**
 * 플래그를 통해서 스레드를 종료하는 방식
 */

public class StopThread1 {
    //stop()은 사용하지 않는게 좋다
    //플래그, interrupt를 사용하자
    public static void main(String[] args) {

        RunningThread t = new RunningThread();
        // 화이트박스로 생성

        t.start();
        // 스레드 실행

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        t.stopThread();
        // 플래그 true로 만들어서 종료
    }
}

class RunningThread extends Thread{
    boolean stopFlag = false;
    // 스톱 플래그
    public void run(){
        while (!stopFlag){
            System.out.println("스레드 작동 중");
            try{
                Thread.sleep(200);
            } catch (InterruptedException e){
                System.out.println("스레드 인터럽트");
                e.printStackTrace();
            }
        }
        System.out.println("스레드 종료");
    }

    public void stopThread(){
        this.stopFlag = true;
        // 이 메서드 호출 시 플래그 true로 만들어서 종료
    }
}
