package main.java.tictactoetomek;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Position getUp(){
        return new Position(row-1, column);
    }

    public Position getDown(){
        return new Position(row+1, column);
    }

    public Position getLeft(){
        return new Position(row, column-1);
    }

    public Position getRight(){
        return new Position(row, column+1);
    }

}
