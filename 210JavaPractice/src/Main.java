// Prompt for this can be found here: https://www.cs.unc.edu/~stotts/COMP210-s21/Java/ufo.html

import java.io.*;
import java.util.*;

public class Main {

    final static int COLUMN_OF_DURATIONS = 3;
    final static int NUM_COLUMNS = 6;
    final static String PATH = "C:\\Users\\jesse\\IdeaProjects\\learning\\210JavaPractice\\data\\mini.txt"; // double backslash to avoid exit things like \t \n

    // remember to go big picture first, don't get bogged down by details

    public static void main(String[] args) throws Exception {

        // call readTxt to get data
        String[][] data = readTxt(PATH);

        printArray(data);

        // call convertToIntArray(data, COLUMN_OF_DURATIONS)

        // call maxMinArray to get the row indices of the max and min durations

        // print out info for those row indices from matrix


    }

    // a function that takes in the data's file path and returns a String matrix of the data
    public static String[][] readTxt(String path) throws Exception{
        File file = new File(PATH);
        String line;
        String delimiter = " ";
        int i = 0;
        int j;

        BufferedReader br = new BufferedReader(new FileReader(file));

        int numRows = Integer.parseInt(br.readLine());
        String[][] data = new String[numRows][];

        while ((line = br.readLine()) != null) {
            j = 0;
            StringTokenizer stObj = new StringTokenizer(line, delimiter);
            while (stObj.hasMoreElements()){
                data[i][j] = (String)stObj.nextElement();
                j++;
            }
            i++;

        }
        return data;
    }

    // a function that converts a column within a String matrix to an array of numerical data, can be int or float
    public static int[] convertToIntArray(String[][] data, int j){
        int[] x = new int[0];
        return x;
    }

    // might not need this one, we'll see
    public static double[] convertToFloatArray(String[][] data, int j){
        double[] x = new double[0];
        return x;
    }

    // a function that finds the indices of the max and min elements of a numerical array, returns it
    // could actually write two functions with the same name but with different PARAM types here (not return types)

    private static int[] maxMinArray(int[] data){
        int[] x = new int[0];
        return x;
    }

    private static void printArray(String[][] data){
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
