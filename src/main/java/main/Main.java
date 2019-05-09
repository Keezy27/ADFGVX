package main;

import utils.InitTable;
import utils.MessageToEncrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InitTable ini = new InitTable();
        ini.initDimTable();
        ini.print();

        MessageToEncrypt clearMessage = new MessageToEncrypt();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer le message a encrypter [a-z A-Z 0-9]: ");
        clearMessage.setMessaggeToEncrypt(scanner.nextLine());
        while (!clearMessage.isMessageOK()){
            System.out.println("Entrer le message a encrypter [a-z A-Z 0-9] et espace autorise : ");
            clearMessage.setMessaggeToEncrypt(scanner.nextLine());
        }

    }
}
