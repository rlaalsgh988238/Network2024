package WordStream;

import java.io.*;

/**
 * ide에서 실행
 */
public class PrintFileToWord {
    public static void main(String[] args) {
        PrintTextFile printFile = new PrintTextFile();
        printFile.printFile();
    }
}

class PrintTextFile{
    String filePath = "./src/WordStream/files/text.txt";
    FileInputStream fis;
    InputStreamReader isr;
    OutputStreamWriter osw;
    int readCount = 0;

    void printFile(){
        try {
            fis  = new FileInputStream(filePath);
            isr = new InputStreamReader(fis);
            // 인자로 인풋스트림
            osw = new OutputStreamWriter(System.out);

            char buffer[] = new char[512];
            while((readCount = isr.read(buffer)) != -1){
                osw.write(buffer, 0, readCount);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            // 스트림 생성
        } catch (IOException e) {
            throw new RuntimeException(e);
            //인풋스트림리더 read exception
        } finally {
            try{
                fis.close();isr.close();osw.close();
            } catch (Exception e){

            }
        }
    }
}
