package utils;

import java.util.ArrayList;
import java.util.Collections;

public class ADFGVXcypher {

    private String key;
    private String messageToEncrypt;
    private char[][] matrice;
    //private String "| "+ matriceWithKeyAlpha[row][col]+" |";

    public ADFGVXcypher(){}
    public ADFGVXcypher(String key, String messageToEncrypt, char[][] matrice){
        this.key = key;
        this.messageToEncrypt = messageToEncrypt;
        this.matrice = matrice;
    }

    public String intermediateEncrypt(String message, char[][] matrice){
        StringBuilder interEncryptMessage = new StringBuilder();
        char[] messageArray = message.toCharArray();

        for (int i = 0; i < messageArray.length; i++) {
            for (int row = 1; row < matrice.length; row++) {
                for (int col = 1; col < matrice[row].length; col++){
                    if (messageArray[i] == matrice[row][col]){
                        interEncryptMessage.append(matrice[0][row]);
                        interEncryptMessage.append(matrice[col][0]);
                    }
                }
            }
        }

        return interEncryptMessage.toString();
    }

    public char[][] genMatriceWithKey(String key, String intermediateEncrypt){
        int nbRow = getNumberOfRow(key, intermediateEncrypt);
        char[][] interCryptedWithKey = new char[key.length()][nbRow];
        char[] keyArray = key.toCharArray();
        char[] intermediateEncryptArray = intermediateEncrypt.toCharArray();
        int messageIndex = 0;

        for(int row = 0; row < nbRow; row++){
            for(int col = 0; col < keyArray.length; col++){
                if(row == 0){
                    interCryptedWithKey[row][col] = keyArray[col];
                }else{
                    if(messageIndex < intermediateEncrypt.length()){
                        interCryptedWithKey[row][col] = intermediateEncryptArray[messageIndex];
                        messageIndex++;
                    }else{
                        interCryptedWithKey[row][col] = ' ';
                    }
                }
            }
        }

        return interCryptedWithKey;
    }

    public char[][] genMatriceWithKeyAlpha(String key, char[][] interGenMatric){
        char[][] encryptedWithKey = new char[key.length()][interGenMatric[0].length];
        //char[] keyArray = key.toCharArray();
        char[] orderedKeyArray = getOrderKeyArray(key.toCharArray());

        for(int row = 0; row < encryptedWithKey.length; row++){
            for(int col = 0; col < interGenMatric[row].length; col++){
                int indexOfLetter = convertToArrayList(key.toCharArray()).indexOf(orderedKeyArray[col]);

                if(row == 0){
                    encryptedWithKey[row][col] = orderedKeyArray[col];
                }else{
                    encryptedWithKey[row][col] = interGenMatric[row][indexOfLetter];
                }
            }
        }

        return encryptedWithKey;
    }

    public String getCryptedMessage(char[][] matriceWithKeyAlpha){
        StringBuilder cryptedMessage = new StringBuilder();

        for(int row = 1; row < matriceWithKeyAlpha.length; row++){
            for(int col = 0; col < matriceWithKeyAlpha[row].length; col++){
                cryptedMessage.append(matriceWithKeyAlpha[row][col]);
            }
        }

        return cryptedMessage.toString();
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

        for(int i = 0; i < orderedKeyArray.length; i++){
            orderedKeyArray[i] = tempArrayList.get(i);
        }

        return orderedKeyArray;
    }

    private int getNumberOfRow(String key, String messageToEncrypt){
        int nbRow;
        int keyLength = key.length();
        int messageLength = messageToEncrypt.length();

        if(messageLength > keyLength){
            nbRow = (messageLength / keyLength) + (messageLength % keyLength) + 1;
        }else{
            nbRow = 2;
        }

        return nbRow;
    }

    /*------------------- DECRYPTE -----------------*/


}
