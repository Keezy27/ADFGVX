package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageToEncrypt {

    private String messaggeToEncrypt;
    private String regex = "[a-zA-Z0-9 ]+";
    private String[][] matrice;

    public MessageToEncrypt(){

    }

    public void setMessaggeToEncrypt(String messaggeToEncrypt) {
        this.messaggeToEncrypt = messaggeToEncrypt.toUpperCase();
    }

    public String getMessaggeToEncrypt(){
        return this.messaggeToEncrypt;
    }

    public Boolean isMessageOK(){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(getMessaggeToEncrypt());;
        return matcher.matches();
    }
}
