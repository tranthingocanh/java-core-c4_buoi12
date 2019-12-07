package StreamJava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String path =
                "E:\\java-core-c4\\buoi12\\DATA_FILE.txt";
        try{
            FileReader f = new FileReader(path);
            BufferedReader bfr = new BufferedReader(f);

            String line;
            StringBuffer sb = new StringBuffer();

            while((line = bfr.readLine()) != null ){
                sb.append(line);
            }
            System.out.println( sb.toString() );
            Pattern thongTinChung = Pattern.compile("\\{THONG_TIN_CHUNGNGAY_NHAP_HANG: (\\d{4}\\/\\d{2}\\/\\d{2})TEN_CONG_TY: .+}THONG_TIN_CHUNG");
            Matcher m = thongTinChung.matcher(sb.toString());


            MatchResult result
                    = m.toMatchResult();
            System.out.println("Current Matcher: "
                    + result);

            while (m.find()) {
                System.out.println("Current");
                // Get the group matched using group() method
                System.out.println(m.group(1));
            }
        }catch (FileNotFoundException e){
            System.err.println("Duong dan bi sai");
        }catch (IOException e1){
            System.err.println("Khong doc duoc du lieu");
        }


    }
}
