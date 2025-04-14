package Queue;

import java.util.LinkedList;
import java.util.Queue;

// Class demonstrating queue operations using LinkedList
class QueueUsingLL {

    public static void main(String[] args) {
        // Create a queue using LinkedList (FIFO structure)
        Queue<Integer> list = new LinkedList<>();

        // Enqueue elements 0 to 9 into the queue
        for (int i = 0; i < 10; i++) {
            list.add(i); // 'add()' inserts elements at the rear of the queue
        }

        // Print the entire queue
        System.out.println(list); // Output: [0, 1, 2, ..., 9]

        // Peek the front element without removing it
        System.out.println(list.peek()); // Output: 0

        // Remove (dequeue) the front element from the queue
        list.remove(); // Removes 0

        // Peek again to see the new front element
        System.out.println(list.peek()); // Output: 1
    }
}
