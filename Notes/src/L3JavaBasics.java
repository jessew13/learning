public class L3JavaBasics {

    public static void main(String[] args){
        String s1 = "hello";
        String s2 = "hello";  // s2 is a different variable, but since strings are immutable in Java, the compiler has s2's arrow point to the same spot as s1's arrow

        if (s1 == s2) System.out.println("Same");  // Same
        else System.out.println("Different");

        String s3 = "tarheels";
        String s4 = new String("tarheels");

        if (s3 == s4) System.out.println("Same");
        else System.out.println("Different");  // Different

        // use .equals() for Strings to compare the characters, not the references

        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};

        System.out.println(a == b);  // false

    }
}
