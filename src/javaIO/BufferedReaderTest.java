package javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderTest{
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        // InputStream은 Reader를 extend함.
        // InputStream은 System.in에서 읽어들이고 BufferReader는 InputStream을 통해 읽어 들임

        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        System.out.println("키보드로부터 입력받은 문자열 :" + line);
    }
}

class SystemIn{
    public static void main(String[] args) {
        try {
            while (true){
                int d = System.in.read();
                // -1 ~ 255

                System.out.println(d);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/**
    s
         115
         10
    sdfsdf
         115
         100
         102
         115
         100
         102
         10
    s
            115
         10
    d
         100
         10
    f
         102
         10
*/
}
