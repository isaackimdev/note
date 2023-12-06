package languages.java.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileObjectOutput {
    public static void main(String[] args) throws IOException {
        String dir = "./test_dir";
        File file = new File(dir, "file4.txt");

        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        
        oos.writeObject(new Vo());
        oos.close();
    }
}

class Vo implements Serializable {
    String name = "isaac";
    int year = 2023;
}
