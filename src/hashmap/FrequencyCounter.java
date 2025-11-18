package hashmap;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {
    public static void countFrequencies(int[]nums){
        HashMap<Integer, Integer>map = new HashMap<>();
//        for (int num :arr){
//            if(map.containsKey(num)){
//               int count = map.get(num);
//               map.put(num, count+1);
//            }else {
//                map.put(num,1);
//            }
//        }

        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

       for (Map.Entry<Integer,Integer> key : map.entrySet()){
           System.out.println(key.getKey()+ " appears " + key.getValue() + " times");
       }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4};
        countFrequencies(arr);

        // Output:
        // 1 appears 1 times
        // 2 appears 2 times
        // 3 appears 3 times
        // 4 appears 1 times
    }
}
