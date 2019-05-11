package main;

import utils.Encryptor;
import utils.FileCreator;
import utils.Matrice;
import utils.MessageToEncrypt;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Matrice ini = new Matrice();
        ini.initMatric();
        ini.print();

        MessageToEncrypt clearMessage = new MessageToEncrypt();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer le message a encrypter [a-z A-Z 0-9]: ");
        clearMessage.setMessaggeToEncrypt(scanner.nextLine());
        while (!clearMessage.isMessageOK()){
            System.out.println("Entrer le message a encrypter [a-z A-Z 0-9] et espace autorise : ");
            clearMessage.setMessaggeToEncrypt(scanner.nextLine());
        }
        Encryptor encryptor = new Encryptor();

        FileCreator.createFile("encrypted", encryptor.encryptedMessage(clearMessage.getMessaggeToEncrypt(), ini.getMatrice()));
        FileCreator.createFile("matrice", ini.getMatriceContent());

    }
}
