package Sorting;

public class InsertionSort {
    // Insertion Sort function (sorts the array in-place)
    public void insertionSort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int key = nums[i];  // Current element to be inserted in sorted part
            int j = i - 1;

            // Move elements of nums[0..i-1] that are greater than key, one position ahead
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key; // Insert key at the correct position
        }
    }

    // Function to display the array
    public void display(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test the Insertion Sort
    public static void main(String[] args) {
        int[] nums = {9, 5, 1, 4, 3};

        InsertionSort obj = new InsertionSort();
        System.out.println("Original array:");
        obj.display(nums); // Print original array

        obj.insertionSort(nums); // Sort the array

        System.out.println("Sorted array:");
        obj.display(nums); // Print sorted array
    }
}
