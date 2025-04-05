package PriorityQueue;

public class InsertionHeap {

    // Function to swap two elements in the array
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to print the array up to 'n' elements
    public static void printArray(int arr[], int n){
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Function to maintain the max-heap property after inserting a new element
    public static void heapify(int arr[], int n, int i){
        int parent = (i - 1) / 2; // Formula to get parent of a node at index 'i'

        // If the parent is a valid index (greater than 0)
        if(arr[parent] > 0){
            // If the current element is greater than its parent, swap them
            if(arr[i] > arr[parent]){
                swap(arr, i, parent);
                // Recursively call heapify to maintain heap property up the tree
                heapify(arr, parent, i);
            }
        }
    }

    // Function to insert a new value into the heap
    public static int insert(int[] arr, int n, int value ){
        n++; // Increase the heap size
        arr[n - 1] = value; // Add the new value at the end of the heap
        heapify(arr, n, n - 1); // Restore the heap property
        return n; // Return the new size of the heap
    }

    // Main function to test insertion into a max-heap
    public static void main(String[] args) {
        int max = 100; // Maximum size of the heap array
        int[] arr = new int[max]; // Create the array for heap

        // Pre-filled heap of 5 elements (max-heap)
        arr[0] = 90;
        arr[1] = 70;
        arr[2] = 60;
        arr[3] = 40;
        arr[4] = 50;

        int n = 5; // Current size of the heap

        System.out.println("Before insert:");
        printArray(arr, n);

        int value = 80; // Value to insert into the heap
        n = insert(arr, n, value); // Insert the value and update heap size

        System.out.println("After insert:");
        printArray(arr, n);
    }
}
