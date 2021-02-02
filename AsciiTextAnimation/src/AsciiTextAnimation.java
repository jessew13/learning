import java.util.*;

// Thread.sleep(milliseconds);

public class AsciiTextAnimation {

    static int column;
    final static int VERTICAL_LENGTH = 5;
    final static int HORIZONTAL_WIDTH = 4;
    final static int DELAY = 100;  // in milliseconds
    final static int NUM_SPACES = 2;

    public static void main(String[] args){
        // Create new scanner for getting input as to what needs to be encoded in ASCII
        Scanner input = new Scanner(System.in);

        // Ask for input
        System.out.println("What would you like encoded in ASCII?");
        String original = input.next();

        // Determine number of chars/columns needed (columns = 6 * numChars - 2)
        int numChars = original.length();

        // Create matrix, TODO initialize with all spaces
        String[][] matrix = new String[VERTICAL_LENGTH][(HORIZONTAL_WIDTH + NUM_SPACES) * numChars - NUM_SPACES];  // 6, representing horizontal width and numSpaces, could be a constant, or make it (4+numSpaces) * numChars - numSpaces
        fillMatrixWithSpaces(matrix);

        // Iterate through original
        for (int c = 0; c < original.length(); c++){
            char ch = original.charAt(c);
            drawChar(ch, matrix, c);
        }
    }

    private static void drawChar(char ch, String[][] matrix, int numChar){  // TODO remember to 0-index numChar
        column = 6 * numChar;
        switch (ch){
            case 'A': ;
            case 'B':
                for (int i = 0; i < VERTICAL_LENGTH; i++){
                    matrix[i][column] = "|";
                    displayMatrix(matrix);
                    pause();
                }
                for (int i = 1; i < 3; i++){
                    matrix[0][column + i] = "-";
                    matrix[2][column + i] = "-";
                    matrix[4][column + i] = "-";
                    displayMatrix(matrix);
                    pause();
                }

                matrix[0][column + 3] = "\\";
                matrix[3][column + 3] = "\\";
                matrix[1][column + 3] = "/";
                matrix[4][column + 3] = "/";
                displayMatrix(matrix);
                pause();

            case 'C': ;
            case 'D': ;
            case 'H':
                for (int i = 0; i < VERTICAL_LENGTH; i++){
                    matrix[i][column] = "|";
                    matrix[i][column + 3] = "|";
                    displayMatrix(matrix);
                    pause();
            }
                matrix[2][column + 1] = "-";
                displayMatrix(matrix);
                pause();
                matrix[2][column + 2] = "-";
                displayMatrix(matrix);
                pause();
            case 'Y': ;
        }
    }

    private static void fillMatrixWithSpaces(String[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = " ";
            }
        }
    }

    private static void pause(){
        try{
            Thread.sleep(DELAY);
        } catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

    private static void displayMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            System.out.println();  // TODO can make this not happen for i = 0 but for all other i
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
            }
        }
    }
}
