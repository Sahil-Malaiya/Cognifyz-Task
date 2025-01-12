import java.util.Scanner;

public class TicTacToe {

    private static final char EMPTY = '-';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            char[][] board = initializeBoard();
            char currentPlayer = PLAYER_X;
            boolean gameWon = false;
            boolean isDraw = false;

            while (!gameWon && !isDraw) {
                displayBoard(board);
                System.out.println("Player " + currentPlayer + ", it's your turn!");
                int row, col;

                // Get a valid move
                while (true) {
                    System.out.print("Enter row (0, 1, or 2): ");
                    row = scanner.nextInt();
                    System.out.print("Enter column (0, 1, or 2): ");
                    col = scanner.nextInt();

                    if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY) {
                        break;
                    } else {
                        System.out.println("Invalid move. Try again.");
                    }
                }

                // Make the move
                board[row][col] = currentPlayer;

                // Check game status
                gameWon = checkWin(board, currentPlayer);
                if (!gameWon) {
                    isDraw = checkDraw(board);
                    currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                }
            }

            displayBoard(board);
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a draw!");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static char[][] initializeBoard() {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
        return board;
    }

    private static void displayBoard(char[][] board) {
        System.out.println("Current board:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkWin(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    private static boolean checkDraw(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
