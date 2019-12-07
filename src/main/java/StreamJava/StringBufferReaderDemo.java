package StreamJava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringBufferReaderDemo {
    public static void main(String[] args) {
        String path =
                "E:\\java-core-c4\\DATA_FILE.txt";
        try{
            FileReader f = new FileReader(path);
            BufferedReader bfr = new BufferedReader(f);

            String line;
            String s = "";
            StringBuffer sb = new StringBuffer();

            while((line = bfr.readLine()) != null && (line = bfr.readLine()) != ""){
                //sb.append(line);
                //sb.append("\n");
                s = s + line;
                s = s + "\n";
            }

            //System.out.println(sb.toString());
            System.out.println(s);

        }catch (FileNotFoundException e){
            System.err.println("Duong dan bi sai");
        }catch (IOException e1){
            System.err.println("Khong doc duoc du lieu");
        }


    }
}
