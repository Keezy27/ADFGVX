package utils;

public class Encryptor {

    private char[][] matrice;
    private String clearMessage;


    public Encryptor(){
    }

    /*public String intermediateEncryptedMessage(String message, char[][] matrice){
        StringBuilder encryptedMessage = new StringBuilder();
        char[] messageArray = message.toCharArray();

        for(int i=0; i < messageArray.length; i++){

            if(messageArray[i] == ' '){
                encryptedMessage.append(messageArray[i]);
            }else{
                for(int j=1; j < matrice.length; j++){
                    for(int k=1; k < matrice.length; k++){
                        if( messageArray[i] == CharUtils.toChar(matrice[j][k])){
                            encryptedMessage.append(matrice[0][j]);
                            encryptedMessage.append(matrice[k][0]);
                        }
                    }
                }
            }
        }
        return encryptedMessage.toString();
    }*/

    /*public String finalEncryption(char[][] orderedMatrice){
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < orderedMatrice.length; i++){
            for(int j = 0; j < orderedMatrice[i].length; j++){
                sb.append(orderedMatrice[i][j]);
            }
        }
        return sb.toString();
    }*/










}
