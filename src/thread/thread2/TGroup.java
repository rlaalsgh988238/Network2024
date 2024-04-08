package thread.thread2;

import java.util.ArrayList;

public class TGroup {
    public static void main(String[] args) {
        ThreadGroup parentGroup = new ThreadGroup("Parent");
        // 상위 그룹
        ThreadGroup childGroup = new ThreadGroup(parentGroup, "child");
        // 하위 그룹

        TGroup joinMethod = new TGroup();
        int parentNum = 4;
        int childNum = 5;

        ArrayList<Thread> parentList = joinMethod.makeThread("parent",parentGroup, parentNum);
        // 상위 스레드 생성
        ArrayList<Thread> childList = joinMethod.makeThread("child",childGroup, childNum);
        // 하위 스레드 생성

        for(int i = 0; i<parentNum; i++){
            // 상위 스레드 시작
            parentList.get(i).start();
        }

        for(int i = 0; i<childNum; i++){
            // 하위 스레드 시작
            childList.get(i).start();
        }

        try {
            Thread.sleep(3000);
            // 스레드 시작 후
        } catch (InterruptedException e){
            e.printStackTrace();
        }

//        parentGroup.interrupt(); // 모두 종료됨
//        childGroup.interrupt(); // child만 종료됨

    }

    private ArrayList<Thread> makeThread(String groupName, ThreadGroup threadGroup, int num){
        // 스레드 여러개 생성
        // 그룹별로 생성

        ArrayList<Thread> threadList = new ArrayList<>();
        for(int i=0; i<num; i++){
            RunnableObject runnableObject = new RunnableObject();
            // 러너블

            threadList.add(new Thread(threadGroup, runnableObject,groupName+i));
            System.out.println(groupName+i+": 생성");
            // 리스트에 스레드 삽입
        }
        return threadList;
    }

}

class RunnableObject implements Runnable{
    // blackbox로 생성

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try{
                System.out.println(Thread.currentThread().getName()+": 동작 중");
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(Thread.currentThread().getName()+": 종료");
    }

}

