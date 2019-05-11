package utils;

import org.apache.commons.lang3.CharUtils;

public class Encryptor {

    private String[][] matrice;
    private String clearMessage;


    public Encryptor(){
    }

    public String encryptedMessage(String message, Character[][] matrice){
        StringBuilder encryptedMessage = new StringBuilder();
        char[] messageArray = message.toCharArray();

        for(int i=0; i < messageArray.length; i++){

            if(messageArray[i] == ' '){
                encryptedMessage.append(messageArray[i]);
            }else{
                for(int j=1; j < matrice.length; j++){
                    for(int k=1; k < matrice.length; k++){
                        if( messageArray[i] == CharUtils.toChar(matrice[j][k])){
                            encryptedMessage.append(matrice[0][k]);
                            encryptedMessage.append(matrice[j][0]);
                        }
                    }
                }
            }

        }

        return encryptedMessage.toString();
    }










}
