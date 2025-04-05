package Stack;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    // Method to add a new element to the stack
    static void add(int data) {
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // Push new data into q1
        q1.add(data);

        // Move all elements back from q2 to q1
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    // Method to delete an element from the stack
    static int remove() {
        if (q1.isEmpty()) {
            System.out.println("Stack underflow!");
            System.exit(0);
        }
        return q1.poll();
    }

    public static void main(String[] args) {
        StackUsingQueue s = new StackUsingQueue();
        
        s.add(3);
        s.add(2);
        s.add(1);

        System.out.println(s.remove()); // Output: 1
        System.out.println(s.remove()); // Output: 2
    }
}
