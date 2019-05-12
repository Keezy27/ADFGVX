package main;

import utils.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*


        Matrice ini = new Matrice();
        ini.initMatric();
        ini.print();

        MessageToEncrypt clearMessage = new MessageToEncrypt();

        System.out.println("Entrer le message a encrypter [a-z A-Z 0-9]: ");
        clearMessage.setMessaggeToEncrypt(scanner.nextLine());
        while (!clearMessage.isMessageOK()){
            System.out.println("Entrer le message a encrypter [a-z A-Z 0-9] et espace autorise : ");
            clearMessage.setMessaggeToEncrypt(scanner.nextLine());
        }
        Encryptor encryptor = new Encryptor();

        FileCreator.createFile("encrypted", encryptor.encryptedMessage(clearMessage.getMessaggeToEncrypt(), ini.getMatrice()));
        FileCreator.createFile("matrice", ini.getMatriceContent());



        FileCreator.createFile("key", key.getKey());

        */
        Scanner scanner = new Scanner(System.in);

        //initialise Matrice to encode
        Matrice ini = new Matrice();
        ini.initMatric();
        ini.print();
        FileCreator.createFile("matrice", ini.getMatriceContent());


        //ask message to encrypt
        MessageToEncrypt clearMessage = new MessageToEncrypt();
        System.out.println("Entrer le message a encrypter [a-z A-Z 0-9]: ");
        clearMessage.setMessaggeToEncrypt(scanner.nextLine());
        while (!clearMessage.isMessageOK()){
            System.out.println("Entrer le message a encrypter [a-z A-Z 0-9] et espace autorise : ");
            clearMessage.setMessaggeToEncrypt(scanner.nextLine());
        }

        //ask key
        Key key = new Key();

        System.out.println("Entrez la clé (caracteres distinct uniquement) : ");
        key.setKey(scanner.nextLine());
        while (!key.isKeyOk()){
            System.out.println("Entrez la clé (caracteres distinct uniquement) : ");
            key.setKey(scanner.nextLine());
        }
        FileCreator.createFile("key", key.getKey());

        //1st encryption with initial Matrice
        Encryptor encryptor = new Encryptor();
        String intEncrypt = encryptor.intermediateEncryptedMessage(clearMessage.getMessaggeToEncrypt(),ini.getMatrice());


        Permutator permutator = new Permutator(key.getKey(),intEncrypt);
        permutator.generateUnorderedMatrice();
        permutator.generateOrderedMatrcice();
        permutator.print();
        FileCreator.createFile("encrypted",encryptor.finalEncryption(permutator.getOrderedMatrice()));
    }
}
