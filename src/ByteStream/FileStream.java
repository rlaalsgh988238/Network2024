package ByteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/** 터미널로 실행할 것
 *
 */
public class FileStream { // 터미널 기준
    static String directoryPath = "./FileDirectory/";
    static String fileName = "exampleFile.txt";
    public static void main(String[] args) {
        File file = new File(directoryPath+fileName);

        FileInput fileInput = new FileInput();
        fileInput.createFileInputStream(file);
        try {
            fileInput.printFileBetter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fileInput.closeFis();
            // 인풋스트림 닫기
        }
    }
}

class FileInput{
    String directoryPath = "./FileDirectory/";
    String fileName = "exampleFile.txt";

    FileInputStream fis;
    public void createFileInputStream(){ // 경로로 fis 생성
        try {
            this.fis = new FileInputStream(directoryPath+fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void createFileInputStream(File file){ // 파일객체로 fis생성
        try {
            this.fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void printFile() throws IOException {
        int i;
        while((i=fis.read()) != -1){
            System.out.write(i);
        }
    }

    public void printFileBetter() throws IOException {
        // 효율적이게 파일에 접근하는 횟수를 줄인다.

        int readCount = 0;
        byte[] buffer = new byte[512];
        while((readCount = fis.read(buffer)) != -1){
            System.out.write(buffer, 0, readCount);
            // buffer에 적힌 내용을 작성함. 0은 오프셋
        }
    }

    public void closeFis(){
        try {
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

class FileOutput{
    String directoryPath = "./FileDirectory/";
    String fileName = "exampleFile.txt";
}
