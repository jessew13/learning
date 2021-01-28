// Prompt for this can be found here: https://www.cs.unc.edu/~stotts/COMP210-s21/Java/ufo.html
// I THINK THIS IS NOW FULLY FUNCTIONAL!!! - me at 4:00 am after working on the rest of this since like 2:00 am
// time for mini.txt (5 entries): 0.031 s
// time for medium.txt (500 entries): 0.051 s
// time for large.txt (50000 entries): 0.23 s

import java.io.*;
import java.util.*;

public class Main {

    final static int COLUMN_OF_DURATIONS = 3; // TODO this too
    final static int NUM_COLUMNS = 6;  // TODO could want to parse this instead of have it as a constant that needs CLI input or something
    final static String PATH = "C:\\Users\\jesse\\IdeaProjects\\learning\\210JavaPractice\\data\\large.txt";  // TODO make this CLI input
    final static int COLUMN_SHAPE = 2;
    final static int COLUMN_LATITUDE = 4;
    final static int COLUMN_LONGITUDE = 5;

    // remember to go big picture first, don't get bogged down by details

    public static void main(String[] args) throws Exception {
        // start timer
        double start = System.currentTimeMillis();

        // call readTxt to get data
        String[][] data = readTxt(PATH);

        // printMatrix(data);

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
        System.out.printf("\tWhere: (%.2f, %.2f)\n", Double.parseDouble(data[maxMinIndices[1]][4]), Double.parseDouble(data[maxMinIndices[1]][5]));

        // call dict
        Hashtable<String, double[]> dictionary = dict(data);
        for (Map.Entry<String, double[]> e: dictionary.entrySet()){
//            System.out.println("String: " + e.getKey() + " Total: " + e.getValue()[0]);
            System.out.println("Averages for " + e.getKey() + ":");
            double[] x = e.getValue();
            System.out.printf("\tDuration: %.2f\n", (x[1] / (int)(x[0])));
            System.out.printf("\tLocation: (%.2f, %.2f)\n", (x[2] / (int)(x[0])), (x[3] / (int)(x[0])));
        }

        // end timer
        double end = System.currentTimeMillis();
        System.out.println("Processing time: " + (end - start) / 1000 + " seconds.");


    }

    // a function that takes in the data's file path and returns a String matrix of the data
    public static String[][] readTxt(String path) throws Exception{
        File file = new File(path);
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
    public static double[] convertToDoubleArray(String[][] data, int j){
        return new double[0];
    }

    // a function that finds the indices of the max and min elements of a numerical array, returns it
    // could actually write two functions with the same name but with different PARAM types here (not return types)

    private static int[] maxMinArray(int[] data){
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

    // dict is a function that creates a hashtable, iterates through string[][] data to add up nums associated with various strings and to track how many there are
    private static Hashtable<String, double[]> dict (String[][] data){
        // 0th is num, 1st is totalDuration, 2nd is totalLatitude, 3rd is totalLongitude
        Hashtable<String, double[]> ht = new Hashtable<>();  // not sure if typing is needed on RHS
        for (int i = 0; i < data.length; i++){
            if (!ht.containsKey(data[i][COLUMN_SHAPE])){
                ht.put(data[i][COLUMN_SHAPE], new double[4]);
            }
            double[] x = ht.get(data[i][COLUMN_SHAPE]);
            x[0] += 1;
            x[1] += Double.parseDouble(data[i][COLUMN_OF_DURATIONS]);
            x[2] += Double.parseDouble(data[i][COLUMN_LATITUDE]);
            x[3] += Double.parseDouble(data[i][COLUMN_LONGITUDE]);

        }

        return ht;
    }

    private static void printArray(int[] data){
        for (int e: data){
            System.out.println(e);
        }
    }

    private static void printMatrix(String[][] data){
        for (String[] datum : data) {  // enhanced for LOL
            for (String s : datum) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
