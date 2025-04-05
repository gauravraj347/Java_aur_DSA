package PriorityQueue;
public class HeapSort {
    
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

    public static void heapSort(int arr[], int n){
        for(int i = (n/2)-1;i>=0;i--){
            heapify(arr, n, i);
        }
        for(int i = n-1; i>0; i--){
            swap(arr, i, 0);
            heapify(arr, n, 0);
        }
    }
    public static void main(String[] args) {
        int arr[]={4,6,7,2,5};
        heapSort(arr, arr.length);
        printArray(arr, arr.length);
    }

}
