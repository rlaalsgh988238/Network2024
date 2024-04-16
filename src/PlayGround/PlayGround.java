package PlayGround;

import java.io.*;

public class PlayGround {
    public static void main(String[] args) {
        KeyBoardToFile keyBoardToFile = new KeyBoardToFile();
        keyBoardToFile.makeFile();

    }
}

class KeyBoardToFile{
    String directoryPath = "./src/PlayGround/filePackage/";
    String fileName = "keyBoardToFile.txt";
    String filePath = directoryPath+fileName;
    File file;
    File directory;

    void makeFile(){
        file = new File(filePath);
        directory = new File(directoryPath);

        if (directory.exists()){ // 디렉토리 있는지 확인
            System.out.println("디렉토리 존재");
            if (file.exists()){
                System.out.println("파일 존재");
                return;
            }
            else {
                try {
                    System.out.println("파일 생성");
                    file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else {
            directory.mkdirs();
            System.out.println("디렉토리 생성");
            try {
                file.createNewFile();
                System.out.println("파일 생성");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void getType(){
        file = new File(filePath);
        InputStream typeStream = System.in;
        try {
            FileOutputStream fis = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
