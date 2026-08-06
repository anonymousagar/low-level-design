package SnakeLadder;

public class Cell {
    private int row;
    private int col;
    private Cell jumpToCell; // If there's a snake or ladder, this will be the position to jump to. Otherwise, it will be the same as position.

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.jumpToCell = null; // Assuming a 10x10 board
    }

    public void setJumpToCell(Cell jumpToCell) {
        this.jumpToCell = jumpToCell;
        return;
    }

    public Cell getJumpToCell() {
        return jumpToCell;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
