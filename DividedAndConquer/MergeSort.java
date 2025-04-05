package DividedAndConquer;


public class MergeSort {
    // Function to merge two sorted subarrays
    public static void conquer(int arr[], int si, int mid, int ei) {
        // Creating a temporary array to store merged elements
        int merged[] = new int[ei - si + 1];

        // Pointers to traverse left and right subarrays
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        // Merge elements from both halves in sorted order
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        // Copy remaining elements from the left subarray (if any)
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        // Copy remaining elements from the right subarray (if any)
        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        // Copy the merged elements back to the original array
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    // Recursive function to divide the array into two halves
    public static void divide(int arr[], int si, int ei) {
        // Base case: If starting index is greater than or equal to ending index, return
        if (si >= ei) {
            return;
        }

        // Calculate the middle index
        int mid = si + (ei - si) / 2;

        // Recursively divide the left half
        divide(arr, si, mid);

        // Recursively divide the right half
        divide(arr, mid + 1, ei);

        // Merge the sorted halves
        conquer(arr, si, mid, ei);
    }

    // Main function to execute the merge sort algorithm
    public static void main(String args[]) {
        int arr[] = {6, 3, 9, 5, 2, 8}; // Sample array to be sorted
        int n = arr.length; // Length of the array

        // Calling the divide function to start the sorting process
        divide(arr, 0, n - 1);

        // Printing the sorted array
        System.out.println("Sorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

