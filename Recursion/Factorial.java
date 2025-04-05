package Recursion;

public class Factorial {
    public int factorial(int n){
        if(n==0||n==1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
        
    }
    public void disp(int result){
        System.out.println(result);
    }
    public static void main(String[] args) {
        Factorial obj =new Factorial();

        int facresult=obj.factorial(5);
        obj.disp(facresult);
        System.out.println(facresult);

    }
    
}
