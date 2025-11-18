package hashmap;

import java.util.HashMap;
import java.util.Map;

public class DuplicateFinder {
    public static boolean hasDuplicate(int[] nums){
        HashMap<Integer,Integer>map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer,Integer>entry: map.entrySet()){
            if(entry.getValue()>1){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 1};
        System.out.println(hasDuplicate(arr1)); // false
        System.out.println(hasDuplicate(arr2)); // true
    }
}
