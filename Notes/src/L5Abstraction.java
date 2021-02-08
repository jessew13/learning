// learn about encapsulation, interface
// from TA: The idea is that the interface itself is just supposed to give you an idea of what you'll be creating in your implementation.  So it's cleaner to have a separate interface file apart from your implementation code, which could be large and complex.

public class L5Abstraction {

    // Encapsulation: what happens in Vegas stays in Vegas
    // what happens in an object stays in the object, we want code to interact with objects through methods and not by directly reaching into the object
    // let that object/class be like a fence around the data it contains

    public static void main(String[] args){

    }

//    private static void main(String[] args){
//        Point p1 = new Point(5, 5);
//        System.out.println("Perimeter of T1 = " + t1.perimeter());
//
//        t1.a.x += 5;  // doable but WRONG, DON'T REACH IN DIRECTLY
//    }

//    public interface InterfaceName{
//        type method1(parameters);
//        type method2(parameters)
//    }

    // public class CartesianPoint implements Point (or something liek that idk, study this)


    /* Interface naming conventions
        Convention A
            Start all interface names with I for interface: ITriangle, IPoint
        Convention B
            Use generic abstraction name for interface
            Make class names descriptive for implementation
    */


    /*
    In general:
        Make all data fields private
        public getter/setter methods

     */


//    public interface Point{
//        double getX();
//        double getY();
//        double distanceTo(Point p);
//        boolean equals(Point p);
//    }

    // informational, HAS ONLY METHODS, no code of its own


    // exposed behavior should be reflected in the interface(s) that a class implements
    // internal behavior should be hidden (private)
}
