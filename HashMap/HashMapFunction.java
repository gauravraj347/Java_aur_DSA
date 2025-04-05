package HashMap;

import java.util.HashMap;
import java.util.Map;

class HashMapFunction {
    public static void main(String[] args) {
        // Corrected HashMap initialization with key-value pair types
        HashMap<Integer, String> hashmap = new HashMap<>();
        
        // Adding key-value pairs
        hashmap.put(1, "priya");
        hashmap.put(5, "golu");
        hashmap.put(2, "baby");
        hashmap.put(3, "hello");
      //  hashmap.put(3, "hiii");

        // Printing the HashMap
        System.out.println("HashMap: " + hashmap);

        // Fetching value for a key
        String result = hashmap.get(3); // This will return null
        System.out.println("Value for key 3: " + result);

        // Checking if a key exists
        System.out.println("Contains key 2? " + hashmap.containsKey(2));

        // Removing a key-value pair
        hashmap.remove(1);
        System.out.println("After removing key 1: " + hashmap);



//iteration using loop
        for(Map.Entry<Integer,String> e: hashmap.entrySet()){
            System.out.println("Hashmap is");
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }
}
