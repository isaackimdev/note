package languages.java.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class FileObjectInput {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String dir = "./test_dir";
        File file = new File(dir, "file4.txt");

        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        Vo vo = (Vo) ois.readObject();
        System.out.println("name : "+vo.name);
        System.out.println("year : "+vo.year); 
        
        ois.close();
        bis.close();
        fis.close();
    }
}

class Vo implements Serializable {
    String name;
    int year;
}