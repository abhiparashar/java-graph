# 🛤️ Shortest Path Algorithms Mastery - Dedicated Learning Module

## 📋 **Current Status & Prerequisites**

**✅ COMPLETED FOUNDATION:**
- **BFS Mastery:** Unweighted shortest path, level-by-level traversal
- **DFS Mastery:** 9 core patterns, graph traversal techniques
- **Pattern Recognition:** BFS vs DFS decision framework (87.5% accuracy)

**🎯 LEARNING STYLE (Maintain Same Approach):**
- **Java implementations** with detailed explanations
- **Problem statement first** → attempt yourself → reference solution comparison
- **Step-by-step pattern building** with real interview problem mapping
- **Critical analysis** of "Why this approach?" and edge cases

---

## 🚀 **SHORTEST PATH ALGORITHMS - 4 CORE PATTERNS**

### **PATTERN 1: Dijkstra's Algorithm (Single Source)**
**Core Concept:** Find shortest path from one source to all other nodes in weighted graph
**Key Data Structure:** Priority Queue (Min-Heap)
**Time Complexity:** O((V + E) log V)
**When to Use:** Positive weights, single source, need all shortest distances

### **PATTERN 2: Modified Dijkstra (With Constraints)**
**Core Concept:** Dijkstra with additional constraints (stops, conditions)
**Key Insight:** Track multiple states in priority queue
**Examples:** Limited stops, path conditions, state-based shortest path

### **PATTERN 3: Dijkstra Variants (Different Objectives)**
**Core Concept:** Same algorithm structure, different optimization goals
**Examples:** Maximum probability, maximum capacity, minimum bottleneck
**Key Change:** Min-heap vs Max-heap, different comparison logic

### **PATTERN 4: Multi-Source Shortest Path**
**Core Concept:** Multiple starting points, find shortest to any source
**Implementation:** Initialize all sources with distance 0
**Use Cases:** Multiple facilities, escape routes, nearest service location

---

## 🎯 **WEEK 3: SHORTEST PATH MASTERY ROADMAP**

### **Day 1-2: Dijkstra's Algorithm Foundation**

#### **Problem 1: Dijkstra's Algorithm - Basic Implementation**
**Problem Statement:** Implement Dijkstra's algorithm to find shortest path from source to all nodes
**Pattern:** Single source shortest path with positive weights
**Key Components:**
- Priority queue for next minimum distance node
- Distance array to track shortest paths
- Visited set to avoid reprocessing
- Graph representation handling

**Your Learning Tasks:**
1. Understand why greedy choice works (optimal substructure)
2. Implement basic Dijkstra from scratch
3. Handle edge cases: disconnected nodes, self-loops
4. Compare with BFS (why BFS fails for weighted graphs)

---

### **Day 3-4: Real Interview Applications**

#### **Problem 2: Network Delay Time (LeetCode 743)**
**Problem Statement:** You have `n` network nodes labeled 1 to n. Given a list of travel times as directed edges, find the minimum time for all nodes to receive signal from source K.

**Example:**
```
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2 (max time to reach any node from node 2)
```

**Pattern Analysis:**
- **Why Dijkstra?** Weighted edges, need shortest path from single source
- **Key Insight:** Answer is maximum of all shortest distances
- **Edge Case:** If any node unreachable, return -1

**Your Task:** Implement before seeing reference solution!

---

#### **Problem 3: Cheapest Flights Within K Stops (LeetCode 787)**
**Problem Statement:** Find cheapest price from source to destination with at most K stops.

**Example:**
```
Input: flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200 (0→1→2 costs 200, within 1 stop)
```

**Pattern Analysis:**
- **Modified Dijkstra:** Track both cost AND stops count
- **State:** (node, cost, stops_used)
- **Key Insight:** May need to explore suboptimal paths due to stop constraint

**Critical Challenge:** Why regular Dijkstra fails here?

---

### **Day 5-6: Advanced Dijkstra Variants**

#### **Problem 4: Path with Maximum Probability (LeetCode 1514)**
**Problem Statement:** Find path from start to end with maximum probability of success.

**Example:**
```
Input: edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25 (path 0→1→2: 0.5 * 0.5 = 0.25)
```

**Pattern Analysis:**
- **Dijkstra Variant:** Maximize instead of minimize
- **Key Change:** Use max-heap instead of min-heap
- **Probability Math:** Multiply probabilities along path
- **Comparison:** Choose path with higher probability

---

#### **Problem 5: Minimum Effort Path (LeetCode 1631)**
**Problem Statement:** Find path from top-left to bottom-right that minimizes maximum absolute difference in heights.

**Pattern Analysis:**
- **Grid + Dijkstra:** 2D grid treated as graph
- **Effort Definition:** Maximum difference along entire path
- **Min-Max Problem:** Minimize the maximum effort

---

### **Day 7: Advanced Patterns & Interview Prep**

#### **Problem 6: Swim in Rising Water (LeetCode 778)**
**Binary Search + Dijkstra combination**

#### **Problem 7: Find the City (LeetCode 1334)**
**All-pairs shortest path with threshold**

---

## 🔧 **DIJKSTRA ALGORITHM TEMPLATE (Java)**

```java
// Standard Dijkstra Template - Memorize This!
public int[] dijkstra(int[][] graph, int source) {
    int n = graph.length;
    int[] distance = new int[n];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[source] = 0;
    
    // Priority Queue: {distance, node}
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.offer(new int[]{0, source});
    
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int currDist = curr[0];
        int currNode = curr[1];
        
        // Skip if we've found better path already
        if (currDist > distance[currNode]) continue;
        
        // Explore neighbors
        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (graph[currNode][neighbor] != 0) { // Edge exists
                int newDist = currDist + graph[currNode][neighbor];
                
                if (newDist < distance[neighbor]) {
                    distance[neighbor] = newDist;
                    pq.offer(new int[]{newDist, neighbor});
                }
            }
        }
    }
    
    return distance;
}
```

---

## 🎯 **LEARNING MILESTONES**

### **After Day 2:**
- [ ] Can implement Dijkstra's from scratch
- [ ] Understand why greedy choice works
- [ ] Handle basic weighted graph problems

### **After Day 4:**
- [ ] Solve Network Delay Time independently
- [ ] Understand constraint-based modifications
- [ ] Recognize when standard Dijkstra won't work

### **After Day 6:**
- [ ] Master Dijkstra variants (max-heap, different objectives)
- [ ] Solve grid-based shortest path problems
- [ ] Handle probability and effort-based paths

### **After Day 7:**
- [ ] 90%+ pattern recognition on shortest path problems
- [ ] Solve medium Dijkstra problems in 30-45 minutes
- [ ] Ready for advanced shortest path interviews

---

## 🚨 **COMMON MISTAKES TO AVOID**

1. **Forgetting Distance Check:** Always check `if (currDist > distance[currNode]) continue;`
2. **Wrong Priority Queue:** Use `(a, b) -> a[0] - b[0]` for min-heap
3. **Edge Weight Access:** Handle different graph representations correctly
4. **Initialization:** `Arrays.fill(distance, Integer.MAX_VALUE)`
5. **Constraint Handling:** For modified Dijkstra, track additional state correctly

---

## 💡 **QUICK START COMMAND (Copy-Paste Ready)**

```
"I've completed BFS/DFS mastery and want to learn Shortest Path Algorithms using Dijkstra's pattern.

Start with Day 1-2: Dijkstra's Algorithm Foundation, Problem 1.

Use same learning approach:
- Java implementation
- Give me problem statement first, let me attempt
- Then show reference solution with detailed analysis
- Focus on interview-ready patterns

Begin with basic Dijkstra implementation problem!"
```

---

## 🔄 **CONTINUATION COMMANDS**

**If chat gets long, use:**
```
"Continue Shortest Path Algorithms, Day [X], Problem [Y]. 
Same learning style - Java code, attempt first, then reference solution."
```
