package tictactoe;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private HashSet<String> moves;
    private String difficulty;
    
    public TicTacToe(String difficulty) {
        board = new char[3][3];
        currentPlayer = 'X';
        moves = new HashSet<>();
        this.difficulty = difficulty;
        initializeBoard();
    }

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        moves = new HashSet<>();
        initializeBoard();
    }

    // Initialize the board with empty spaces
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print the current board
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Check if the board is full
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Check for a win
    public boolean checkForWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    // Check the rows for a win
    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    // Check the columns for a win
    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    // Check the diagonals for a win
    private boolean checkDiagonals() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }

    // Check if all three values are the same (and not empty) indicating a win
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    // Change player marks back and forth
    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Make a move at the specified location
    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3) {
            if (col >= 0 && col < 3) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayer;
                    moves.add(row + "," + col);
                    return true;
                }
            }
        }
        return false;
    }

    // Method for the computer to make a move based on difficulty
    public void computerMove() {
        if (difficulty.equals("Easy")) {
            easyMove();
        } else if (difficulty.equals("Medium")) {
            mediumMove();
        } else {
            hardMove();
        }
    }

    // Easy move: Random placement
    private void easyMove() {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (board[row][col] != '-');
        board[row][col] = currentPlayer;
        moves.add(row + "," + col);
        System.out.println("Computer placed " + currentPlayer + " at (" + col + ", " + row + ")");
    }

    // Medium move: Block player if they are about to win, otherwise random
    private void mediumMove() {
        // Check if the computer can block the player
        if (!blockPlayer()) {
            easyMove();
        }
    }

    // Hard move: Impossible to beat (simple AI strategy)
    private void hardMove() {
        // Implement a simple unbeatable strategy
        if (!blockPlayer()) {
            if (!takeCenter()) {
                if (!takeCorner()) {
                    easyMove();
                }
            }
        }
    }

    // Block the player if they are about to win
    private boolean blockPlayer() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = (currentPlayer == 'X') ? 'O' : 'X';
                    if (checkForWin()) {
                        board[i][j] = currentPlayer;
                        moves.add(i + "," + j);
                        System.out.println("Computer placed " + currentPlayer + " at (" + j + ", " + i + ")");
                        return true;
                    }
                    board[i][j] = '-';
                }
            }
        }
        return false;
    }

    // Take the center if available
    private boolean takeCenter() {
        if (board[1][1] == '-') {
            board[1][1] = currentPlayer;
            moves.add("1,1");
            System.out.println("Computer placed " + currentPlayer + " at (1, 1)");
            return true;
        }
        return false;
    }

    // Take a corner if available
    private boolean takeCorner() {
        int[][] corners = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
        for (int[] corner : corners) {
            if (board[corner[0]][corner[1]] == '-') {
                board[corner[0]][corner[1]] = currentPlayer;
                moves.add(corner[0] + "," + corner[1]);
                System.out.println("Computer placed " + currentPlayer + " at (" + corner[1] + ", " + corner[0] + ")");
                return true;
            }
        }
        return false;
    }

    


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String difficulty = "Easy";
        TicTacToe game = new TicTacToe(difficulty);
        game.printBoard();
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("To make a move, first enter the column number (0, 1, or 2) and then the row number (0, 1, or 2).");

        while (true) {
            if (game.currentPlayer == 'X') {
                // Player's turn
                int row, col;
                System.out.println("Player " + game.currentPlayer + ", it's your turn.");
                
                // Input column
                while (true) {
                    System.out.print("Enter the column (0, 1, or 2): ");
                    try {
                        col = scanner.nextInt();
                        if (col >= 0 && col < 3) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a number between 0 and 2.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a number between 0 and 2.");
                        scanner.next(); // Clear the invalid input
                    }
                }

                // Input row
                while (true) {
                    System.out.print("Enter the row (0, 1, or 2): ");
                    try {
                        row = scanner.nextInt();
                        if (row >= 0 && row < 3) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a number between 0 and 2.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a number between 0 and 2.");
                        scanner.next(); // Clear the invalid input
                    }
                }

                if (game.placeMark(row, col)) {
                    game.printBoard();
                    if (game.checkForWin()) {
                        System.out.println("Player " + game.currentPlayer + " wins!");
                        if (difficulty.equals("Easy")) {
                            difficulty = "Medium";
                        } else if (difficulty.equals("Medium")) {
                            difficulty = "Hard";
                        }
                        game = new TicTacToe(difficulty);
                        game.printBoard();
                        System.out.println("Difficulty increased to " + difficulty + "!");
                    } else if (game.isBoardFull()) {
                        System.out.println("The game is a tie!");
                        break;
                    } else {
                        game.changePlayer();
                    }
                } else {
                    System.out.println("This move is not valid. Try again.");
                }
            } else {
                // Computer's turn
                game.computerMove();
                game.printBoard();
                if (game.checkForWin()) {
                    System.out.println("Player " + game.currentPlayer + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    System.out.println("The game is a tie!");
                    break;
                } else {
                    game.changePlayer();
                }
            }
        }
        scanner.close();
    }
}