package SnakeLadder;

import java.util.ArrayDeque;

public class Game {
    private Board board;
    private int numPlayers;
    private ArrayDeque<Player> players;

    public Game(int boardSize, int numPlayers) {
        initializeGame(new Board(boardSize), numPlayers);
    }

    private void initializeGame(Board board, int numPlayers) {
        this.board = board;
        this.numPlayers = numPlayers;
        this.players = new ArrayDeque<>();
    }

    public void addPlayer(String name) {
        if(players.size() >= numPlayers) {
            throw new IllegalStateException("Maximum number of players reached.");
        }
        players.offer(new Player(name));
    }

    public void start() throws InterruptedException {
        // Game loop logic here
        while (!isGameOver()) {
            Thread.sleep(200);
            Player currentPlayer = players.poll();
            int diceRoll = rollDice();
            movePlayer(currentPlayer, diceRoll);
            System.out.println(currentPlayer.getName() + " rolled a " + diceRoll + " and moved to cell (" + currentPlayer.getCell().getRow() + ", " + currentPlayer.getCell().getCol() + ")");
            if (!isGameOver()) {
                players.offer(currentPlayer);
            }   
        }
    }

    private int rollDice() {
        return (int) (Math.random() * 6) + 1; // Random number between 1 and 6
    }

    private void movePlayer(Player player, int diceRoll) {
        // Logic to move the player based on dice roll and handle snakes/ladders

        Cell currentCell = player.getCell();
        var currentCellRow = currentCell.getRow();
        var currentCellCol = currentCell.getCol();


        int newPosition = (currentCellRow * 10 + currentCellCol) + diceRoll;
        if (newPosition > 100) {
            //Player cannot move beyond the last cell
            return;
        }
        int newRow = (newPosition - 1) / 10;
        int newCol = (newPosition - 1) % 10;
        player.setCell(board.cells[newRow][newCol]);
    }

    private boolean isGameOver() {
        // Logic to determine if the game is over (e.g., a player has reached the last cell)
        for (Player player : players) {
            //System.out.println(player.getName() + " is at cell (" + player.getCell().getRow() + ", " + player.getCell().getCol() + ")");
            if(player.getCell().getRow() == 9 && player.getCell().getCol() == 9) {
                System.out.println(player.getName() + " wins!");
                return true;
            }
        }
        return false;
    }

    public void addSnake(int startRow, int startCol, int endRow, int endCol) {
        Cell startCell = board.cells[startRow][startCol];
        Cell endCell = board.cells[endRow][endCol];
        startCell.setJumpToCell(endCell);
    }

    public void addLadder(int startRow, int startCol, int endRow, int endCol) {
        Cell startCell = board.cells[startRow][startCol];
        Cell endCell = board.cells[endRow][endCol];
        startCell.setJumpToCell(endCell);
    }

}
