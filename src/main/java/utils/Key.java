package utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Key {
    private String key;
    private String regex = "[a-zA-Z]+";

    public void setKey(String key) {
        this.key = key.toUpperCase();
    }

    public String getKey(){
        return this.key;
    }

    public Boolean isKeyOk(){
        return isKeyPatternOK(this.getKey()) && hadUniqueValOnly(this.getKey());
    }

    private Boolean isKeyPatternOK(String key){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(key);
        return matcher.matches();
    }

    private Boolean hadUniqueValOnly(String key){
        boolean hasUniqueVal = true;
        char[] keyTab = key.toUpperCase().toCharArray();
        ArrayList<Character> keyArray = new ArrayList<Character>();

        int i = 0;
        while((i < keyTab.length) && hasUniqueVal){
            if(keyArray.contains(keyTab[i])){
                hasUniqueVal = false;
            }else{
                keyArray.add(keyTab[i]);
            }
            i++;
        }
        return hasUniqueVal;
    }
}
