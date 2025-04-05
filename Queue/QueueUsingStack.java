package Queue;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation
    public void enque(int value) {
        stack1.push(value);
    }

    // Dequeue operation
    public int deque() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Returning -1 as an indication of an empty queue
        }

        // Transfer elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStack obj = new QueueUsingStack();
        obj.enque(1);
        obj.enque(3);

        System.out.println(obj.deque()); // Should print 1
        System.out.println(obj.deque()); // Should print 3
        System.out.println(obj.deque()); // Should print "Queue is empty" and return -1
    }
}
