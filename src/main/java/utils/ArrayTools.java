package utils;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayTools {

    public static int getNumberOfRow(String key, String message){
        int nbRow;
        int keyLength = key.length();
        int messageLength = message.length();

        if(messageLength > keyLength){
            nbRow = (messageLength / keyLength) + (messageLength % keyLength) + 1;
        }else{
            nbRow = 2;
        }

        return nbRow;
    }

    public static ArrayList<Character> convertToArrayList(char[] arrayToConvert){
        ArrayList<Character> tempArrayList = new ArrayList<Character>();
        for(char letter : arrayToConvert){
            tempArrayList.add(letter);
        }
        return tempArrayList;
    }

    public static char[] getOrderKeyArray(char[] keyAsArray) {
        char[] orderedKeyArray;
        ArrayList<Character> tempArrayList = convertToArrayList(keyAsArray);
        Collections.sort(tempArrayList);

        orderedKeyArray = new char[keyAsArray.length];

        for (int i = 0; i < orderedKeyArray.length; i++) {
            orderedKeyArray[i] = tempArrayList.get(i);
        }

        return orderedKeyArray;
    }
}
