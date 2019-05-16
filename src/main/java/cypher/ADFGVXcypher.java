package cypher;

import utils.ArrayTools;

public class ADFGVXcypher {

    private String key;
    private String message;

    public ADFGVXcypher(String key, String message){
        this.key = key;
        this.message = message;
    }

    private String getKey() {
        return key;
    }

    private String getMessageToEncrypt() {
        return message;
    }

    public String encryptMessage(char[][] matrice){
        return getCryptedMessage(genMatriceWithKeyAlpha(genMatriceWithKey(intermediateEncrypt(matrice))));
    }

    private String intermediateEncrypt(char[][] matrice){
        StringBuilder interEncryptMessage = new StringBuilder();
        char[] messageArray = getMessageToEncrypt().toCharArray();

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

    private char[][] genMatriceWithKey(String intermediateEncrypt){
        int nbRow = ArrayTools.getNumberOfRow(getKey(), intermediateEncrypt);
        char[][] interCryptedWithKey = new char[getKey().length()][nbRow];
        char[] keyArray = getKey().toCharArray();
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

    private char[][] genMatriceWithKeyAlpha(char[][] interGenMatric){
        char[][] encryptedWithKey = new char[getKey().length()][interGenMatric[0].length];
        char[] orderedKeyArray = ArrayTools.getOrderKeyArray(key.toCharArray());

        for(int row = 0; row < encryptedWithKey.length; row++){
            for(int col = 0; col < interGenMatric[row].length; col++){
                int indexOfLetter = ArrayTools.convertToArrayList(getKey().toCharArray()).indexOf(orderedKeyArray[col]);

                if(row == 0){
                    encryptedWithKey[row][col] = orderedKeyArray[col];
                }else{
                    encryptedWithKey[row][col] = interGenMatric[row][indexOfLetter];
                }
            }
        }

        return encryptedWithKey;
    }

    private String getCryptedMessage(char[][] matriceWithKeyAlpha){
        StringBuilder cryptedMessage = new StringBuilder();

        for(int row = 1; row < matriceWithKeyAlpha.length; row++){
            for(int col = 0; col < matriceWithKeyAlpha[row].length; col++){
                cryptedMessage.append(matriceWithKeyAlpha[row][col]);
            }
        }

        return cryptedMessage.toString();
    }
}
