package OOPS;
// class Student{
//     int n;
//     String name;

//     public void show(){
//         System.out.println(n+" "+name);
//     }

// }



// public class Encapsulation {

//     public static void main(String[] args) {
//         Encapsulation obj=new Encapsulation();

//         obj.n=6;
//         obj.name="golu";
//         obj.show();   
//     }
// }



// class Student{
//     private int n;
//     private String name;

//     public void setdata(){
//         n=7;
//         name="gaurav";
//     }
//     public void show(){
//         System.out.println(n+" "+name);
//     }

// }

// public class Encapsulation {

//     public static void main(String[] args) {
//         Student obj=new Student();

//         obj.show();   
//     }
// }


class Student{
    private int n;
    private String name;

    public void setdata(int a){   //setter
        n=a;
    }
    public void setString(String b){
        name=b;
    }

    public void show(){
        System.out.println(n+" "+name);
    }

}

public class Encapsulation {

    public static void main(String[] args) {
        Student obj=new Student();

        obj.setdata(6);
        obj.show();
        obj.setString("Golu");

        obj.show();   
    }
}