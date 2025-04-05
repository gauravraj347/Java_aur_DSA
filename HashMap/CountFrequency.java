 package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class CountFrequency {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String str = sc.nextLine();
        sc.close();

        HashMap<Character, Integer> map = new HashMap<>();


        // Counting occurrences of each character
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1); // Increment count
            } else {
                map.put(str.charAt(i), 1); // Initialize with 1 instead of index
            }
        }

        int result = -1; // To check if non-repeating character exists

        // Finding the first non-repeating character
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) { // If count is 1, it's non-repeating
                System.out.println("The first non-repeating character index is " + i);
                result = 1;
                break;
            }
        }

        // If no non-repeating character found
        if (result == -1) {
            System.out.println("No non-repeating character present in the string");
        }
        for (char ch : map.keySet()) {  // Iterate through unique characters in the map
            System.out.println("Character '" + ch + "' has frequency: " + map.get(ch));
        }
        
        


    }
}



// public class CountFrequency {
//     public static void main(String[] args) {
//         System.out.println("hello baby");
//     }
// }
