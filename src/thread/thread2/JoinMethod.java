package thread.thread2;

import java.util.ArrayList;

/**
 * 스레드는 1초 기다림
 * join을 쓰니
 * 메인함수가 스레드가 종룟될때 까지 기다림
 */
public class JoinMethod extends Thread{

    public static void main(String[] args) {
        JoinMethod joinMethod = new JoinMethod();
        joinMethod.start();

        System.out.println("join 하기 전");
        try {
            joinMethod.join();
            // 조인
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("join 후, 1초 기다리기 전");
        try {
            Thread.sleep(1000);
            // 조인
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("메인함수 종료");
    }
    public void run(){
        System.out.println("스레드 시작");
        try {
            Thread.sleep(1000);
            //스레드는 1초 기다림
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("스레드 종료");
    }
}
