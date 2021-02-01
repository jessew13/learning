public class L4ProgThree {

    public static void main(String[] args){
        ThingOne ob1 = new ThingOne("Argle Bargle", 70);
        ThingOne ob2 = new ThingOne("Melba Toast", 45);

        System.out.println(ob1.getAge());  // private
        System.out.println(ob2.getName());
    }
}

class ThingOne{  // constructor has same name as class, no RV
    // can have as many constructors as I want, Java tells apart by parameters/arguments
    private String name;  // now i can't access it directly outside the class, visibility should be on a need-to-know basis, if i don't need to access it, make it private
    private int age;

    public ThingOne(String name, int age){
        this.name = name;
        this.age = age;
    }

    int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
}
