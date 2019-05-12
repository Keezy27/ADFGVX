package utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCreator {
    private static String FOLDER_NAME = "ADFGVX/";

    public static void createFile(String name, String textToPrint) throws IOException {
        File file = new File(FOLDER_NAME + name + ".txt");

        if(!file.exists()){
            file.getParentFile().mkdirs();
        }

        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(textToPrint);
        printWriter.close();
    }

}
