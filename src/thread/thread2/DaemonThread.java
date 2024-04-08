package thread.thread2;

/**
 * 데몬 스레드 예제
 * 낮은 우선순위를 가지고, 백그라운드를 위해 도입됐다.
 * 메인 스레드가 종료되면 강제적으로 모든 스레드가 종료된다.
 */
public class DaemonThread extends Thread{
    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(200);
                System.out.println("데몬 스레드 작동 중");
            } catch (InterruptedException e){
                e.printStackTrace();
                System.out.println("데몬 스레드 인터럽트");
            }
        }
        System.out.println("데몬 스레드 종료");
    }

    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();

        daemonThread.setDaemon(true);
        //데몬스레드 설정

        daemonThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("메인스레드 종료");
        //메인스레드 종료되면 바로 데몬스레드도 종료
    }
}

class GeneralThread extends Thread{

    @Override
    public void run(){

        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("일반 스레드 작동 중");
        }

    }

    public static void main(String[] args) {
        // 여기서 스레드 종료를 따로 안한다.
        GeneralThread generalThread = new GeneralThread();
        generalThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("메인 메서드 종료");
        //메인 메서드가 종료되어도 스레드가 종료되지 않는다.
    }
}
