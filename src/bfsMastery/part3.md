# 🎯 BFS GRAPH MASTERY - PART 3

## 🔥 **PATTERN 4: BIDIRECTIONAL BFS**

### **Problem 4: Word Ladder (Bidirectional Optimization)**

**Problem Statement:**
Transform word "hit" to "cog" changing one letter at a time, with each intermediate word in given dictionary. Find minimum transformations.

```
Example:
beginWord = "hit"
endWord = "cog"  
wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5 ("hit"→"hot"→"dot"→"dog"→"cog")
```

**Reference Solution:**

```java
// TEMPLATE 4: Bidirectional BFS
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        return biBFS(beginSet, endSet, wordSet, 1);
    }
    
    private int biBFS(Set<String> beginSet, Set<String> endSet, 
                      Set<String> wordSet, int level) {
        if (beginSet.isEmpty()) return 0;
        
        // Always expand smaller set for optimization
        if (beginSet.size() > endSet.size()) {
            return biBFS(endSet, beginSet, wordSet, level);
        }
        
        // Remove explored words to avoid revisiting
        wordSet.removeAll(beginSet);
        
        Set<String> nextSet = new HashSet<>();
        
        for (String word : beginSet) {
            char[] chars = word.toCharArray();
            
            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];
                
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == old) continue;
                    
                    chars[i] = c;
                    String newWord = String.valueOf(chars);
                    
                    // Found intersection!
                    if (endSet.contains(newWord)) {
                        return level + 1;
                    }
                    
                    if (wordSet.contains(newWord)) {
                        nextSet.add(newWord);
                    }
                }
                chars[i] = old; // Restore
            }
        }
        
        return nextSet.isEmpty() ? 0 : biBFS(nextSet, endSet, wordSet, level + 1);
    }
}
```

**Bidirectional BFS Benefits:**
- **Time Complexity:** O(b^(d/2)) vs O(b^d) for regular BFS
- **Space Complexity:** Significantly reduced
- **Use When:** Large search space, both start and end known

---

## ⚡ **PATTERN 5: BFS LEVEL PROCESSING**

### **Problem 5: Binary Tree Level Order Traversal**

**Problem Statement:**
Return level-by-level traversal of binary tree as list of lists.

```java
// TEMPLATE 5: BFS Level Processing  
class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            // Process entire level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(currentLevel);
        }
        
        return result;
    }
}
```

**Level Processing Variations:**
```java
// Right side view - last element of each level
public List<Integer> rightSideView(TreeNode root) {
    // Same template, but add only last element of each level
}

// Average of each level
public List<Double> averageOfLevels(TreeNode root) {
    // Same template, calculate average per level
}

// Minimum depth - return level when first leaf found
public int minDepth(TreeNode root) {
    // Same template, return level when leaf found
}
```

---

## 🎯 **PATTERN 6: BFS WITH CONSTRAINTS**

### **Problem 6: Jump Game III (Constraint BFS)**

**Problem Statement:**
Given array and start index, you can jump arr[i] steps left or right. Return true if you can reach any index with value 0.

```java
// TEMPLATE 6: BFS with Constraints
class JumpGame {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            
            // Check constraint condition
            if (arr[idx] == 0) return true;
            
            // Generate valid next states with constraints
            int jump = arr[idx];
            int left = idx - jump;
            int right = idx + jump;
            
            if (left >= 0 && !visited[left]) {
                visited[left] = true;
                queue.offer(left);
            }
            
            if (right < arr.length && !visited[right]) {
                visited[right] = true;
                queue.offer(right);
            }
        }
        
        return false;
    }
}
```

---

## 🚀 **ADVANCED BFS TEMPLATES**

### **Bidirectional BFS Template:**
```java
public int bidirectionalBFS(/* start */, /* end */) {
    Set</* StateType */> beginSet = new HashSet<>();
    Set</* StateType */> endSet = new HashSet<>();
    Set</* StateType */> visited = new HashSet<>();
    
    beginSet.add(/* start */);
    endSet.add(/* end */);
    
    int steps = 0;
    
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
        // Always expand smaller set
        if (beginSet.size() > endSet.size()) {
            Set</* StateType */> temp = beginSet;
            beginSet = endSet;
            endSet = temp;
        }
        
        Set</* StateType */> nextSet = new HashSet<>();
        
        for (/* state */ : beginSet) {
            for (/* nextState */ : /* getNeighbors */) {
                if (endSet.contains(/* nextState */)) {
                    return steps + 1; // Found intersection
                }
                
                if (visited.add(/* nextState */)) {
                    nextSet.add(/* nextState */);
                }
            }
        }
        
        beginSet = nextSet;
        steps++;
    }
    
    return -1;
}
```

### **Level Processing Template:**
```java
public /* ResultType */ levelProcessBFS(/* input */) {
    Queue</* NodeType */> queue = new LinkedList<>();
    /* initialize queue */
    
    int level = 0;
    
    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        /* LevelDataType */ levelData = /* initializeLevelData */;
        
        for (int i = 0; i < levelSize; i++) {
            /* current */ = queue.poll();
            
            // Process current node for this level
            /* processNodeForLevel */;
            
            // Add children for next level
            /* addChildrenToQueue */;
        }
        
        // Process completed level
        /* processCompletedLevel */;
        level++;
    }
    
    return /* result */;
}
```