package SnakeLadder;

public class Application {
    public static void main(String[] args) {
        // Create a new game instance
        Game game = new Game(10, 2); // 10x10 board with 2 players

        // Add players to the game
        game.addPlayer("Alice");
        game.addPlayer("Bob");

        // Add snakes and ladders to the game
        game.addSnake(1, 1, 3, 3);
        game.addLadder(2, 2, 4, 4);

        System.out.println("Players added: Alice and Bob");
        // Start the game
        try {
            game.start();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
