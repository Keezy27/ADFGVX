package utils;


import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Random;

public class Matrice {

    private Character[][] myMatrice = new Character[7][7];
    private ArrayList<Character> alphaChar;
    int rangeRandom;
    Random randomGenerator;

    public Matrice(){
        this.randomGenerator = new Random();
        this.rangeRandom = 36;

        this.alphaChar = new ArrayList<Character>();
        this.alphaChar.add('A');
        this.alphaChar.add('B');
        this.alphaChar.add('C');
        this.alphaChar.add('D');
        this.alphaChar.add('E');
        this.alphaChar.add('F');
        this.alphaChar.add('G');
        this.alphaChar.add('H');
        this.alphaChar.add('I');
        this.alphaChar.add('J');
        this.alphaChar.add('K');
        this.alphaChar.add('L');
        this.alphaChar.add('M');
        this.alphaChar.add('N');
        this.alphaChar.add('O');
        this.alphaChar.add('P');
        this.alphaChar.add('Q');
        this.alphaChar.add('R');
        this.alphaChar.add('S');
        this.alphaChar.add('T');
        this.alphaChar.add('U');
        this.alphaChar.add('V');
        this.alphaChar.add('W');
        this.alphaChar.add('X');
        this.alphaChar.add('Y');
        this.alphaChar.add('Z');
        this.alphaChar.add('0');
        this.alphaChar.add('1');
        this.alphaChar.add('2');
        this.alphaChar.add('3');
        this.alphaChar.add('4');
        this.alphaChar.add('5');
        this.alphaChar.add('6');
        this.alphaChar.add('7');
        this.alphaChar.add('8');
        this.alphaChar.add('9');
    }

    public void initMatric(){

        for(int i=0; i<7; i++){
            for(int j=0; j<7;j++){
                //dimTable.add(i, new ArrayList<String>());

                if((i == 0) && (j == 0)){
                    myMatrice[i][j] = ' '; //= StringUtils.center(" ", 5);
                } else if((i == 0 && j == 1) || (j == 0 && i == 1)){
                    myMatrice[i][j] = 'A'; //StringUtils.center("A",5);
                } else if ((i == 2 && j == 0) || (j == 2 && i == 0)) {
                    myMatrice[i][j] = 'D'; //StringUtils.center("D",5);
                } else if ((i == 3 && j == 0) || (j == 3 && i == 0)) {
                    myMatrice[i][j] = 'F'; //StringUtils.center("F",5);
                } else if ((i == 4 && j == 0) || (j == 4 && i == 0)) {
                    myMatrice[i][j] = 'G'; //StringUtils.center("G",5);
                } else if ((i == 5 && j == 0) || (j == 5 && i == 0)) {
                    myMatrice[i][j] = 'V';//StringUtils.center("V",5);
                } else if ((i == 6 && j == 0) || (j == 6 && i == 0)) {
                    myMatrice[i][j] = 'X';//StringUtils.center("X", 5);
                } else {
                    myMatrice[i][j] = getChar();//StringUtils.center(getChar(), 5);
                }
            }
        }
    }

    private Character getChar(){
        int randomInt = randomGenerator.nextInt(this.rangeRandom);
        this.rangeRandom--;
        Character charReturn = this.alphaChar.get(randomInt);
        this.alphaChar.remove(randomInt);
        return charReturn;
    }

    public void print() {

        for(int i = 0; i < myMatrice.length; i++){
            for(int j = 0; j < myMatrice.length; j++){
                System.out.print("| " + myMatrice[i][j] + " |");
                if( j == (myMatrice.length -1)){
                    System.out.println("\n---------------------------------");
                    System.out.println();
                }
            }
        }
    }

    public Character[][] getMatrice(){
        return this.myMatrice;
    }


    public String getMatriceContent(){
        StringBuilder matriceContent = new StringBuilder();

        for (int i = 1; i < myMatrice.length; i++){
            for (int j = 1; j < myMatrice.length; j++){
                matriceContent.append(myMatrice[j][i]);
            }
        }

        return matriceContent.toString();
    }
}
