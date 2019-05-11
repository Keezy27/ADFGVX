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

    public int setNumberOfRow(String key, String encryptedMessage){
        int nbRow = 0;
        int keyLength = key.length();
        int messageLength = encryptedMessage.length();

        if(messageLength > keyLength){
            nbRow = (messageLength / keyLength) + (messageLength % keyLength);
        }else if(messageLength < keyLength){
            nbRow = 1;
        }

        return nbRow;
    }
}
