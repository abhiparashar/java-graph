package graphs.topologicalsort;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        // Step 1: Initialize graph and in-degree map
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize all characters with in-degree 0
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                graph.put(c, new HashSet<>());
            }
        }

        // Step 2: Build the graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Find the first different character
            int minLen = Math.min(word1.length(), word2.length());
            boolean foundDifference = false;

            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    // c1 comes before c2 in alien dictionary
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    foundDifference = true;
                    break;
                }
            }

            // Edge case: "abc" comes before "ab" - invalid!
            if (!foundDifference && word1.length() > word2.length()) {
                return "";
            }
        }

        // Step 3: Topological Sort using Kahn's Algorithm
        Queue<Character> queue = new LinkedList<>();

        // Add all characters with in-degree 0 to queue
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            // Process all neighbors
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);

                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: Check if valid topological order exists
        // If result length equals number of unique characters, no cycle
        return result.length() == inDegree.size() ? result.toString() : "";
    }

    // Test method
    public static void main(String[] args) {
        AlienDictionary solution = new AlienDictionary();

        // Test case 1
        String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("Test 1: " + solution.alienOrder(words1)); // Expected: "wertf" or similar valid order

        // Test case 2: Invalid case
        String[] words2 = {"z", "x"};
        System.out.println("Test 2: " + solution.alienOrder(words2)); // Expected: "zx" or "xz"

        // Test case 3: Invalid - longer word before shorter prefix
        String[] words3 = {"abc", "ab"};
        System.out.println("Test 3: " + solution.alienOrder(words3)); // Expected: ""

        // Test case 4: Single character words
        String[] words4 = {"z", "z"};
        System.out.println("Test 4: " + solution.alienOrder(words4)); // Expected: "z"
    }
}

/*
Algorithm Breakdown:

1. GRAPH CONSTRUCTION (The Tricky Part):
   - Compare each pair of adjacent words
   - Find first differing character: c1 → c2 (c1 comes before c2)
   - Add edge c1 → c2 to graph
   - Increment in-degree of c2

2. EDGE CASE HANDLING:
   - If word1 is longer than word2 but all compared chars are same
   - Example: "abc" vs "ab" → INVALID ordering

3. TOPOLOGICAL SORT (Kahn's Algorithm):
   - Start with all characters having in-degree 0
   - Process each character and reduce neighbors' in-degrees
   - Add to result in topological order

4. CYCLE DETECTION:
   - If result.length != total unique characters → cycle exists
   - Return empty string for invalid ordering

Time Complexity: O(C) where C = total characters in all words
Space Complexity: O(1) since at most 26 characters in alphabet

Key Insights:
- Graph construction is the hardest part
- Use Set to avoid duplicate edges
- Handle prefix edge case carefully
- Kahn's algorithm naturally detects cycles
*/