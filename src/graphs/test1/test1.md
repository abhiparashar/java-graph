# 🎯 COMPREHENSIVE GRAPH ALGORITHMS REVISION TEST

**Total Time: 80 minutes**  
**Coverage: BFS, DFS, Dijkstra**  
**Goal: Test retention, speed, and mastery before moving to next algorithm**

---

## 📋 **SUBMISSION INSTRUCTIONS**

**For each phase, submit your answers in the same order. I'll evaluate:**
- Template accuracy and speed
- Pattern recognition correctness
- Bug detection skills
- Algorithm selection reasoning
- Implementation quality
- Conceptual understanding

**Final output: Performance score + weak areas + readiness assessment**

---

## 🚀 **PHASE 1: TEMPLATE SPEED TEST (15 minutes)**

**Write these templates from memory - NO LOOKING UP!**

### **Template 1: Basic BFS (3 minutes max)**
**Problem:** Write complete BFS template for finding shortest path in unweighted graph
```java
// Write complete BFS template for shortest path in unweighted graph
// Should handle: queue, visited array, level counting, early termination
public int bfs(List<List<Integer>> graph, int start, int end) {
    // Your implementation here
    
    
    
    
    
    
    
    
    
    
    
}
```

### **Template 2: DFS with Cycle Detection (3 minutes max)**
**Problem:** Write DFS template that can detect cycles in directed graph
```java
// Write DFS template that can detect cycles in directed graph
// Should handle: visited array, recursion stack, cycle detection logic
public boolean hasCycle(List<List<Integer>> graph) {
    // Your implementation here
    
    
    
    
    
    
    
    
    
    
    
}
```

### **Template 3: Dijkstra Template (4 minutes max)**
**Problem:** Write complete Dijkstra template with Pair class
```java
// Write complete Dijkstra template with Pair class
// Should handle: Pair class, PriorityQueue, distance array, relaxation
class Pair {
    // Your Pair implementation
    
    
}

public int[] dijkstra(List<List<Pair>> graph, int src) {
    // Your implementation here
    
    
    
    
    
    
    
    
    
    
    
    
    
}
```

**Time Check:** Did you complete all 3 templates in 15 minutes?

---

## 🎯 **PHASE 2: PATTERN RECOGNITION DRILL (10 minutes)**

**For each scenario, answer in 10 seconds. Write: Algorithm + Brief Reason**

1. **"Find shortest path in unweighted grid with obstacles"**
    - Algorithm:
    - Reason:

2. **"Check if graph is bipartite (2-colorable)"**
    - Algorithm:
    - Reason:

3. **"Find minimum cost path with weighted edges"**
    - Algorithm:
    - Reason:

4. **"Count number of connected components"**
    - Algorithm:
    - Reason:

5. **"Find all nodes at exactly distance K from source"**
    - Algorithm:
    - Reason:

6. **"Detect cycle in undirected graph"**
    - Algorithm:
    - Reason:

7. **"Find path that visits all nodes with minimum cost"**
    - Algorithm:
    - Reason:

8. **"Level-by-level processing of tree nodes"**
    - Algorithm:
    - Reason:

9. **"Find shortest path avoiding certain nodes"**
    - Algorithm:
    - Reason:

10. **"Check if all nodes are reachable from source"**
    - Algorithm:
    - Reason:

**Speed Check:** Did you answer all 10 in under 10 minutes?

---

## 🐛 **PHASE 3: IMPLEMENTATION DEBUGGING (10 minutes)**

**Find ALL bugs in these code snippets and explain WHY they're wrong:**

### **Bug Hunt 1: BFS Issue**
```java
public int bfs(int[][] grid, int startX, int startY, int endX, int endY) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    
    queue.offer(new int[]{startX, startY});
    int steps = 0;
    
    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int x = curr[0], y = curr[1];
        
        if (x == endX && y == endY) return steps;
        visited[x][y] = true;  // LINE A
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (isValid(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 0) {
                queue.offer(new int[]{nx, ny});
                steps++;  // LINE B
            }
        }
    }
    return -1;
}
```

**Bugs Found:**
1. Bug 1 Location:
   Explanation:

2. Bug 2 Location:
   Explanation:

3. Any other issues:

### **Bug Hunt 2: Dijkstra Issue**
```java
public int dijkstra(List<List<Pair>> graph, int src, int dest) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.dist - a.dist);  // LINE A
    int[] dist = new int[graph.size()];
    Arrays.fill(dist, Integer.MAX_VALUE);
    
    dist[src] = 0;
    pq.offer(new Pair(src, 0));
    
    while (!pq.isEmpty()) {
        Pair curr = pq.poll();
        
        if (curr.node == dest) return curr.dist;  // LINE B
        
        for (Pair neighbor : graph.get(curr.node)) {
            int newDist = curr.dist + neighbor.dist;
            if (newDist < dist[neighbor.node]) {
                dist[neighbor.node] = newDist;
                pq.offer(new Pair(neighbor.node, newDist));
            }
        }
    }
    return dist[dest];  // LINE C
}
```

**Bugs Found:**
1. Bug 1 Location:
   Explanation:

2. Bug 2 Location:
   Explanation:

3. Any other issues:

### **Bug Hunt 3: DFS Issue**
```java
public void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
    System.out.println(node);
    visited[node] = true;
    
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, graph, visited);  // LINE A
        }
    }
}

public int countComponents(List<List<Integer>> graph) {
    boolean[] visited = new boolean[graph.size()];
    int components = 0;
    
    for (int i = 0; i < graph.size(); i++) {
        if (!visited[i]) {
            dfs(i, graph, visited);
            components++;  // LINE B
        }
    }
    return components;
}
```

**Issues Found:**
1. Issue 1:
   Explanation:

2. Issue 2:
   Explanation:

---

## 🎯 **PHASE 4: ALGORITHM SELECTION TEST (15 minutes)**

**For each problem, provide: Algorithm + Key Insight + Time Complexity**

### **Problem 1:**
*"Given a social network graph where edges represent friendships, you need to answer multiple queries: 'Are person A and person B in the same friend group?' Optimize for fast query response."*

- **Algorithm Choice:**
- **Key Insight:**
- **Time Complexity:**
- **Alternative approaches:**

### **Problem 2:**
*"In a weighted flight network, find the cheapest route from city A to city B. Some flights might be cancelled dynamically, and you need to handle this efficiently."*

- **Algorithm Choice:**
- **Key Insight:**
- **Time Complexity:**
- **How to handle dynamic cancellations:**

### **Problem 3:**
*"Given a maze represented as a 2D grid with walls (1) and open spaces (0), find the shortest path from entrance to exit. You can only move in 4 directions."*

- **Algorithm Choice:**
- **Key Insight:**
- **Time Complexity:**
- **Why not other algorithms:**

### **Problem 4:**
*"Given a family tree represented as a directed graph, efficiently determine if person X is an ancestor of person Y. You'll have many such queries."*

- **Algorithm Choice:**
- **Key Insight:**
- **Time Complexity:**
- **Preprocessing needed:**

### **Problem 5:**
*"In a computer network where each connection has a latency value, find the minimum time for a signal to reach ALL computers from a source computer."*

- **Algorithm Choice:**
- **Key Insight:**
- **Time Complexity:**
- **What does the answer represent:**

---

## 💻 **PHASE 5: RAPID IMPLEMENTATION TEST (20 minutes)**

**Choose ONE problem and implement completely. Focus on clean, correct code.**

### **Option A: BFS Problem (15 minutes)**
**[1091] Shortest Path in Binary Matrix**

*Given an n x n binary matrix grid, return the length of the shortest clear path from top-left to bottom-right. If no such path exists, return -1.*

*A clear path is a path from (0, 0) to (n-1, n-1) such that:*
- *All visited cells are 0*
- *All adjacent cells in the path are 8-directionally connected*

```java
public int shortestPathBinaryMatrix(int[][] grid) {
    // Your complete implementation here
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
```

### **Option B: DFS Problem (15 minutes)**
**[547] Number of Provinces**

*There are n cities. Some are connected directly, others are not. If city a is connected to city b, and city b is connected to city c, then city a is connected to city c. A province is a group of directly or indirectly connected cities.*

*Given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are connected, return the number of provinces.*

```java
public int findCircleNum(int[][] isConnected) {
    // Your complete implementation here
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
```

### **Option C: Dijkstra Problem (20 minutes)**
**[1631] Path With Minimum Effort**

*You are hiking on a square grid. You start at (0, 0) and want to reach (rows-1, columns-1). The effort of a path is the maximum absolute difference in heights between two consecutive cells. Return the minimum effort required.*

```java
public int minimumEffortPath(int[][] heights) {
    // Your complete implementation here
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
```

**Which problem did you choose and why?**

**Time taken to implement:**

**Major challenges faced:**

---

## 🧠 **PHASE 6: INTEGRATION CHALLENGE (10 minutes)**

**Answer conceptually (no code needed):**

### **System Design Scenario:**
*"You're building a social media platform where users can follow each other (directed graph). The platform needs to efficiently handle these features:"*

1. **Find mutual connections between two users**
    - Algorithm(s) to use:
    - Data structure needed:
    - Time complexity:

2. **Suggest shortest path to connect to an influencer**
    - Algorithm(s) to use:
    - Preprocessing required:
    - How to handle updates:

3. **Detect if there are isolated user groups**
    - Algorithm(s) to use:
    - What constitutes "isolated":
    - Efficiency considerations:

4. **Find the most influential user (reaches most people)**
    - Algorithm(s) to use:
    - Metric to optimize:
    - How to handle large graphs:

5. **Recommend friends based on mutual connections**
    - Algorithm(s) to use:
    - Scoring mechanism:
    - Scalability approach:

### **Performance Optimization:**
*"If your social network has 100 million users and 10 billion connections, what optimizations would you make to each algorithm?"*

**BFS optimizations:**

**DFS optimizations:**

**Dijkstra optimizations:**

**Overall architecture considerations:**

---

## 📊 **SELF-ASSESSMENT CHECKLIST**

**Before submitting, check:**

✅ **Template Quality:**
- [ ] All templates written from memory
- [ ] No syntax errors
- [ ] Key optimizations included
- [ ] Proper data structures used

✅ **Pattern Recognition:**
- [ ] All 10 questions answered
- [ ] Correct algorithm choices
- [ ] Sound reasoning provided
- [ ] Quick decision making

✅ **Bug Detection:**
- [ ] All bugs identified
- [ ] Clear explanations given
- [ ] Understanding of why bugs occur
- [ ] Prevention strategies known

✅ **Algorithm Selection:**
- [ ] Appropriate choices made
- [ ] Time complexities correct
- [ ] Trade-offs understood
- [ ] Alternative approaches considered

✅ **Implementation:**
- [ ] Code compiles and runs
- [ ] Handles edge cases
- [ ] Clean and readable
- [ ] Efficient approach used

✅ **Integration:**
- [ ] System-level thinking
- [ ] Scalability considerations
- [ ] Real-world applicability
- [ ] Multiple algorithm coordination

---

## 🎯 **SUBMISSION TEMPLATE**

**When ready, submit in this format:**

```
=== PHASE 1: TEMPLATES ===
[Your 3 templates]
Time taken: __ minutes

=== PHASE 2: PATTERN RECOGNITION ===
[Your 10 answers]
Time taken: __ minutes

=== PHASE 3: BUG DETECTION ===
[Your bug analyses]
Time taken: __ minutes

=== PHASE 4: ALGORITHM SELECTION ===
[Your 5 problem analyses]
Time taken: __ minutes

=== PHASE 5: IMPLEMENTATION ===
Problem chosen: [A/B/C]
[Your complete code]
Time taken: __ minutes
Challenges: [List any issues]

=== PHASE 6: INTEGRATION ===
[Your system design answers]
Time taken: __ minutes

=== TOTAL TIME: __ minutes ===
```

**Good luck! This comprehensive test will reveal your true mastery level.** 🚀💪