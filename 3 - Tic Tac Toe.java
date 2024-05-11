package Basics;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class TicTacToe {
    // Track remaining spaces in rows, columns, and diagonals
    static int[] remainingRows = {3, 3, 3};
    static int[] remainingCols = {3, 3, 3};
    static int[] remainingDiagonals = {3, 3}; // Two diagonals
    static final String GREEN = "\u001b[32m";
    static final String RESET = "\u001b[0m"; // Reset to default color
    static final String RED = "\u001b[31m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        initializeBoard(board);

        // Main game loop
        do {
            // Player 1's turn (X)
            System.out.print("Player 1's turn (X): ");
            int position = getPosition(scanner);
            makeMove(board, position, 'X');
            System.out.println();
            printBoard(board);
            System.out.println();

            // Check if player 1 wins
            if (isWinner(board, 'X')) {
                System.out.println(GREEN + "\nPlayer 1 wins!" + RESET);
                break;
            }

            // Check for draw
            if (isBoardFull(board)) {
                System.out.println(RED + "\nIt's a draw!" + RESET);
                break;
            }

            // Player 2's turn (O)
            System.out.print("Player 2's turn (O): ");
            position = getPosition(scanner);
            makeMove(board, position, 'O');
            System.out.println();
            printBoard(board);
            System.out.println();

            // Check if player 2 wins
            if (isWinner(board, 'O')) {
                System.out.println(GREEN + "\nPlayer 2 wins!" + RESET);
                break;
            }

            // Check for draw again
            if (isBoardFull(board)) {
                System.out.println(RED + "\nIt's a draw!" + RESET);
                break;
            }

        } while (true);
    }

    // Get valid position input from the user
    public static int getPosition(Scanner scanner) {
        int position;
        while (true) {
            try {
                position = scanner.nextInt();
                if (position < 1 || position > 9) {
                    System.out.println("Please enter a number between 1 and 9.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
        return position;
    }

    // Check if the board is full (draw)
    public static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false; // If any cell is empty, board is not full
                }
            }
        }
        return true; // All cells are occupied
    }

    // Initialize the board with empty spaces
    public static void initializeBoard(char[][] board) {
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }

    // Make a move on the board
    public static void makeMove(char[][] board, int position, char symbol) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        if (board[row][col] != ' ') {
            System.out.println("Position already taken!");
            return;
        }

        board[row][col] = symbol;
        updateRemainingCounts(row, col);
    }

    // Update remaining counts after a move
    public static void updateRemainingCounts(int row, int col) {
        remainingRows[row]--;
        remainingCols[col]--;
        if (row == col) {
            remainingDiagonals[0]--;
        }
        if (row + col == 2) {
            remainingDiagonals[1]--;
        }
    }

    // Check if a player has won
    public static boolean isWinner(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true; // Check rows
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true; // Check columns
            }
        }
        // Check diagonals
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    // Print the current board
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
