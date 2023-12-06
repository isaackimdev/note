package languages.java.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileTextReader {
    public static void main(String[] args) throws IOException {
        String dir = "./test_dir";
        File file = new File(dir, "file3.txt");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while(true) {
            String lineText = br.readLine();
            if (lineText == null) break; // text 파일의 끝은 null
            System.out.println(lineText);
        }


    }
}
