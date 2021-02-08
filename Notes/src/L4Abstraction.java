// this is the real l4, previous ones are off by 1

public class L4Abstraction {

    public static void main(String[] args){
        arrayOutOfBounds();
    }

    private static void arrayOutOfBounds(){
        int[] x = new int[10];
        x[10] = 1;  // IntelliJ detects this, but the compiler doesn't (will compile)
        // ArrayList != Arrays
    }
}

/*
Random notes:

Arraylist != Array
atomic = primitive


Class setup steps

Step 1: Define class
Step 2: Define instance fields
Step 3: Constructor
Step 4: Define instance methods, WITHOUT static keyword
    absence of static makes it an instance method
    reference.method();
    "You can use static to keep track of certain data across all instances of a class, because they can all access the same static member of the class" - from a student, could be wrong

public class Triangle{
    Point _a;
    Point _b;
    Point _c;

    the _ is like "this," showing that it's an object within a bigger class
    semantic

object definition reflects purpose


Static class fields
    instance fields are data associated with each instance
    most common use case: NAMED CONSTANTS, defined with final keyword

static belongs to the whole class, can be used to communicate across instances!
 */
