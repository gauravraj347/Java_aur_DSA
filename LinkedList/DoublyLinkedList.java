package LinkedList;


// Doubly Linked List Class
class DoublyLinkedList {
    class Node {
        int data;
        Node prev, next;
    
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
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
        newNode.prev = temp;
    }

    // Insert at a specific position (1-based index)
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(data);
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete from the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
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
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    // Delete a node at a specific position
    public void deleteAtPosition(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        Node temp = head;
        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
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
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Original Doubly Linked List:");
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
