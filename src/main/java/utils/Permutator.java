package utils;

import java.util.ArrayList;

public class Permutator {
    private String key;
    private String encryptedMessage;
    private char[][] unorderedMatrice;
    private char[] keyArray;
    private char[] encryptedArray;
    //private ArrayList<ArrayList<Character>> matriceEncrypted;

    public Permutator(){
        //matriceEncrypted = new ArrayList<ArrayList<Character>>();
    }

    public Permutator(String key, String encryptedMessage){
        this();
        this.key = key;
        this.encryptedMessage = encryptedMessage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    public void setEncryptedMessage(String encryptedMessage) {
        this.encryptedMessage = encryptedMessage;
    }

    public void generateUnorderedMatrice(){
        this.keyArray = this.getKey().toCharArray();
        this.encryptedArray = this.getEncryptedMessage().toCharArray();
        int nbRow = getNumberOfRow(this.getKey(),this.getEncryptedMessage());
        this.unorderedMatrice = new char[nbRow][this.getKey().length()];

        int messageIndex = 0;
        for(int i = 0; i < nbRow; i++){
            for(int j = 0; j < keyArray.length; j++){
                if(i == 0){
                    this.unorderedMatrice[i][j] = keyArray[j];
                }else{
                    if(messageIndex < encryptedArray.length){
                        this.unorderedMatrice[i][j] = encryptedArray[messageIndex];
                        messageIndex++;
                    }else{
                        this.unorderedMatrice[i][j] = ' ';
                    }
                }
            }
        }
    }

    public void print(){
        for(int i = 0; i < getNumberOfRow(key,encryptedMessage); i++) {
            for (int j = 0; j < keyArray.length; j++) {
                System.out.print("| " + unorderedMatrice[i][j] + " |");
                if( j == (keyArray.length -1)){
                    System.out.println("\n---------------------------------");
                    System.out.println();
                }
            }
        }
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
