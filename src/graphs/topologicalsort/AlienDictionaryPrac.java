package graphs.topologicalsort;

import java.util.*;

public class AlienDictionaryPrac {

    // Step 1: Extract all unique characters from words
    public static Set<Character>getAllCharacters(String[]words){
       Set<Character>allChars = new HashSet<>();
       for (String word :words){
           for (char c : word.toCharArray()) {
               allChars.add(c);
           }
       }
       return allChars;
    }

    // Step 2: Build dependency graph by comparing adjacent words
    public static Map<Character,List<Character>>buildAlienGraph(String[]words){
        Map<Character,List<Character>>graph = new HashMap<>();
        // Initialize graph for all characters
        Set<Character>allChar = getAllCharacters(words);
        for (char c : allChar){
            graph.put(c,new ArrayList<>());
        }

        // Compare adjacent words to find dependencies
        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int minLength = Math.min(word1.length(),word2.length());
            boolean foundDiff = false;
            for (int j = 0; j < minLength; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2){
                    graph.get(c1).add(c2);
                    foundDiff = true;
                    break;
                }
            }

            // Invalid case: longer word before shorter with same prefix
            if(!foundDiff && word1.length()>word2.length()){
                return null;
            }
        }
        return graph;
    }

    // Step 3: Calculate in-degrees for all characters
    public static Map<Character,Integer>calculateInDegrees(Map<Character,List<Character>>graph, Set<Character>allChar){
        Map<Character,Integer>inDegree = new HashMap<>();

        // Initialize all in-degrees to 0
        for (char c : allChar){
            inDegree.put(c,0);
        }
        // Calculate in-degrees
        for (char c: graph.keySet()){
            for (char nbr : graph.get(c)){
                inDegree.put(nbr,inDegree.get(nbr)+1);
            }
        }
        return inDegree;
    }

    // Step 4: Apply Kahn's algorithm for topological sort
    public static String alienOrder(String[]words){
        // Step 4a: Get all characters and build graph
        Set<Character>allChars = getAllCharacters(words);
        Map<Character, List<Character>> graph = buildAlienGraph(words);
        // Check for invalid input
        if (graph == null) {
            return "";
        }
        // Step 4b: Calculate in-degrees
        Map<Character, Integer> inDegree = calculateInDegrees(graph, allChars);

        // Step 4c: Find characters with in-degree 0
        Queue<Character>queue = new LinkedList<>();
        for (char c : allChars){
           if(inDegree.get(c)==0){
               queue.offer(c);
           }
        }
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()){
            char rem = queue.poll();
            result.append(rem);
            for (char nbr : graph.get(rem)){
                inDegree.put(nbr, inDegree.get(nbr)-1);
                if(inDegree.get(nbr)==0){
                    queue.offer(nbr);
                }
            }
        }
        if(result.length() != allChars.size()){
            return "";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Alien Dictionary ===");

        // Test Case 1: Basic case
        String[] words1 = {"wrt","wrf","er","ett","rftt"};
        System.out.println("Test 1: " + alienOrder(words1));
        System.out.println("Expected: wertf");

        // Test Case 2: Simple case
        String[] words2 = {"z","x"};
        System.out.println("Test 2: " + alienOrder(words2));
        System.out.println("Expected: zx");

        // Test Case 3: Cycle detection
        String[] words3 = {"z","x","z"};
        System.out.println("Test 3: " + alienOrder(words3));
        System.out.println("Expected: (empty string)");

        // Test Case 4: Invalid prefix
        String[] words4 = {"abc","ab"};
        System.out.println("Test 4: " + alienOrder(words4));
        System.out.println("Expected: (empty string)");
    }
}
