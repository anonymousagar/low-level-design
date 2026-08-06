package SnakeLadder;

public class Player {
    private String name;
    private Cell cell;

    public Player(String name) {
        this.name = name;
        this.cell = new Cell(0,0); // Starting position
    }

    public String getName() {
        return name;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        if(cell.getJumpToCell() != null) {
            this.setCell(cell.getJumpToCell());
        } else {
            this.cell = cell;
        }
    }
}
