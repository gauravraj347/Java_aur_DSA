package Sorting;

public class SelectionSort {
    // Selection Sort function (void because it modifies in-place)
    public void selectionSort(int nums[]) {
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i++) { // Outer loop
            int min = i; // Assume the first element is the minimum
            
            // Inner loop to find the smallest element in the remaining array
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j; // Update minimum index
                }
            }

            // Swap nums[i] and nums[min] if a smaller element was found
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

    // Function to display the array
    public void disp(int nums[]) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println(); // Print a new line for better output format
    }

    public static void main(String[] args) {
        int nums[] = {3, 4, 1, 3, 7, 9}; // Test array

        SelectionSort obj = new SelectionSort();
        System.out.println("Original array:");
        obj.disp(nums); // Print original array

        obj.selectionSort(nums); // Sort the array

        System.out.println("Sorted array:");
        obj.disp(nums); // Print sorted array
    }
}
