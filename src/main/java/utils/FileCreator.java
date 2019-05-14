package utils;

import java.io.*;

public class FileCreator {
    private static String FOLDER_NAME = "ADFGVX/";
    private static String MATRICE_FILENAME = "matrice";
    private static String KEY_FILENAME = "key";
    private static String ENCRYPTED_FILENAME = "encrypted";
    private static String EXTENSION_FILE = ".txt";

    public static void createFile(String name, String textToPrint) throws IOException {
        File file = new File(FOLDER_NAME + name + EXTENSION_FILE);

        if(!file.exists()){
            file.getParentFile().mkdirs();
        }

        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(textToPrint);
        printWriter.close();
    }

    public static boolean checkFilesOk(){
        return checkFileExist(FOLDER_NAME+MATRICE_FILENAME+EXTENSION_FILE) //&&
                /*checkFileExist(FOLDER_NAME+KEY_FILENAME+EXTENSION_FILE) &&
                checkFileExist(FOLDER_NAME+ENCRYPTED_FILENAME+EXTENSION_FILE)*/;
    }

    private static boolean checkFileExist(String fileName){
        File file = new File(fileName);
        return file.exists();
    }

    public static String readFile(String name) throws IOException{
        StringBuilder sb = new StringBuilder();

        File file = new File(FOLDER_NAME + name + EXTENSION_FILE);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String tempString;
        while ((tempString = br.readLine()) != null){
            sb.append(tempString);
        }
        return sb.toString();
    }

}
