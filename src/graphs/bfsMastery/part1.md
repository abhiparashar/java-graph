# 🎯 BFS GRAPH MASTERY - COMPLETE GUIDE

## 📊 **BFS PATTERN OVERVIEW**
**Total BFS Graph Patterns: 6 Core Patterns**

1. **Basic BFS Traversal** - Unweighted shortest path
2. **Multi-Source BFS** - Simultaneous starts from multiple nodes
3. **BFS with State Tracking** - Complex state management
4. **Bidirectional BFS** - Meet-in-the-middle optimization
5. **BFS Level Processing** - Level-by-level processing
6. **BFS with Constraints** - Conditional traversal

---

## 🚀 **DAY 1-2: BFS FOUNDATION**

### **Problem 1: Basic BFS - Shortest Path in Unweighted Graph**

**Problem Statement:**
Given an unweighted graph and two nodes (start, end), find the shortest path length between them. Return -1 if no path exists.

```
Example:
Graph: 0-1-2
       |   |
       3-4-5

shortestPath(graph, 0, 5) = 3 (path: 0→1→2→5)
```

**🤔 Try this yourself first before seeing the solution!**

---

### **Reference Solution & Analysis:**

```java
// TEMPLATE 1: Basic BFS Traversal
import java.util.*;

class BFSBasic {
    public int shortestPath(List<List<Integer>> graph, int start, int end) {
        if (start == end) return 0;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        
        queue.offer(start);
        visited[start] = true;
        int distance = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            
            // Process all nodes at current level
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                
                // Explore neighbors
                for (int neighbor : graph.get(node)) {
                    if (neighbor == end) return distance;
                    
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        return -1; // No path found
    }
}
```

**Dry Run:**
```
Graph: 0-1-2, 0-3, 1-2, 3-4, 2-5, 4-5
Start: 0, End: 5

Level 0: queue=[0], visited=[T,F,F,F,F,F]
Level 1: queue=[1,3], visited=[T,T,F,T,F,F], distance=1
Level 2: queue=[2,4], visited=[T,T,T,T,F,F], distance=2
Level 3: queue=[5], visited=[T,T,T,T,F,T], distance=3
Found target 5! Return distance=3
```

**Key Insights:**
- **Level-by-level processing** ensures shortest path
- **Visited array** prevents cycles
- **Early termination** when target found

---

## 🔄 **CORE BFS TEMPLATE (Memorize This!)**

```java
// UNIVERSAL BFS TEMPLATE
public int bfs(/* parameters */) {
    Queue</* NodeType */> queue = new LinkedList<>();
    Set</* StateType */> visited = new HashSet<>();
    
    // Initialize
    queue.offer(/* startState */);
    visited.add(/* startState */);
    int steps = 0;
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        
        for (int i = 0; i < size; i++) {
            /* currentState */ = queue.poll();
            
            if (/* isTarget */) return steps;
            
            for (/* nextState */ : /* getNeighbors */) {
                if (!visited.contains(/* nextState */)) {
                    visited.add(/* nextState */);
                    queue.offer(/* nextState */);
                }
            }
        }
        steps++;
    }
    
    return -1; // Not found
}
```

---

## 🎯 **PATTERN 1: BASIC BFS TRAVERSAL**

**When to Use:**
- Unweighted graph shortest path
- Level-by-level exploration needed
- Minimum steps/moves problems

**Template Modifications:**
```java
// For returning path instead of distance
Map<Integer, Integer> parent = new HashMap<>();
// Track parent during BFS, then reconstruct path

// For multiple targets
Set<Integer> targets = new HashSet<>();
// Check if current node in targets set

// For counting reachable nodes
int count = 0;
// Increment count for each visited node
```

**Common Interview Applications:**
- Word Ladder
- Minimum Knight Moves
- Open the Lock
- Perfect Squares
- Snakes and Ladders