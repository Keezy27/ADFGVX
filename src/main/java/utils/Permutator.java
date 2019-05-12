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

    public void generateUnorderedMatrice(){
        int nbRow = getNumberOfRow(this.getKey(),this.getEncryptedMessage());
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

    private char[][] initialiseArray(char[][] array, int nbRow, int nbCol){
        for(int i = 0; i < nbRow; i++){
            for(int j = 0; j < nbCol; j++){
                array[i][j] = ' ';
            }
        }
        return array;
    }

    public void generateOrderedMatrcice(){
        int nbOfRow = getNumberOfRow(this.getKey(), this.getEncryptedMessage());
        this.orderedMatrice = new char[nbOfRow][key.length()];
        //this.orderedMatrice = initialiseArray(orderedMatrice, nbOfRow, key.length());
        char[] orderedKey = getOrderKeyArray(getKeyAsArray());

        for(int i = 0; i < orderedKey.length; i++){
            int indexOfLetter = convertToArrayList(getKeyAsArray()).indexOf(orderedKey[i]);
            //System.out.println(indexOfLetter);
            for(int j = 0; j < nbOfRow; j++){
                if(j == 0) {
                    this.orderedMatrice[j][i] = orderedKey[i];
                }else{
                    this.orderedMatrice[j][i] = getUnorderedMatrice()[j][indexOfLetter];
                }
            }
        }
    }

    public char[][] getOrderedMatrice() {
        return orderedMatrice;
    }

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
