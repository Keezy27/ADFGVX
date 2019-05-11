package utils;

import java.io.IOException;
import java.io.PrintWriter;

public class FileCreator {

    public FileCreator(String name, String textToPrint) throws IOException {
        name += ".txt";
        PrintWriter file = new PrintWriter(name);
        file.println(textToPrint);
        file.close();
    }
}
