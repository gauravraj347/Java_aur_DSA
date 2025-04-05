package Recursion;

public class Fibonacci {
    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n; // Base cases
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive relation
    }

    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();
        int result = obj.fibonacci(5);
        System.out.println("Fibonacci(5): " + result);
    }
}

