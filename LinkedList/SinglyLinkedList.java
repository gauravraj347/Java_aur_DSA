package LinkedList;


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

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    

    // Insert at a specific position
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        // Insert at the beginning if position is 1
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        // Traverse to one position before the target
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        // If position is out of bounds
        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        // Insert the new node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete from the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
    }

    // Delete from the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Search for an element
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
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
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Original Linked List:");
        list.display();

        // Insert at position 3
        list.insertAtPosition(25, 3);
        System.out.println("After inserting 25 at position 3:");
        list.display();

        System.out.println("Deleting from beginning...");
        list.deleteFromBeginning();
        list.display();

        System.out.println("Deleting from end...");
        list.deleteFromEnd();
        list.display();

        int searchKey = 30;
        System.out.println("Search " + searchKey + ": " + (list.search(searchKey) ? "Found" : "Not Found"));
    }
}




//framework

// import java.util.*;

// public class SinglyLinkedList {
//     public static void main(String[] args) {
//         // Create a LinkedList of integers
//         LinkedList<Integer> list = new LinkedList<>();

//         // Inserting elements
//         list.addFirst(10);  // Insert at beginning
//         list.addFirst(20);
//         list.addLast(30);   // Insert at end
//         list.add(40);       // Insert at end (same as addLast)

//         // Displaying the list
//         System.out.println("Linked List: " + list);

//         // Deleting elements
//         list.removeFirst(); // Delete from beginning
//         System.out.println("After removing first: " + list);

//         list.removeLast();  // Delete from end
//         System.out.println("After removing last: " + list);

//         // Searching for an element
//         int searchKey = 10;
//         System.out.println("Is " + searchKey + " present? " + list.contains(10));
//     }
// }


