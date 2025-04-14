package Stack;

import java.util.*;

// Code to reverse a stack using recursion
public class ReverseStack {

    // Function to insert an element at the bottom of a stack
    public static void pushAtBottom(Stack<Integer> s, int data) {
        // Base case: if stack is empty, just push the data
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        // Recursive case: pop all elements until stack is empty
        int temp = s.pop();
        pushAtBottom(s, data); // Push data at the bottom
        s.push(temp); // Push back all the popped elements
    }

    // Function to reverse the stack using recursion
    public static void reverse(Stack<Integer> s) {
        // Base case: if stack is empty, nothing to reverse
        if (s.isEmpty()) {
            return;
        }

        // Remove the top element
        int top = s.pop();

        // Recursively reverse the remaining stack
        reverse(s);

        // Insert the popped element at the bottom of the reversed stack
        pushAtBottom(s, top);
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>(); // Create a new stack

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Reverse the stack
        reverse(stack);

        // Print all elements from the reversed stack
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
