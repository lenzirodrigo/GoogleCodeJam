package main.java.tictactoetomek;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem

 Tic-Tac-Toe-Tomek is a game played on a 4 x 4 square board.
 The board starts empty, except that a single 'T' symbol may appear in one of the 16 squares.
 There are two players: X and O.
 They take turns to make moves, with X starting. In each move a player puts her symbol in one of the empty squares.
 Player X's symbol is 'X', and player O's symbol is 'O'.

 After a player's move, if there is a row, column or a diagonal containing 4 of that player's symbols,
 or containing 3 of her symbols and the 'T' symbol, she wins and the game ends.
 Otherwise the game continues with the other player's move.
 If all of the fields are filled with symbols and nobody won, the game ends in a draw.
 See the sample input for examples of various winning positions.

 Given an 4 x 4 board description containing 'X', 'O', 'T' and '.' characters
 (where '.' represents an empty square), describing the current state of a game,
 determine the status of the Tic-Tac-Toe-Tomek game going on.
 The statuses to choose from are:

 "X won" (the game is over, and X won)
 "O won" (the game is over, and O won)
 "Draw" (the game is over, and it ended in a draw)
 "Game has not completed" (the game is not over yet)

 Input

 The first line of the input gives the number of test cases, T. T test cases follow.
 Each test case consists of 4 lines with 4 characters each,
 with each character being 'X', 'O', '.' or 'T' (quotes for clarity only).
 Each test case is followed by an empty line.

 Output

 For each test case, output one line containing
 "Case #x: y", where x is the case number (starting from 1) and y is one of the statuses given above.
 Make sure to get the statuses exactly right.
 When you run your code on the sample input, it should create the sample output exactly,
 including the "Case #1: ", the capital letter "O" rather than the number "0", and so on.


 */
public class TicTacToeTomek {
    private List<Board> boards;

    public TicTacToeTomek() {
        boards = new ArrayList<Board>();
    }

    public void createBoards(String file){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int boardCant = Integer.parseInt(br.readLine());
            for(int b = 0; b < boardCant; b++){
                Board board = new Board();
                for(int row = 0; row < 4; row++){
                    String s = br.readLine();
                    for(int column = 0; column < 4; column++){
                        board.setStatusPos(new Position(row, column), String.valueOf(s.charAt(column)));
                    }
                }
                boards.add(board);
                br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void solveBoards(String outFile){
        try {
            FileWriter fstream = null;
            fstream = new FileWriter(outFile);
            BufferedWriter out = new BufferedWriter(fstream);
            int boardNumber = 1;

            for (Board b : boards) {
                out.write("Case #"+boardNumber+": " + b.gameStatus() + "\n");
                boardNumber++;
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
