# BFS Foundation - 7 Questions You've Mastered

## 🎯 **Level 1: Pure BFS Mechanics (Master These First)**

### **Question 1: Simple BFS Traversal**
```java
/**
 * Given a graph, print all nodes in BFS order starting from node 0.
 * 
 * Graph: 0-1-2
 *        |
 *        3
 * Expected: "0 1 3 2" (or similar BFS order)
 */
public static void bfsTraversal(List<List<Integer>> graph, int start) {
    // TODO: Implement BFS traversal
    // Use queue for level-by-level exploration
}

// Test Graph Representation:
// 0 -> [1, 3]
// 1 -> [0, 2]
// 2 -> [1]
// 3 -> [0]

// Expected Output: Visit nodes level by level
// Level 0: [0]
// Level 1: [1, 3] 
// Level 2: [2]
// Result: "0 1 3 2"
```

### **Question 2: Check if Node is Reachable**
```java
/**
 * Can you reach node B from node A?
 * Return true/false
 * 
 * Use BFS with early termination when target found
 */
public static boolean isReachable(List<List<Integer>> graph, int start, int target) {
    // TODO: Use BFS but stop early when target is found
    // Don't traverse entire graph if not needed
}

// Test Cases:
// Graph: 0-1-2, 0-3-4-5, 2-5
// isReachable(graph, 0, 5) → true (path: 0→1→2→5)
// isReachable(graph, 0, 6) → false (node 6 doesn't exist)
// isReachable(graph, 2, 4) → true (path: 2→5→4)

// Edge Cases:
// isReachable(graph, 0, 0) → true (same node)
// Empty graph → false
```

### **Question 3: Count Total Reachable Nodes**
```java
/**
 * How many nodes can you reach from the starting node?
 * 
 * Return the count of all reachable nodes (including start node)
 */
public static int countReachableNodes(List<List<Integer>> graph, int start) {
    // TODO: Run BFS and count visited nodes
    // Return size of visited set
}

// Test Cases:
// Connected graph: 0-1-2-3-4-5 → countReachableNodes(graph, 0) = 6
// Disconnected: 0-1, 2-3 → countReachableNodes(graph, 0) = 2
// Single node: [0] → countReachableNodes(graph, 0) = 1

// Graph: 0-1-2, 0-3-4-5, 2-5 (all connected)
// countReachableNodes(graph, 0) → 6 (all nodes reachable)
```

---

## 🎯 **Level 2: BFS with Distance (Build on Level 1)**

### **Question 4: Print Distance to Each Node**
```java
/**
 * Print the shortest distance from start node to every reachable node
 * 
 * Return a Map where key=node, value=shortest_distance
 */
public static Map<Integer, Integer> bfsWithDistance(List<List<Integer>> graph, int start) {
    // TODO: Track distance while doing BFS
    // Use queue to store (node, distance) pairs
}

// Test Case:
// Graph: 0-1-2, 0-3-4-5, 2-5
//        0
//       / \
//      1   3
//      |   |
//      2   4
//       \ /
//        5

// bfsWithDistance(graph, 0) should return:
// {0=0, 1=1, 3=1, 2=2, 4=2, 5=3}

// Explanation:
// Distance 0: [0] (start node)
// Distance 1: [1, 3] (direct neighbors of 0)
// Distance 2: [2, 4] (neighbors of level 1 nodes)
// Distance 3: [5] (neighbors of level 2 nodes)
```

### **Question 5: Nodes at Exactly Distance K**
```java
/**
 * Find nodes at EXACTLY distance K from start node
 * (Same as before, but now you have solid BFS foundation)
 * 
 * Return list of all nodes that are exactly K steps away
 */
public static List<Integer> nodesAtDistanceK(List<List<Integer>> graph, int start, int k) {
    // TODO: Use BFS with distance tracking
    // Stop when distance > K, collect nodes at distance = K
}

// Test Cases:
// Graph: 0-1-2, 0-3-4-5, 2-5
// nodesAtDistanceK(graph, 0, 0) → [0] (only start node)
// nodesAtDistanceK(graph, 0, 1) → [1, 3] (direct neighbors)
// nodesAtDistanceK(graph, 0, 2) → [2, 4] (2 steps away)
// nodesAtDistanceK(graph, 0, 3) → [5] (3 steps away)
// nodesAtDistanceK(graph, 0, 4) → [] (no nodes 4 steps away)

// Edge Cases:
// K = 0 → always returns [start]
// K > graph diameter → returns []
```

---

## 🎯 **Level 3: BFS with Early Termination**

### **Question 6: Is Target Reachable Within K Steps?**
```java
/**
 * Can you reach the target node within exactly K steps?
 * Return true/false
 * 
 * Different from Question 5: this asks if reachable in ≤ K steps
 */
public static boolean reachableWithinK(List<List<Integer>> graph, int start, int target, int k) {
    // TODO: BFS with distance limit
    // Return true if target found within K steps
    // Stop search when distance > K
}

// Test Cases:
// Graph: 0-1-2, 0-3-4-5, 2-5
// reachableWithinK(graph, 0, 5, 3) → true (can reach in 3 steps: 0→1→2→5)
// reachableWithinK(graph, 0, 5, 2) → false (need 3 steps, but limit is 2)
// reachableWithinK(graph, 0, 1, 1) → true (can reach in 1 step)
// reachableWithinK(graph, 0, 0, 0) → true (already at target)

// Edge Cases:
// start == target → always true (regardless of K)
// K = 0 and start != target → false
// Unreachable target → false (regardless of K)
```

### **Question 7: Shortest Path Length**
```java
/**
 * Find shortest distance between two specific nodes
 * (Same as before, but now with better foundation)
 * 
 * Return -1 if no path exists
 * Return 0 if start == target
 */
public static int shortestPathLength(List<List<Integer>> graph, int start, int target) {
    // TODO: BFS from start, return distance when target found
    // Early termination when target reached
}

// Test Cases:
// Graph: 0-1-2, 0-3-4-5, 2-5
// shortestPathLength(graph, 0, 5) → 3 (path: 0→1→2→5)
// shortestPathLength(graph, 1, 4) → 3 (path: 1→2→5→4)
// shortestPathLength(graph, 0, 0) → 0 (same node)

// Disconnected graph: 0-1, 2-3
// shortestPathLength(graph, 0, 2) → -1 (no path exists)

// This is essentially Question 2 + Question 4 combined:
// - Use reachability logic from Question 2
// - Use distance tracking from Question 4
// - Return distance instead of boolean
```

---

## **🎯 BFS Pattern Summary**

### **Core BFS Template:**
```java
public static void bfsTemplate(List<List<Integer>> graph, int start) {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[graph.size()];
    
    queue.offer(start);
    visited[start] = true;
    
    while (!queue.isEmpty()) {
        int current = queue.poll();
        
        // Process current node
        System.out.print(current + " ");
        
        // Add unvisited neighbors
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}
```

### **BFS with Distance Template:**
```java
public static void bfsWithDistanceTemplate(List<List<Integer>> graph, int start) {
    Queue<int[]> queue = new LinkedList<>(); // [node, distance]
    boolean[] visited = new boolean[graph.size()];
    
    queue.offer(new int[]{start, 0});
    visited[start] = true;
    
    while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int node = current[0];
        int distance = current[1];
        
        // Process current node with its distance
        System.out.println("Node " + node + " at distance " + distance);
        
        // Add unvisited neighbors with distance + 1
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(new int[]{neighbor, distance + 1});
            }
        }
    }
}
```

### **Key BFS Insights You've Mastered:**

1. **Level-by-level exploration** - BFS explores all nodes at distance K before exploring nodes at distance K+1

2. **Shortest path in unweighted graphs** - First time you reach a node in BFS is via shortest path

3. **Early termination** - Can stop BFS when target is found or distance limit reached

4. **Distance tracking** - By tracking levels, you get shortest distances to all reachable nodes

5. **Queue-based implementation** - FIFO queue ensures level-by-level processing

6. **Visited array** - Prevents revisiting nodes and infinite loops

7. **Time complexity: O(V + E)** - Visit each vertex once, check each edge once

8. **Space complexity: O(V)** - Queue and visited array store at most V elements

---

## **🚀 What You Can Do Now:**

✅ **Traverse any graph** using BFS  
✅ **Find shortest paths** in unweighted graphs  
✅ **Check connectivity** between nodes  
✅ **Analyze graph structure** (reachable nodes, distances)  
✅ **Optimize searches** with early termination  
✅ **Handle edge cases** (empty graphs, disconnected components, same start/target)

**You've built a solid BFS foundation! Ready for the next phase: DFS and advanced graph algorithms.**