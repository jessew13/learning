/* https://youtu.be/JkIcZxal3Fg?t=263
"If you have a room of 23 people, there's a 50% chance that at least 2 of them have the same birthday."
In this file, I create a simulation of this under the assumption that there are 365 days in a year (i.e. exclude February 29).
I also assume that each of the 365 days has an equal chance of being a person's birthday.
 */
import java.util.*;


public class BirthdayGame {

    final static int DAYS_IN_YEAR = 365;
    final static int TRIALS = 100000;
    final static int NUM_PEOPLE = 23;

    public static void main(String[] args){
        // initialize counter variable for number of lists with at least one duplicated element
        int count = 0;

        // generate a list with length NUM_PEOPLE
        int[] list = new int[NUM_PEOPLE];

        for (int i = 0; i < TRIALS; i++) {

            // call randomizeDates on the list (directly change it)
            randomizeDates(list);

            // call checkDuplicates on the list, add 1 to count if true
            if (checkDuplicates(list)) count += 1;
        }

        // print out the number of (double)count / TRIALS
        System.out.println("The percentage of the time there were at least 2 people with the same birthday in a grouping of " + NUM_PEOPLE + " people after " + TRIALS + " trials is " + (double)count / TRIALS * 100 + "%.");

    }

    public static void randomizeDates(int[] list){
        // This function takes a list of integers and assigns a random int from 0 to DAYS_IN_YEAR to each index of the list.

        // for each index, assign a random number from 0 to 364
        for (int i = 0; i < list.length; i++){
            list[i] = (int)(Math.random() * DAYS_IN_YEAR);
        }
    }

    public static boolean checkDuplicates(int[] list){
        // This function returns true if there is a duplicated value within a list
        // tbh not sure of the most efficient way to do it
        // but it definitely wouldn't involve looking at element i and looking at the rest and seeing if they match element i
        // https://www.techiedelight.com/check-duplicates-array-java/

        // create empty set
        Set<Integer> set = new HashSet<>();

        for (int e:list){
            if (set.contains(e)) return true;
            set.add(e);
        }

        return false;
    }


}
