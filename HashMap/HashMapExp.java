package HashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class HashMapExp {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(3, "Priya");
        map.put(5, "golu");
        map.put(2, "baby");
        map.put(9, "mister");

        System.out.println("HashMap Output: " + map);
        // HashMap does not guarantee insertion order

        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();
        map1.put(3, "Priya");
        map1.put(5, "golu");
        map1.put(2, "baby");
        map1.put(9, "mister");

        System.out.println("LinkedHashMap Output: " + map1);
        // LinkedHashMap maintains insertion order

        TreeMap<Integer, String> map2 = new TreeMap<>();
        map2.put(3, "Priya");
        map2.put(5, "golu");
        map2.put(2, "baby");
        map2.put(9, "mister");

        System.out.println("TreeMap Output: " + map2);
        // TreeMap sorts the keys in natural order
    }
}
