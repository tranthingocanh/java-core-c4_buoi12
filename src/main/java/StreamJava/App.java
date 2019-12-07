package StreamJava;

import java.io.FileInputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            FileInputStream fis = new FileInputStream("E:\\java-core-c4\\FileDataInputStream.txt");
            int i;
            while((i=fis.read())!=-1){
                System.out.print((char)i);
            }
            fis.close();
        }catch(Exception e){
            System.out.println( "Can't read the file!!!" );
        }

    }
}
