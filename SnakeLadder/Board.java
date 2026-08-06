package SnakeLadder;

public class Board {
    Cell[][] cells = new Cell[10][10];

    public Board(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }
}
