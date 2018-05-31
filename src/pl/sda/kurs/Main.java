package pl.sda.kurs;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        int level = 0;
        int no = 0;

        while ((level != 1) && (level != 2) && (level != 3)){

            System.out.println("Choose the level of difficulty:");
            System.out.println("EASY - push 1");
            System.out.println("MEDIUM - push 2");
            System.out.println("HARD - push 3");
            level = sc.nextInt();

            if (level == 1){
                no = 50;
            }
            if (level == 2){
                no = 75;
            }
            if (level == 3){
                no = 100;
            }
            if ((level != 1) && (level != 2) && (level != 3)){
                System.out.println("Wrong choice");
            }
        }

        Random rd = new Random();
        int secretNo = rd.nextInt(no)+1;

        char[] looser = {' ', 'L', 'O', 'O', 'S', 'E', 'R'};

        int countdown = 0;

        int guessNo = 0;

        System.out.println("Guess number between 1 and " + no);

        while (guessNo != secretNo){

            System.out.println("Give a number:");
            guessNo = sc.nextInt();

            if (guessNo == secretNo){
                System.out.println("You are the winner");
                return;
            }

            if (guessNo != secretNo){
                countdown++;
            }

            for (int i = 1; i <= countdown; i++){
                System.out.print(looser[i]);
            }
            System.out.println();

            if (countdown == looser.length-1){
                System.out.println("You are looser");
                return;
            }

            if (guessNo > secretNo){
                System.out.println("Mysterious number is smaller");
                System.out.println("Try again");
            }

            if (guessNo < secretNo){
                System.out.println("Mysterious number is bigger");
                System.out.println("Try again");
            }
        }
    }
}
