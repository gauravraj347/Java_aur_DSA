package Queue;

import java.util.ArrayDeque;
import java.util.Deque; // Import the correct Deque interface

public class Dequelmp  {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(5);
        deque.addFirst(7);
        deque.addFirst(8);
        deque.addLast(10);
       

        System.out.println(deque);
        deque.removeLast(); 
        deque.removeFirst();
        System.out.println(deque);
    }
}
