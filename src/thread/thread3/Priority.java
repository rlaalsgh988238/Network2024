package thread.thread3;

/**
 * 스레드 우선 순위
 * MAX_PRIORITY = 10
 * MIN_PRIORITY = 1
 * NORM_PRIORITY = 5
 */
public class Priority extends Thread{
    public static void main(String[] args) {
        Priority priorityMax = new Priority();
        priorityMax.setPriority(Thread.MAX_PRIORITY);
        // 우선순위 10

        Priority priorityMin = new Priority();
        priorityMin.setPriority(MIN_PRIORITY);
        // 우선순위 1

        priorityMax.start();
        priorityMin.start();

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        priorityMin.interrupt();
        priorityMax.interrupt();
        System.out.println("메인 종료");
    }
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(200);
                System.out.println(getName()+": 스레드 작동 중");
            } catch (InterruptedException e){
                e.printStackTrace();
                System.out.println(getName()+": 종료");
                Thread.currentThread().interrupt();
            }
        }

    }
}

/*
    Thread-0: 스레드 작동 중
    Thread-1: 스레드 작동 중
    Thread-0: 스레드 작동 중
    Thread-1: 스레드 작동 중
    Thread-0: 스레드 작동 중
    Thread-1: 스레드 작동 중
    Thread-0: 스레드 작동 중
    Thread-1: 스레드 작동 중
    Thread-0: 스레드 작동 중
    Thread-1: 스레드 작동 중
    Thread-0: 스레드 작동 중
    Thread-1: 스레드 작동 중
    Thread-0: 스레드 작동 중
    Thread-1: 스레드 작동 중
    Thread-0: 스레드 작동 중
    Thread-1: 스레드 작동 중
    Thread-0: 스레드 작동 중
    Thread-1: 스레드 작동 중
    메인 종료
    Thread-0: 종료
    Thread-1: 종료
*/
