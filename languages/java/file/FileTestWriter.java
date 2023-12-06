package languages.java.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTestWriter {
    public static void main(String[] args) throws IOException {
        String dir = "./test_dir";
        File file = new File(dir, "file3.txt");

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Hello world\n");
        bw.write("github of isaac");
        
        bw.close();
        fw.close();
        
    }
}
