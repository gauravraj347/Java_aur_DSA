// Define the package name
package Stack;

import java.util.ArrayList;

public class StackUsingArray {
    
    // Static inner class to represent the Stack
    static class Stack {
        // Use an ArrayList to store stack elements
        ArrayList<Integer> list = new ArrayList<>();

        // Method to push an element onto the stack
        public void push(int data) {
            list.add(data); // Add element to the end of the list
        }

        // Method to check if the stack is empty
        public boolean isEmpty() {
            return list.size() == 0; // Return true if size is 0
        }

        // Method to pop (remove and return) the top element of the stack
        public int pop() {
            if(isEmpty()) {
                return -1; // Return -1 if stack is empty (underflow condition)
            }
            // Remove and return the last element
            int top = list.remove(list.size() - 1);
            return top;
        }

        // Method to peek (view) the top element without removing it
        public int peek() {
            if(isEmpty()) {
                return -1; // Return -1 if stack is empty
            }
            // Return the last element without removing it
            return list.get(list.size() - 1);
        }
    }

    // Main method to test stack operations
    public static void main(String args[]) {
        Stack stack = new Stack(); // Create a new stack

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Pop and print all elements from the stack until it's empty
        while(!stack.isEmpty()) {
            System.out.println(stack.peek()); // Print the top element
            stack.pop();                      // Remove the top element
        }
    }
}
