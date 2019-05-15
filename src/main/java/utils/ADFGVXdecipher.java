package utils;

import java.util.ArrayList;
import java.util.Collections;

public class ADFGVXdecipher {

    public ADFGVXdecipher() {
    }

    public char[][] genMatriceWithKeyAlpha(String key, String cryptedMessage) {
        char[][] matriceWithKeyAlpha = new char[getNumberOfRow(key, cryptedMessage)][key.length()];
        char[] orderedKeyArray = getOrderKeyArray(key.toCharArray());
        char[] cryptedMessageArray = cryptedMessage.toCharArray();

        int cryptedIndex = 0;
        for (int row = 0; row < key.length(); row++) {
            for (int col = 0; col < matriceWithKeyAlpha.length; col++) {
                if (row == 0) {
                    matriceWithKeyAlpha[row][col] = orderedKeyArray[col];
                } else {
                    matriceWithKeyAlpha[row][col] = cryptedMessageArray[cryptedIndex];
                    cryptedIndex++;
                }
                System.out.print("| " + matriceWithKeyAlpha[row][col] + " |");
            }
            System.out.println("\n-----------------------------------------");
        }

        return matriceWithKeyAlpha;
    }

    public char[][] genMatriceFromKeyAlpha(String key, String cryptedMessage, char[][] matriceWithKeyAlpha) {
        char[][] matriceFromKeyAlpha = new char[getNumberOfRow(key, cryptedMessage)][key.length()];
        char[] keyArray = key.toCharArray();
        int cryptedIndex = 0;

        //for (int row = 0; row < 1; row++) {
        for (int col = 0; col < keyArray.length; col++) {
            matriceFromKeyAlpha[0][col] = keyArray[col];

            char charToFind = keyArray[col];
            int i = 0;
            boolean charFound = false;
            while (i < keyArray.length && !charFound) {
                if (matriceWithKeyAlpha[0][i] == charToFind) {
                    for (int rowToCopy = 1; rowToCopy < getNumberOfRow(key, cryptedMessage); rowToCopy++) {
                        matriceFromKeyAlpha[rowToCopy][col] = matriceWithKeyAlpha[rowToCopy][i];
                    }
                    charFound = true;
                }
                i++;
            }
        }
        return matriceFromKeyAlpha;
    }


                /*;

                while ((i < key.length()) && !charFound) {

                    if (matriceWithKeyAlpha[row][i] == charToFind){
                        for(int rowToCopy = 1; rowToCopy < getNumberOfRow(key, cryptedMessage); rowToCopy++){
                            matriceFromKeyAlpha[rowToCopy][i] = matriceWithKeyAlpha[rowToCopy][i];
                        }

                        charFound = true;
                    }
                    i++;
                }
            }
        }

        return matriceFromKeyAlpha;
    }*/

    private int getNumberOfRow(String key, String messageToEncrypt) {
        int nbRow;
        int keyLength = key.length();
        int messageLength = messageToEncrypt.length();

        if (messageLength > keyLength) {
            nbRow = (messageLength / keyLength) + (messageLength % keyLength) + 1;
        } else {
            nbRow = 2;
        }

        return nbRow;
    }

    private ArrayList<Character> convertToArrayList(char[] arrayToConvert){
        ArrayList<Character> tempArrayList = new ArrayList<Character>();
        for(char letter : arrayToConvert){
            tempArrayList.add(letter);
        }
        return tempArrayList;
    }

    private char[] getOrderKeyArray(char[] keyAsArray) {
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
