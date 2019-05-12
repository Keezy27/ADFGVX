package utils;

import java.util.ArrayList;
import java.util.Collections;

public class Permutator {
    private String key;
    private String encryptedMessage;
    private char[][] unorderedMatrice;
    private char[] keyArray;
    private char[] encryptedArray;

    private ArrayList<Character> tempArrayList;
    private char[] orderedKeyArray;
    //private ArrayList<ArrayList<Character>> matriceEncrypted;

    public Permutator(){
        this.tempArrayList = new ArrayList<Character>();
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

    public char[] getKeyArray() {
        return keyArray;
    }

    public void setKeyArray(char[] keyArray) {
        this.keyArray = keyArray;
    }

    public char[] getEncryptedArray() {
        return encryptedArray;
    }

    public void setEncryptedArray(char[] encryptedArray) {
        this.encryptedArray = encryptedArray;
    }

    public char[][] getUnorderedMatrice() {
        return unorderedMatrice;
    }

    public void setUnorderedMatrice(char[][] unorderedMatrice) {
        this.unorderedMatrice = unorderedMatrice;
    }

    public char[] getOrderedKeyArray() {
        return orderedKeyArray;
    }

    public void setOrderedKeyArray(char[] orderedKeyArray) {
        for(int i = 0; i < orderedKeyArray.length; i++){
            this.tempArrayList.add(this.getKeyArray()[i]);
        }
        Collections.sort(this.tempArrayList);
        this.orderedKeyArray = new char[getKeyArray().length];
        for(int i = 0; i < orderedKeyArray.length; i++){
            this.orderedKeyArray[i] = this.tempArrayList.get(i);
        }
    }

    public void generateUnorderedMatrice(){
        this.setKeyArray(this.getKey().toCharArray());
        this.setEncryptedArray(this.getEncryptedMessage().toCharArray());
        int nbRow = getNumberOfRow(this.getKey(),this.getEncryptedMessage());
        this.setUnorderedMatrice(new char[nbRow][this.getKey().length()]);

        int messageIndex = 0;
        for(int i = 0; i < nbRow; i++){
            for(int j = 0; j < getKeyArray().length; j++){
                if(i == 0){
                    this.getUnorderedMatrice()[i][j] = getKeyArray()[j];
                }else{
                    if(messageIndex < getEncryptedArray().length){
                        this.getUnorderedMatrice()[i][j] = getEncryptedArray()[messageIndex];
                        messageIndex++;
                    }else{
                        this.getUnorderedMatrice()[i][j] = ' ';
                    }
                }
            }
        }
    }

    //public void set

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

        System.out.println("Key : " + this.getKey());

        this.setOrderedKeyArray(this.getKeyArray());
        System.out.print("Ordered key : ");
        for(int i = 0; i < getOrderedKeyArray().length; i++){
            System.out.print(getOrderedKeyArray()[i]);
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
