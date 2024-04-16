package ByteStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;

/**
 * System.in은 inputStream임
 */

public class ByteIO {
    public static void main(String[] args) {
        KeyboardInput keyboardInput = new KeyboardInput();

        try {
            keyboardInput.echoInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class KeyboardInput{
    public void echoInput() throws IOException { // IOException 처리
        int i;
        while( (i = System.in.read()) != -1){ // -1은 enter를 의미
            // 여기서 스트림이 모두 끝날때까지 기다렸다가
            // 스트림이 끝나면 바이트를 하나하나 읽는다.

            System.out.println("눌림");
            System.out.write(i);
            // i의 값을 바이트로 변환하여 쓰기
        }
    }
    /*sdfsdf
    눌림
    s눌림
    d눌림
    f눌림
    s눌림
    d눌림
    f눌림
    생각과는 조금 다르게 작동할 수 있음
    System.in에서 엔터까지 한번에 쓰고 read에서 하나씩 읽는 방식이다.

    이 코드의 작동 방식이 예상과 다른 이유는
    표준 입력(System.in)과
    출력(System.out)의 버퍼링 때문입니다.
    Java에서 System.in.read()는 입력 스트림에서 다음 바이트를 읽습니다.
    하지만 표준 입력은 기본적으로 버퍼링되므로, 사용자가 엔터 키를 누르기 전까지 입력된 데이터가
    프로그램에 전달되지 않습니다. 이것은 대부분의 터미널과 콘솔 환경에서 일반적인 동작입니다.
    사용자가 엔터를 누를 때까지 입력된 모든 문자가 버퍼에 저장되고, 엔터를 누르는 순간 버퍼의 내용이
    한꺼번에 처리됩니다.
    */
}
