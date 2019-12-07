package PracticeBuoi12;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFileController {
    String getDataFromFile(String path) throws IOException;
    void setDataToFile(String path, String data) throws IOException;
}
