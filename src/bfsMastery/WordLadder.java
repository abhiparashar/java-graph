package bfsMastery;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert list to set for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordList);

        // If endWord not in wordList, transformation impossible
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Start from beginWord with distance 1
        queue.offer(beginWord);
        visited.add(beginWord);
        int steps = 1;

        // BFS level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Process all words at current level
            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();

                // Check if we reached the target
                if (currentWord.equals(endWord)) {
                    return steps;
                }

                // Try changing each character position
                char[] wordArray = currentWord.toCharArray();
                for (int pos = 0; pos < wordArray.length; pos++) {
                    char originalChar = wordArray[pos];

                    // Try all 26 letters at this position
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue; // Skip same character

                        wordArray[pos] = c;
                        String newWord = new String(wordArray);

                        // If new word is valid and not visited
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }

                    // Restore original character for next position
                    wordArray[pos] = originalChar;
                }
            }

            steps++; // Move to next level
        }

        return 0; // No transformation possible
    }

    // Test method
    public static void main(String[] args) {
        WordLadder solution = new WordLadder();

        // Test case 1
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println("Test 1:");
        System.out.println("Begin: " + beginWord1 + ", End: " + endWord1);
        System.out.println("WordList: " + wordList1);
        System.out.println("Steps: " + solution.ladderLength(beginWord1, endWord1, wordList1));

        // Test case 2
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot","dot","dog","lot","log");

        System.out.println("\nTest 2:");
        System.out.println("Begin: " + beginWord2 + ", End: " + endWord2);
        System.out.println("WordList: " + wordList2);
        System.out.println("Steps: " + solution.ladderLength(beginWord2, endWord2, wordList2));
    }
}