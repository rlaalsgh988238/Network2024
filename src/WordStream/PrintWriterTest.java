package WordStream;

import java.io.*;

public class PrintWriterTest {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("옵션을 제대로 넣어주세요");
            System.exit(0);
        }
        KeyBoardToFile keyBoardToFile = new KeyBoardToFile();
        String filePath = args[0];
        keyBoardToFile.keyboardToFile(filePath);
    }

}

class KeyBoardToFile{
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public void keyboardToFile(String filePath){

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // 인자로 인풋스트림리더, 인풋스트림리더에 인풋스트림(System.in) 인자로 연결
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                printWriter.println(line);
                // 라인 작성
                System.out.println("입력: "+line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
            // FileWriter
        } finally {
            try {
                bufferedReader.close();
                printWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
