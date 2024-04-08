package javaIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderTest{
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        System.out.println("키보드로부터 입력받은 문자열 :" + line);
    }
}
