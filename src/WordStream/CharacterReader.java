package WordStream;

import java.io.*;

/**
 * 파일에서 읽어서 화면에 출력
 */
public class CharacterReader {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("옵션을 제대로 넣어주세요");
            System.exit(0);
        }
        PrintChar printChar = new PrintChar();
        printChar.fileToScreen(args[0]);

    }
}

class PrintChar{
    CharArrayReader chr;
    CharArrayWriter chw;
    BufferedWriter bw;
    FileReader fr;
    public void fileToScreen(String filePath){
        try {
            fr = new FileReader(filePath);
            chw = new CharArrayWriter();
            char[] buffer = new char[512];
            int readCount;
            while((readCount = fr.read(buffer)) != -1){
                chw.write(buffer,0,readCount);
            }

            char[] fileArray = chw.toCharArray();
            // 받은 char배열 갖고오기

            System.out.println("길이: "+fileArray.length);


            chr = new CharArrayReader(fileArray);
            // 인자로 캐릭터배열
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // 버퍼를 통해서 쓴다.

            while ((readCount = chr.read(buffer)) != -1){
                bw.write(buffer,0,readCount);
                bw.flush();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
                chr.close();
                fr.close();
                chw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
