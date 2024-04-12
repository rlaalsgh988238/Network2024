package ByteStream;

import java.io.File;
import java.io.IOException;

/**
 * File클래스에 대한 예제
 * 사용방법: 터미널 통해 해당 디렉토리 들어감
 * java ./FileSet.java makeFile
 */
public class FileSet {
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("옵션을 붙여주세요");
            return;
        }

        MethodSet methodSet = new MethodSet();

        switch (args[0]){ // 맨 첫번째 args
            case "makeFile":
                System.out.println("makeFile");
                methodSet.makeFile();
                break;
            case "makeDirs":
                System.out.println("makeDirs");
                methodSet.makeDirs();
                break;
            case "fileInfo":
                System.out.println("fileInfo");
                methodSet.fileInfo();
                break;
            case "fileDelete":
                System.out.println("fileDelete");
                methodSet.fileDelete();
                break;
            case "directoryInfo":
                System.out.println("directoryInfo");
                methodSet.directoryInfo();
                break;
            case "tempFile":
                System.out.println("tempFile");
                methodSet.tempFile();
                break;

        }
    }
}

class MethodSet{
    String directoryPath = "./FileDirectory";
    String filePath = directoryPath + "/exampleFile.txt";
    public void makeFile(){
        File file = new File(filePath);

        if (file.exists()){ // 파일 존재 여부 확인
            System.out.println("파일 이미 존재");
        }
        else {
            try {
                if (file.createNewFile()){ // 파일 생성, type = Boolean
                    System.out.println("파일 생성");
                } else {
                    makeDirs();
                }

            } catch (IOException e) {
                System.out.println("파일 생성 실패");
                throw new RuntimeException(e);
            }
        }
    }

    public void makeDirs(){ // 해당 경로의 디렉토리 모두 생성
        File file = new File(directoryPath);
        file.mkdirs(); // 디렉토리 만들기
        String absolutePath = file.getAbsolutePath(); // 절대경로
        System.out.println("디렉토리 생성: "+absolutePath);
    }

    public void fileInfo(){
        File file = new File(filePath);

        System.out.println("length: " + file.length());
        System.out.println("canRead: " +file.canRead());
        System.out.println("canWrite: " +file.canWrite());
        System.out.println("getName: " +file.getName());
        System.out.println("getPath: " +file.getPath());
        try {
            System.out.println("getCanonicalPath: " +file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fileDelete(){
        File file = new File(filePath);
        if (file.exists()){
            System.out.println("파일 존재");
            if (file.delete()){
                System.out.println("파일 삭제");
            } else {
                System.out.println("파일 삭제 실패");
            }
         } else {
            System.out.println("파일 존재하지 않음");
        }
    }

    public void directoryInfo(){
        File file = new File(directoryPath);
        File[] fileList = file.listFiles();

        for (int i=0; i< fileList.length; i++){
            int fileNum = i+1;
            System.out.println(fileNum + ": "+fileList[i].getName());
        }
    }

    public void tempFile(){
        try {
            File file = File.createTempFile("tmp_",".txt",new File(directoryPath));
            // prefix: 파일의 앞자리 이름
            // suffix: 파일의 형식, 마지막은 디렉토리임 마지막 프로퍼티 안넣으면 환경변수 따라감

            System.out.println("생성된 임시파일 이름: "+file.getName());
            System.out.println("생성된 임시파일 경로: "+file.getAbsolutePath());
            file.deleteOnExit(); // JVM종료 시 임시파일 자동 삭제
            try {
                System.out.println("10초 후 프로그램 종료");
                Thread.sleep(10000);
                System.out.println("프로그램 종료, 임시파일 삭제");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

