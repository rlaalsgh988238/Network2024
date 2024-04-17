package WordStream;

import java.io.*;

/**
 * 터미널 실행
 */
public class FileRW {

    public static void main(String[] args) {
        String originFile = null;
        String copyFile = null;

        if(args.length == 0 || args.length > 2){
            System.out.println("옵션 제대로 붙여주세요");
            return;
        } else {
            originFile = args[0];
            copyFile = args[1];
        }
        // 터미널 동작 구현부

        FileCopy fileCopy = new FileCopy(originFile, copyFile);
        fileCopy.copyFile();
    }
}

class FileCopy{
    FileReader fileReader;
    FileWriter fileWriter;
    //InputStreamReader 상속
    String originFilePath = "";
    String copyFilePath;


    public FileCopy(String originFilePath, String copyFilePath){
        this.originFilePath = originFilePath;
        this.copyFilePath = copyFilePath;
    }

    public void copyFile(){
        try {
            fileReader = new FileReader(originFilePath);
            fileWriter = new FileWriter(copyFilePath);
            int readCount=0;
            char[] buffer = new char[512];
            while ((readCount = fileReader.read(buffer)) != -1){
                fileWriter.write(buffer,0,readCount);
                // 파일 없으면 생성하고 복사함
            }
            System.out.println("파일 복사 성공");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            // 파일리더
        } catch (IOException e) {
            throw new RuntimeException(e);
            // 파일라이터
        } finally {
            try {
                fileWriter.close();
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
