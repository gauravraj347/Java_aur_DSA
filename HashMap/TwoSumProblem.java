package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSumProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the size of the array
        System.out.println("Enter the size of array");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Taking input for array elements
        System.out.println("Enter the array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Taking input for target sum
        System.out.println("Enter target");
        int target = sc.nextInt();

        // HashMap to store array elements and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Storing elements in HashMap with their indices
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int result[] = new int[2];  // Array to store the indices of the found pair
        boolean found = false; // Flag to track if a valid pair is found

        // Iterating through the array to find two indices whose values sum up to the target
        for (int i = 0; i < n; i++) {
            // Special condition: If the array element itself is equal to the target and 0 exists in the map
            if (arr[i] == target && map.containsKey(0)) {
                result[0] = i;    //get index of value
                result[1] = map.get(0);  // get index of where 0 present
                
                found = true;
                break;
            }
            // Check if the complement (target - arr[i]) exists in the HashMap
            else if (map.containsKey(target - arr[i])) {
                // Ensuring that the index of the complement is greater than the current index
                if (map.get(target - arr[i]) > i) {
                    result[0] = i;
                    result[1] = map.get(target - arr[i]);
                    found = true;
                    break;
                }
            }
        }

        // Output the result
        if (found) {
            System.out.println("Two index values are " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No valid pair found.");
        }
    }
}
