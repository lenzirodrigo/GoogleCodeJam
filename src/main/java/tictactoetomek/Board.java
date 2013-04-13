package main.java.tictactoetomek;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<String>> board;
    private String X = "X won";
    private String O = "O won";
    private String DRAW = "Draw";
    private String NOTOVER = "Game has not completed";

    private boolean hasMovements = false;

    public Board() {
        board = new ArrayList<ArrayList<String>>(4);
        for (int i = 0 ; i < 4; i++){
            ArrayList<String> column = new ArrayList<String>(4);
            for (int j = 0; j < 4; j++)
                column.add(null);
            board.add(column);
        }
    }

    public void loadBoard(){

    }

    public String getStatusPos(Position pos) {
        return board.get(pos.getRow()).get(pos.getColumn());
    }

    public void setStatusPos(Position pos, String status){
        board.get(pos.getRow()).set(pos.getColumn(), status);
    }

    private ArrayList<Position> getPosInRow(int row) {
        ArrayList<Position> posInRow = new ArrayList<Position>();
        for (int column = 0; column < 4; column++)
            posInRow.add(new Position(row, column));
        return posInRow;
    }

    private ArrayList<Position> getPosInColumn(int column) {
        ArrayList<Position> posInColumn = new ArrayList<Position>();
        for (int row = 0; row < 4; row++)
            posInColumn.add(new Position(row, column));
        return posInColumn;
    }

    private ArrayList<Position> getDiagonal() {
        ArrayList<Position> diagonal = new ArrayList<Position>();
        for (int i = 0; i < 4; i++)
            diagonal.add(new Position(i, i));
        return diagonal;
    }

    private ArrayList<Position> getReverseDiagonal() {
        ArrayList<Position> diagonal = new ArrayList<Position>();
        for (int i = 0; i < 4; i++)
            diagonal.add(new Position(i, 3-i));
        return diagonal;
    }



    public String gameStatus() {
        String result = null;
        result = checkRows();
        if (result != null) return result;
        result = checkColumn();
        if (result != null) return result;
        result = checkDiagonal();
        if (result != null) return result;
        result = checkReverseDiagonal();
        if (result != null) return result;
        if (hasMovements) return NOTOVER;
        else return DRAW;

    }

    private String checkReverseDiagonal() {
        ArrayList<Position> posInReverseDiagonal = getReverseDiagonal();
        int x = 0;
        int o = 0;
        int t = 0;
        for (Position pos : posInReverseDiagonal){
            String status = getStatusPos(pos);
            if (status.equals("X")) x++;
            else if (status.equals("O")) o++;
            else if (status.equals("T")) t++;
            else if (status.equals(".")) hasMovements = true;
        }
        if (x+t == 4) return X;
        else if (o+t == 4) return O;
        return null;

    }

    private String checkDiagonal() {
        ArrayList<Position> posInDiagonal = getDiagonal();
        int x = 0;
        int o = 0;
        int t = 0;
        for (Position pos : posInDiagonal){
            String status = getStatusPos(pos);
            if (status.equals("X")) x++;
            else if (status.equals("O")) o++;
            else if (status.equals("T")) t++;
            else if (status.equals(".")) hasMovements = true;
        }
        if (x+t == 4) return X;
        else if (o+t == 4) return O;
        return null;
    }

    private String checkColumn() {
        for (int column = 0; column < 4; column++){
            ArrayList<Position> posInColumn = getPosInColumn(column);
            int x = 0;
            int o = 0;
            int t = 0;
            for (Position pos : posInColumn){
                String status = getStatusPos(pos);
                if (status.equals("X")) x++;
                else if (status.equals("O")) o++;
                else if (status.equals("T")) t++;
                else if (status.equals(".")) hasMovements = true;
            }
            if (x+t == 4) return X;
            else if (o+t == 4) return O;
        }
        return null;

    }

    private String checkRows() {
        for (int row = 0; row < 4; row++){
            ArrayList<Position> posInRow = getPosInRow(row);
            int x = 0;
            int o = 0;
            int t = 0;
            for (Position pos : posInRow){
                String status = getStatusPos(pos);
                if (status.equals("X")) x++;
                else if (status.equals("O")) o++;
                else if (status.equals("T")) t++;
                else if (status.equals(".")) hasMovements = true;
            }
            if (x+t == 4) return X;
            else if (o+t == 4) return O;
        }
        return null;
    }

}
