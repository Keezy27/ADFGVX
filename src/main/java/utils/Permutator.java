package utils;

import java.util.ArrayList;
import java.util.Collections;

public class Permutator {
    private String key;
    private String encryptedMessage;
    private char[][] unorderedMatrice;
    private ArrayList<Character> tempArrayList;
    private char[][] orderedMatrice;

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

    private char[][] getUnorderedMatrice() {
        return unorderedMatrice;
    }

    private void setUnorderedMatrice(char[][] unorderedMatrice) {
        this.unorderedMatrice = unorderedMatrice;
    }

    private char[] getOrderKeyArray(char[] keyAsArray) {
        char[] orderedKeyArray;
        tempArrayList = convertToArrayList(keyAsArray);
        Collections.sort(this.tempArrayList);

        orderedKeyArray = new char[keyAsArray.length];

        for(int i = 0; i < orderedKeyArray.length; i++){
            orderedKeyArray[i] = this.tempArrayList.get(i);
        }

        return orderedKeyArray;
    }

    private ArrayList<Character> convertToArrayList(char[] arrayToConvert){
        ArrayList<Character> tempArrayList = new ArrayList<Character>();
        for(char letter : arrayToConvert){
            tempArrayList.add(letter);
        }
        return tempArrayList;
    }

    private char[] getKeyAsArray(){
        return getKey().toCharArray();
    }

    private char[] getEncryptedMessageAsArray(){
        return getEncryptedMessage().toCharArray();
    }

    public void generateUnorderedMatrice(String key, String encryptedMessage){
        int nbRow = getNumberOfRow(key,encryptedMessage);
        this.setUnorderedMatrice(new char[nbRow][this.getKey().length()]);

        int messageIndex = 0;
        for(int i = 0; i < nbRow; i++){
            for(int j = 0; j < getKeyAsArray().length; j++){
                if(i == 0){
                    this.getUnorderedMatrice()[i][j] = getKeyAsArray()[j];
                }else{
                    if(messageIndex < getEncryptedMessageAsArray().length){
                        this.getUnorderedMatrice()[i][j] = getEncryptedMessageAsArray()[messageIndex];
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
        System.out.println("unorderdMatric ");
        for(int i = 0; i < getNumberOfRow(key,encryptedMessage); i++) {
            for (int j = 0; j < getKeyAsArray().length; j++) {
                System.out.print("| " + unorderedMatrice[i][j] + " |");
                if( j == (getKeyAsArray().length -1)){
                    System.out.println("\n---------------------------------");
                    System.out.println();
                }
            }
        }

        System.out.println("---------------");

        char[] orderedKey = getOrderKeyArray(getKeyAsArray());
        System.out.println("Key : " + this.getKey());
        System.out.print("Ordered key : ");
        for(int i = 0; i < orderedKey.length; i++){
            System.out.print(orderedKey[i]);
        }

        System.out.println("---------------");

        System.out.println("orderdMatric ");
        for(int i = 0; i < getNumberOfRow(key,encryptedMessage); i++) {
            for (int j = 0; j < getKeyAsArray().length; j++) {
                System.out.print("| " + orderedMatrice[i][j] + " |");
                if( j == (getKeyAsArray().length -1)){
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
