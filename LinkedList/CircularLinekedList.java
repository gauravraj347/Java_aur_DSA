package LinkedList;

// Node class for Circular Linked List
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Circular Linked List Class
class CircularLinkedList {
    private Node head;
    private Node tail;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular link
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head; // Maintain circular nature
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular link
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head; // Maintain circular nature
    }

    // Insert at a specific position (1-based index)
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; temp.next != head && i < position - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        // If inserted at last position, update tail
        if (temp == tail) {
            tail = newNode;
        }
    }

    // Delete from the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head == tail) { // Only one node
            head = null;
            tail = null;
            return;
        }

        head = head.next;
        tail.next = head; // Maintain circular nature
    }

    // Delete from the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head == tail) { // Only one node
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = head;
        tail = temp;
    }

    // Delete at a specific position
    public void deleteAtPosition(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; temp.next != head && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp.next == head || temp.next == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        if (temp.next == tail) {
            tail = temp;
        }

        temp.next = temp.next.next;
    }

    // Search for an element
    public boolean search(int key) {
        if (head == null) {
            return false;
        }

        Node temp = head;
        do {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);

        return false;
    }

    // Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Original Circular Linked List:");
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

        System.out.println("Deleting node at position 2...");
        list.deleteAtPosition(2);
        list.display();

        // Search for an element
        int searchKey = 30;
        System.out.println("Search " + searchKey + ": " + (list.search(searchKey) ? "Found" : "Not Found"));
    }
}
