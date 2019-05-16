package cypher;

import utils.ArrayTools;

public class ADFGVXdecipher {

    private String key;
    private String encryptedMessage;

    public ADFGVXdecipher(String key, String encryptedMessage) {
        this.key = key;
        this.encryptedMessage = encryptedMessage;
    }

    private String getKey() {
        return key;
    }

    private String getEncryptedMessage() {
        return encryptedMessage;
    }

    public String getSemiCryptedMessage(){
        return getMessageSemiCrypted(genMatriceFromMatriceWithKeyAlpha(genMatriceWithKeyAlpha()));
    }

    private char[][] genMatriceWithKeyAlpha() {
        char[][] matriceWithKeyAlpha = new char[ArrayTools.getNumberOfRow(getKey(), getEncryptedMessage())][getKey().length()];
        char[] orderedKeyArray = ArrayTools.getOrderKeyArray(getKey().toCharArray());
        char[] cryptedMessageArray = getEncryptedMessage().toCharArray();

        int cryptedIndex = 0;
        for (int row = 0; row < getKey().length(); row++) {
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

    private char[][] genMatriceFromMatriceWithKeyAlpha(char[][] matriceWithKeyAlpha) {
        int numberOfRow = ArrayTools.getNumberOfRow(getKey(), getEncryptedMessage());
        char[][] matriceFromKeyAlpha = new char[numberOfRow][getKey().length()];
        char[] keyArray = getKey().toCharArray();

        for (int col = 0; col < keyArray.length; col++) {
            matriceFromKeyAlpha[0][col] = keyArray[col];

            char charToFind = keyArray[col];
            int i = 0;
            boolean charFound = false;
            while (i < keyArray.length && !charFound) {
                if (matriceWithKeyAlpha[0][i] == charToFind) {
                    for (int rowToCopy = 1; rowToCopy < numberOfRow; rowToCopy++) {
                        matriceFromKeyAlpha[rowToCopy][col] = matriceWithKeyAlpha[rowToCopy][i];
                    }
                    charFound = true;
                }
                i++;
            }
        }
        return matriceFromKeyAlpha;
    }

    private String getEncryptedMessageReady(char[][] matriceFromMatriceWithKeyAlpha){
        StringBuilder encrypted = new StringBuilder();

        for(int row = 1; row < matriceFromMatriceWithKeyAlpha.length; row++){
            for(int col = 0; col < matriceFromMatriceWithKeyAlpha[row].length; col++){
                encrypted.append(matriceFromMatriceWithKeyAlpha[row][col]);
            }
        }

        return encrypted.toString();
    }

    public String getMessage(char[][] matrice){
        StringBuilder message = new StringBuilder();

        int messageIndex = 0;
        char[] encryptedMessageArray = encryptedMessage.toCharArray();
        for(int row = 0; row < matrice.length; row++){
            for(int col = 0; col < matrice[row].length; col++){
                if((col != 0 && row == 0) || (col == 0 && row != 0)){
                    if((matrice[row][0] == encryptedMessageArray[messageIndex]) && (matrice[0][col]) == encryptedMessageArray[messageIndex+1]){
                        message.append(matrice[row][col]);
                        messageIndex += 2;
                    }
                }
            }
        }

        return message.toString();
    }
}
