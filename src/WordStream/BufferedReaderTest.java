package WordStream;

import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("옵션을 제대로 넣어주세요");
        }

        String originFile = args[0];
        String copyFile = args[1];

        BufferFileCopy bufferFileCopy = new BufferFileCopy();
        bufferFileCopy.copyFile(originFile, copyFile);
    }
}

class BufferFileCopy{
    FileReader fr;
    BufferedReader br;
    FileWriter fw;
    BufferedWriter bw;

    void copyFile(String originFile, String copyFile){
        try {
            fr = new FileReader(originFile);
            br = new BufferedReader(fr);
            // 인자로 FileReader를 넣는다.

            fw = new FileWriter(copyFile);
            bw = new BufferedWriter(fw);
            // 인자로 FileWriter를 넣는다.

            char[] buffer = new char[512];
            int readCount;

            while((readCount = br.read(buffer)) != -1){
                bw.write(buffer,0,readCount);
            }
            System.out.println("파일 복사 완료");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fr.close(); bw.close(); br.close(); fw.close();
                // 이거 제대로 안 닫으면 내용 복사 안됨
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
