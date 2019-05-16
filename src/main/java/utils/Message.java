package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Message {

    private String message;
    private String regex = "[a-zA-Z0-9 ]+";

    public Message(){
    }

    public Message(String message){
        this.message = message;
    }

    public void setMessaggeToEncrypt(String messaggeToEncrypt) {
        this.message = messaggeToEncrypt.toUpperCase();
    }

    public String getMessagge(){
        return this.message;
    }

    public Boolean isMessageOK(){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.getMessagge());;
        return matcher.matches();
    }
}
