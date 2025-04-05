package OOPS;
public class MethodOverloading {

    public static void  add(int n1,int n2){
        int result= n1+n2;
        System.out.println(result);    //if use void print statement wrtie where   or in main method do not store in variable
       
    }
    public static int add(int n1,int n2,int n3){
        int result=n1+n2+n3;
        return result;
    }
    public static double add(double n1,int n2){
        double result=n1+n2;
        return result;
    }


    public static void main(String[] args) {
        MethodOverloading obj=new MethodOverloading();
        obj.add(5,6);
        int res2=obj.add(5,6, 7);
        double res3=obj.add(5.5,6);

       
        System.out.println(res2);
        System.out.println(res3);


       
    }

}
