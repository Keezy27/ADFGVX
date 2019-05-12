package utils;

import java.util.ArrayList;

public class Permutator {
    private String key;
    private ArrayList<ArrayList<Character>> matriceEncrypted;

    public Permutator(){
        matriceEncrypted = new ArrayList<ArrayList<Character>>();
    }

    public Permutator(String key){
        this();
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void generateUnorderedMatrice(String key, String encryptedMessage){
        char[] keyArray = key.toCharArray();
        char[] encryptedArray = encryptedMessage.toCharArray();
        char[][] unorderedMatrice = new char[getNumberOfRow(key,encryptedMessage)][key.length()];

        int messageIndex = 0;
        for(int i = 0; i < getNumberOfRow(key,encryptedMessage); i++){
            for(int j = 0; j < keyArray.length; j++){
                if(i == 0){
                    unorderedMatrice[i][j] = keyArray[j];
                }else{
                    if(messageIndex < encryptedArray.length){
                        unorderedMatrice[i][j] = encryptedArray[messageIndex];
                        messageIndex++;
                    }else{
                        unorderedMatrice[i][j] = ' ';
                    }
                }
            }
        }

        /*for(int i = 0; i < getNumberOfRow(key,encryptedMessage); i++) {
            for (int j = 0; j < keyArray.length; j++) {
                System.out.print("| " + unorderedMatrice[i][j] + " |");
                if( j == (keyArray.length -1)){
                    System.out.println("\n---------------------------------");
                    System.out.println();
                }
            }
        }*/
    }

    private int getNumberOfRow(String key, String encryptedMessage){
        int nbRow;
        int keyLength = key.length();
        int messageLength = encryptedMessage.length();

        if(messageLength > keyLength){
            nbRow = (messageLength / keyLength) + (messageLength % keyLength) + 1;
        }else{
            nbRow = 2;
        }

        return nbRow;
    }
}
