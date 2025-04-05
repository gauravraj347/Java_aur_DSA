package OOPS;
// import java.util.*;

// class Student {
//     private int a;
//     private int b;

//     // Default constructor
//     Student() {
//         System.out.println("Zero parameter constructor"); // ✅ Fixed typo
//     }

//     // Parameterized constructor
//     Student(int a, int b) {
//         this.a = a;
//         this.b = b;
//     }

//     void show() {
//         System.out.println("a: " + a);
//         System.out.println("b: " + b);
//     }
// }

// public class Constructions {
//     public static void main(String[] args) {
//         Student obj = new Student(); // Calls default constructor
//         obj.show(); // Prints default values: 0 0

//         Student obj1 = new Student(6, 5); // Calls parameterized constructor
//         obj1.show(); // Prints: 6 5
//     }
// }



class Demo{
    private int a;
    private String name;

    Demo(){
        System.out.println("Zero");
        name="Golu";
        a=8;
    }

    Demo(String name){
        this.name=name;
        a=98;
    }
    Demo(int a,String name){
        this.a=a;
        this.name=name;
    }

    void show(){
        System.out.println(a);
        System.out.println(name);
    }
}

class Constructions{
    public static void main(String[] args) {
        Demo obj=new Demo();
        obj.show();

        Demo obj1=new Demo("babu");
        obj1.show();

        Demo obj2=new Demo(7,"babu");
        obj2.show();
    }
}