package ticTacToe;

import java.util.Scanner;

public class TicTacToe {

    static boolean winnerX=false;
    static boolean winnerO=false;
    static Scanner input = new Scanner(System.in);
    static char [][] userMatrix = new char [3][3];
    static char turn = 'X';
    static int emptyCounter;


    public static void main(String[] args) {

        //Print grid before making a move
        createMatrix();
        printGrid();

        //Prompt the user to make a move
        do{
            makeAMove();
            whoWins();
            emptyCellCounter();

            if(turn=='X'){
                turn='O';
            }else{
                turn='X';
            }

        }while(!winnerX && !winnerO && emptyCounter!=0);

        //Print result
        printResult();
    }


    //Creates grid as a matrix
    static char[][] createMatrix( ){

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                userMatrix[i][j]=' ';
            }
        }
        return userMatrix;
    }


    //Prints matrix as grid
    static void printGrid(){

        System.out.println("---------");

        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.print(userMatrix[i][j] + " ");
            }
            System.out.println("|");
            System.out.println();
        }

        System.out.println("---------");
    }


    //Count empty cells
    static void emptyCellCounter(){

        emptyCounter=0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(userMatrix[i][j]==' '){
                    emptyCounter++;
                }
            }
        }
    }


    //Prompt user to make a move
    static void makeAMove(){

        boolean flag= true;

        do {
            System.out.println("Enter the coordinates: ");

            if (!input.hasNextInt()) {
                do{
                    System.out.println("You should enter numbers!");
                    input.next();
                }while (!input.hasNextInt());
            }

            int numberOne = input.nextInt();
            int numberTwo = input.nextInt();

            if (numberOne < 1 || numberTwo < 1 || numberOne > 3 || numberTwo > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (userMatrix[numberOne - 1][numberTwo - 1] == 'X' || userMatrix[numberOne - 1][numberTwo - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                userMatrix[numberOne - 1][numberTwo - 1] = turn;
                flag = false;
                printGrid();
            }

        } while (flag) ;

    }


    //Check who wins
    static void whoWins(){

        int storeResult=0;

        for (int i =0;i<8;i++){
            switch (i){
                case 0:
                    storeResult=userMatrix[0][0]+userMatrix[0][1]+userMatrix[0][2];
                    break;
                case 1:
                    storeResult=userMatrix[1][0]+userMatrix[1][1]+userMatrix[1][2];
                    break;
                case 2:
                    storeResult=userMatrix[2][0]+userMatrix[2][1]+userMatrix[2][2];
                    break;
                case 3:
                    storeResult=userMatrix[0][0]+userMatrix[1][0]+userMatrix[2][0];
                    break;
                case 4:
                    storeResult=userMatrix[0][1]+userMatrix[1][1]+userMatrix[2][1];
                    break;
                case 5:
                    storeResult=userMatrix[0][2]+userMatrix[1][2]+userMatrix[2][2];
                    break;
                case 6:
                    storeResult=userMatrix[0][0]+userMatrix[1][1]+userMatrix[2][2];
                    break;
                case 7:
                    storeResult=userMatrix[0][2]+userMatrix[1][1]+userMatrix[2][0];
                    break;
            }

            if(storeResult==237) {
                winnerO = true;
            } else if(storeResult==264){
                winnerX=true;
            }
        }
    }


    //Print results
    static void printResult(){
        if(winnerX){
            System.out.println("X wins");
        }else if(winnerO){
            System.out.println("O wins");
        }else{
            System.out.println("Draw");
        }
    }


}
