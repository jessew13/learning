// Prompt for this can be found here: https://www.cs.unc.edu/~stotts/COMP210-s21/Java/ufo.html

import java.io.*;
import java.util.*;

public class Main {

    final static int COLUMN_OF_DURATIONS = 3; // TODO this too
    final static int NUM_COLUMNS = 6;  // TODO could want to parse this instead of have it as a constant that needs CLI input or something
    final static String PATH = "C:\\Users\\jesse\\IdeaProjects\\learning\\210JavaPractice\\data\\large.txt";  // TODO make this CLI input

    // remember to go big picture first, don't get bogged down by details

    public static void main(String[] args) throws Exception {

        // call readTxt to get data
        String[][] data = readTxt(PATH);

        // printArray(data);

        // call convertToIntArray(data, COLUMN_OF_DURATIONS)
        int[] durations = convertToIntArray(data, COLUMN_OF_DURATIONS);

        // call maxMinArray to get the row indices of the max and min durations
        int[] maxMinIndices = maxMinArray(durations);

        // print out info for those row indices from matrix
        // could use a loop here but since it's just two parts, nah
        System.out.println("Longest sighting:");
        System.out.println("\tWhen: " + data[maxMinIndices[0]][0] + " " + data[maxMinIndices[0]][1]);
        System.out.println("\tShape: " + data[maxMinIndices[0]][2]);
        System.out.printf("\tWhere: (%.2f, %.2f)", Double.parseDouble(data[maxMinIndices[0]][4]), Double.parseDouble(data[maxMinIndices[0]][5]));
        System.out.println("\nShortest sighting:");
        System.out.println("\tWhen: " + data[maxMinIndices[1]][0] + " " + data[maxMinIndices[1]][1]);
        System.out.println("\tShape: " + data[maxMinIndices[1]][2]);
        System.out.printf("\tWhere: (%.2f, %.2f)", Double.parseDouble(data[maxMinIndices[1]][4]), Double.parseDouble(data[maxMinIndices[1]][5]));


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
        String[][] data = new String[numRows][NUM_COLUMNS];  // TODO parse this, perhaps get first line and num elements and create array off that info

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
        int[] x = new int[data.length];
        for (int i = 0; i < data.length; i++){
            x[i] = Integer.parseInt(data[i][j]);
        }
        return x;
    }

    // might not need this one, we'll see
    public static double[] convertToFloatArray(String[][] data, int j){
        return new double[0];
    }

    // a function that finds the indices of the max and min elements of a numerical array, returns it
    // could actually write two functions with the same name but with different PARAM types here (not return types)

    private static int[] maxMinArray(int[] data){  // TODO test functionality
        // 0th element is max, 1st element is min
        // I don't need the actual max and min for this specific program but track it anyway
        int[] x = new int[2];
        int max = data[0];
        int min = data[0];
        int maxIndex = -1;
        int minIndex = -1;
        for (int i = 1; i < data.length; i++){
            if (data[i] >= max){  // put >= here because the prompt says "in case of ties, report the one that comes later in the program"
                max = data[i];
                maxIndex = i;
            }

            else if (data[i] <= min){
                min = data[i];
                minIndex = i;
            }
        }

        x[0] = maxIndex;
        x[1] = minIndex;
        return x;
    }

    private static void printArray(String[][] data){
        for (String[] datum : data) {  // enhanced for LOL
            for (String s : datum) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
