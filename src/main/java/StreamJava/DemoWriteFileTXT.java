package StreamJava;

import java.io.FileOutputStream;
import java.util.Scanner;

public class DemoWriteFileTXT {
    public static void main(String[] args) {
        try{
            FileOutputStream fos = new FileOutputStream("E:\\java-core-c4\\FileOutput.txt");
            Scanner sc = new Scanner(System.in);
            System.out.println("Please input a string to write: ");
            String s = sc.nextLine();
            fos.write(s.getBytes());

            fos.close();
            System.out.println("Susscess!!!");
        }catch(Exception e){
            System.out.println("The path doesn't exist");
        }
    }
}
