package main;

import utils.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        /*
        //  GENERATE MATRICE
        Matrice matrice = new Matrice();
        matrice.initMatric();
        matrice.print();
        FileCreator.createFile("matrice", matrice.getMatriceContent());

        //  MESSAGE TO CRYPT
        MessageToEncrypt clearMessage = new MessageToEncrypt();
        System.out.println("Entrer le message a encrypter [a-z A-Z 0-9]: ");
        clearMessage.setMessaggeToEncrypt(scanner.nextLine());
        while (!clearMessage.isMessageOK()){
            System.out.println("Entrer le message a encrypter [a-z A-Z 0-9] et espace autorise : ");
            clearMessage.setMessaggeToEncrypt(scanner.nextLine());
        }

        //  ASK FOR A KEY
        Key key = new Key();
        System.out.println("Entrez la clé (caracteres distinct uniquement) : ");
        key.setKey(scanner.nextLine());
        while (!key.isKeyOk()){
            System.out.println("Entrez la clé (caracteres distinct uniquement) : ");
            key.setKey(scanner.nextLine());
        }
        FileCreator.createFile("key", key.getKey());


        //  ENCRYPT
        ADFGVXcypher xcypher = new ADFGVXcypher();
        FileCreator.createFile("encrypted", xcypher.getCryptedMessage(xcypher.genMatriceWithKeyAlpha(key.getKey(),xcypher.genMatriceWithKey(key.getKey(),xcypher.intermediateEncrypt(clearMessage.getMessaggeToEncrypt(),matrice.getMatrice())))));
        */

        /*-------------------------------------------------------------------------------------------------------*/

        //  DECRYPT
        if(FileCreator.checkFilesOk()){
            System.out.println("il manque un des fichier requis (encrypted, key et/ou matrice.txt dans le dossier ADFGVX");
        }else{
            System.out.println("OK");
        }

        System.out.println("Encrypted : " +FileCreator.readFile("encrypted"));
        System.out.println("Matrice : " +FileCreator.readFile("matrice"));
        ADFGVXcypher xcypher = new ADFGVXcypher();
        xcypher.genMatriceWithKeyAlpha(FileCreator.readFile("key"),FileCreator.readFile("encrypted"));

    }
}
