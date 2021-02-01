public class L4ProgTwo {

    static int x = 17;  // this goes into the heap, every object has memory allocated for x and num
    // every object will be able to see x, and x will be shared such that if changed in one object, OTHER OBJECTS SEE THE CHANGE
    int num = 15;

    public static void main(String[] args){
        int max = 12;  // local variable, everything in this method can see it
        double dnum = 12.0;

        int[] nums = new int[max];  // if declare but don't initialize, null pointer
        int[] nums2 = new int[max];

        for (int i = 0; i < max; i++){
            nums[i] = i*i;
            nums2[i] = i*i;
        }
        System.out.println(nums[7]);
        System.out.println(nums == nums2);  // false

        int max2 = 5;  // local variable, scope is everything below the variable

        // a variable's scope is the curly braces it's in && the stuff below its declaration

        for (int i = 0; i < 5; i++){
            System.out.println(max);
        }
    }
}
