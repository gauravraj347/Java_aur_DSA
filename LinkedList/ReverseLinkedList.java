package LinkedList;


// Node class for Singly Linked List


// Singly Linked List class
class SinglyLinkedList {
    class Node {
        int data;
        Node next;
    
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Reverse the linked list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;  // Save next node
            current.next = prev;  // Reverse pointer
            prev = current;       // Move prev to current
            current = next;       // Move current to next
        }
        head = prev;  // Update head to new first node
    }

    // Display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);
        list.insertAtBeginning(40);

        System.out.println("Original Linked List:");
        list.display();

        list.reverse();

        System.out.println("Reversed Linked List:");
        list.display();
    }
}



// import java.util.LinkedList;
// import java.util.Collections;

// public class ReverseLinkedList {

//     public static void reverseLinkedList(LinkedList<Integer> list) {
//         Collections.reverse(list); // Using built-in method
//     }

//     public static void main(String[] args) {
//         LinkedList<Integer> list = new LinkedList<>();
//         list.addFirst(20);
//         list.addFirst(50);
//         list.add(40);

//         System.out.println("Original List: " + list);

//         reverseLinkedList(list);
//         System.out.println("Reversed List: " + list);
//     }
// }
