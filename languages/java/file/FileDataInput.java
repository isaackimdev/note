package languages.java.file;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDataInput {
    public static void main(String[] args) throws IOException {
        String dir = "./test_dir";
        File file = new File(dir, "file2.txt");

        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);

        int v1 = dis.readInt();
        double v2 = dis.readDouble();
        String v3 = dis.readUTF();

        System.out.println("v1 : "+v1);
        System.out.println("v2 : "+v2);
        System.out.println("v3 : "+v3);

        dis.close();
        
        // 바이트로 썼던 데이터를 자바의 변수에 제대로 담아서 출력할 수 있다.
        // v1 : 65
        // v2 : 3.14
        // v3 : https://lifere.tistory.com/

    }
}
