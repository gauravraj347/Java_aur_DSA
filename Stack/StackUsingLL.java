package Stack;

// Stack implementation using Linked List
public class StackUsingLL {

    // Node class representing each element in the stack
    private static class Node {
        int data;      // Value of the node
        Node next;     // Pointer to the next node

        // Constructor to create a new node with given data
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Stack class containing stack operations
    static class Stack {
        public static Node head = null; // Head of the linked list (top of the stack)

        // Push operation - adds an element to the top of the stack
        public static void push(int data) {
            Node newNode = new Node(data); // Create a new node with the given data

            if (head == null) {
                head = newNode; // If stack is empty, new node becomes the head
                return;
            }

            // Link new node to the current head and update head
            newNode.next = head;
            head = newNode;
        }

        // Checks if the stack is empty
        public static boolean isEmpty() {
            return head == null;
        }

        // Pop operation - removes and returns the top element of the stack
        public static int pop() {
            if (isEmpty()) {
                return -1; // Return -1 if stack is empty
            }

            Node top = head;       // Store current top
            head = head.next;      // Move head to the next node
            return top.data;       // Return data of removed node
        }

        // Peek operation - returns the top element without removing it
        public static int peek() {
            if (isEmpty()) {
                return -1; // Return -1 if stack is empty
            }

            return head.data; // Return data at the head node
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

        // Print and pop all elements until the stack is empty
        while (!stack.isEmpty()) {
            System.out.println(stack.peek()); // Print the top element
            stack.pop();                      // Remove the top element
        }
    }
}
