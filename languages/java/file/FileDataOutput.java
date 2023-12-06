package languages.java.file;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDataOutput {
    public static void main(String[] args) throws IOException {
        String dir = "./test_dir";
        File file = new File(dir, "file2.txt");

        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        int var1 = 65;
        double var2 = 3.14;
        String var3 = "https://lifere.tistory.com/";

        dos.writeInt(var1);
        dos.writeDouble(var2);
        dos.writeUTF(var3);
        dos.close();

        // 파일을 확인해보면 바이트의 쓰레기 값들이 함께 저장된다.

    }
    
}
