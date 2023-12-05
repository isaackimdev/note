package languages.java.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {
    public static void main(String[] args) throws IOException {
        // 1. directory 생성
        String dir = "./test_dir";
        boolean res = new File(dir).mkdir();
        System.out.println("res : " + res);
        
        // 2. file 지정하기
        File file1 = new File(dir + "/file1.txt");
        File file2 = new File(dir, "/file2.txt");
        // file 생성
        file1.createNewFile();
        file2.createNewFile();

        // 파일에 내용 쓰기
        // 두 번째 매개 변수가 true면 이어 쓰기, false면 다시 쓰기 default false
        FileOutputStream fos = new FileOutputStream(file1, true);
        fos.write(65); // 'A'

        byte[] by = "Hello world".getBytes();
        fos.write(by, 6, 4);
        fos.close();
        
    }
}
