package languages.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInput {
    public static void main(String[] args) throws IOException {
        String dir = "./test_dir";
        File file1 = new File(dir + "/file1.txt");

        FileInputStream fis = new FileInputStream(file1);

        while (true) {
            int res = fis.read(); // 한 글자 씩 아스키 코드 값으로 받는다.
            if(res == -1) break;    // Byte 입력에서 파일의 끝(EOF) 값은 -1 입니다.
            System.out.print((char) res);
        } 
        
        // FOS 에서 실습에 만들어 둔 파일 내용 'Aworl'을 출력한다.
    }
}
