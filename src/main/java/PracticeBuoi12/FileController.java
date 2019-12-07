package PracticeBuoi12;

import java.io.*;

public class FileController implements IFileController {

    @Override
    public String getDataFromFile(String path) throws IOException {

        FileReader f = new FileReader(path);
        BufferedReader bfr = new BufferedReader(f);

        StringBuffer sb = new StringBuffer();

        String line;
        while( (line = bfr.readLine()) != null){
            sb.append(line);
        }

        bfr.close();

        return sb.toString();
    }

    @Override
    public void setDataToFile(String path, String data) throws IOException {
        FileWriter fstream = new FileWriter(path, true);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write(data);
        out.newLine();
        out.close();
    }
}
