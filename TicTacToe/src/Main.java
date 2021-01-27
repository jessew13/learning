import java.util.*;

public class Main {

    static String[] chars = {"   ", " X ", " O "};

    public static void main(String[] args){
        ticTacToe();
    }

    public static void ticTacToe() {
        Scanner input = new Scanner(System.in);
        int[][] board = new int[3][3];
        int numTurns = 1;  // count number of turns to figure out whose turn it is
        String playerName = "";
        int i = -1;
        int j = -1;
        displayTTT(board);
        while (true) {
            playerName = numTurns % 2 == 1 ? "X" : "O";  // if numTurns is odd, it's Player X's turn; otherwise, it's Player O's turn
            System.out.println("Enter a row (0, 1, or 2) and column (0, 1, or 2) for player " + playerName);
            i = input.nextInt();  // input the row for the token
            j = input.nextInt();  // input the column for the token
            if (board[i][j] != 0) {  // if the chosen space is not empty, restart the loop
                System.out.println("You cannot place a token on this space!");
                continue;
            }
            board[i][j] = playerName == "X" ? 1 : 2;  // if playerName is X, put a 1 in the space; else, put a 2 there
            displayTTT(board);  // display the board

            if (numTurns >= 5 && checkWin(board, i, j)) {
                System.out.println("Player " + playerName + " won.");
                break;
            }
            numTurns++;  // increment numTurns by 1

            // draw condition
            if (numTurns == 10) {
                System.out.println("Draw");
                break;
            }
        }
    }


    public static boolean checkWin(int[][] board, int i, int j) {
        // checking only the row, column, and diagonal (if applicable) of the filled space on the board

        // check the row of the last space for a win
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
            return true;

            // check the column of the last space
        } else if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
            return true;

            // then check diags, probably a way to make this more efficient by checking if [i][j] is on either diagonal, add this as an && statement
        } else if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {  // not sure about necessity of parentheses
            return true;
        }
        return false;
    }


    public static void displayTTT(int[][] board) {
        int i = 0;
        while (i < 4) {
            System.out.println("-------------");
            if (i < 3) {
                System.out.println("|" + chars[board[i][0]] + "|" + chars[board[i][1]] + "|" + chars[board[i][2]] + "|");  // printing out the stuff
            }
            i++;
        }
    }
}
