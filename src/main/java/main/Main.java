package main;

import cypher.ADFGVXcypher;
import cypher.ADFGVXdecipher;
import utils.FileCreator;
import utils.Key;
import utils.Matrice;
import utils.Message;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //  GENERATE MATRICE
        Matrice matrice = new Matrice();
        matrice.initMatric();
        matrice.print();
        FileCreator.createFile("matrice", matrice.getMatriceContent());

        //  MESSAGE TO ENCRYPT
        Message clearMessage = new Message();
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
        ADFGVXcypher xcypher = new ADFGVXcypher(key.getKey(),clearMessage.getMessagge());
        FileCreator.createFile("encrypted", xcypher.encryptMessage(matrice.getMatrice()));


        /*-------------------------------------------------------------------------------------------------------*/

        //  DECRYPT
        if(FileCreator.checkFilesOk()){
            System.out.println("il manque un des fichier requis (encrypted, key et/ou matrice.txt dans le dossier ADFGVX");
        }else{
            System.out.println("OK");
        }

        System.out.println("Encrypted : " +FileCreator.readFile("encrypted"));
        System.out.println("Matrice : " +FileCreator.readFile("matrice"));
        System.out.println("Key : " +FileCreator.readFile("key"));

        Key keyForDecryption = new Key(FileCreator.readFile("key"));
        Message messageToDecrypt = new Message(FileCreator.readFile("encrypted"));

        ADFGVXdecipher decipher = new ADFGVXdecipher(keyForDecryption.getKey(),messageToDecrypt.getMessagge());
        Matrice matriceDecipher = new Matrice();
        matriceDecipher.initMatric(FileCreator.readFile("matrice"));
        FileCreator.createFile("decrypted", decipher.getMessage());

    }
}
