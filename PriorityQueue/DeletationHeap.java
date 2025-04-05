package PriorityQueue;

public class DeletationHeap {

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

    // Function to maintain max-heap property
    public static void heapify(int arr[], int n, int i){
        int largest = i;          // Assume current index is largest
        int l = 2 * i + 1;        // Left child index
        int r = 2 * i + 2;        // Right child index

        // If left child is larger than current largest
        if(l < n && arr[l] > arr[largest]){
            largest = l;
        }

        // If right child is larger than current largest
        if(r < n && arr[r] > arr[largest]){
            largest = r;
        }

        // If largest is not the current node, swap and continue heapifying
        if (largest != i){
            swap(arr, i, largest);
            heapify(arr, n, largest);  // Recursively heapify the affected sub-tree
        }
    }

    // Function to delete the root node (maximum element in max-heap)
    public static int delete(int arr[], int n){
        int lastElement = arr[n - 1]; // Get the last element

        // Replace root (maximum element) with the last element
        arr[0] = lastElement;

        n--; // Reduce heap size by 1

        // Heapify from root to restore max-heap property
        heapify(arr, n, 0);

        return n; // Return updated size
    }

    // Main method to demonstrate heap deletion
    public static void main(String[] args) {
        int max = 100;
        int arr[] = new int[max];  // Create a heap with maximum size

        // Initial heap (max-heap) elements
        arr[0] = 90;
        arr[1] = 70;
        arr[2] = 60;
        arr[3] = 40;
        arr[4] = 50;

        int n = 5; // Current size of the heap

        System.out.println("Before delete:");
        printArray(arr, n);

        n = delete(arr, n); // Delete the root element (maximum)

        System.out.println("After delete:");
        printArray(arr, n);
    }
}
