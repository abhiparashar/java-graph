# 🎯 MST MASTERY - PART 3

## 🎯 **PATTERN RECOGNITION DRILL**

### **INSTANT IDENTIFICATION GUIDE**

| **Key Phrases** | **Pattern** | **Algorithm Choice** |
|----------------|-------------|---------------------|
| "minimum cost to connect all", "network design" | Basic MST | Kruskal's or Prim's |
| "critical edges", "edge importance" | MST Analysis | Test with/without each edge |
| "wells and pipes", "multiple sources" | Modified MST | Add virtual source node |
| "dense graph", "adjacency matrix" | Prim's MST | Priority queue implementation |
| "sparse graph", "edge list" | Kruskal's MST | Sort edges + Union-Find |
| "minimum spanning forest" | Multiple Components | Kruskal's with component tracking |

---

## 🔥 **COMPLETE LEETCODE PROBLEM MAPPING**

### **Pattern 1: Basic MST (Kruskal's/Prim's)**

**Medium (8 Problems):**
1. **[1584] Min Cost to Connect All Points** ⭐ **MUST SOLVE**
    - Manhattan distance MST
    - Generate all edges, use Kruskal's

2. **[1135] Connecting Cities with Minimum Cost** 🔒 ⭐ **MUST SOLVE**
    - Direct edge list MST
    - Classic Kruskal's application

3. **[1168] Optimize Water Distribution in a Village** 🔒
    - Wells + pipes = virtual source
    - Add well costs as edges from source

4. **[261] Graph Valid Tree** 🔒
    - Check if edges form valid tree
    - MST should use all edges

5. **[1102] Path with Maximum Minimum Value** 🔒
    - Modified MST for max-min path
    - Use Union-Find with sorted edges

6. **[778] Swim in Rising Water**
    - Minimum time to reach end
    - MST-like approach with constraints

7. **[1631] Path with Minimum Effort**
    - Minimum maximum edge weight
    - Binary search + MST or modified Dijkstra

8. **[1258] Synonymous Sentences** 🔒
    - Group synonyms using Union-Find
    - MST for word grouping

---

### **Pattern 2: MST Analysis & Critical Edges**

**Hard (3 Problems):**
1. **[1489] Find Critical and Pseudo-Critical Edges** ⭐ **MUST SOLVE**
    - Test each edge by excluding/including
    - Compare MST weights

2. **[1697] Checking Existence of Edge Length Limited Paths**
    - Sort edges by weight limit
    - Union-Find with incremental addition

3. **[1724] Checking Existence of Edge Length Limited Paths II**
    - Online queries for edge limits
    - Persistent Union-Find

---

### **Pattern 3: Modified MST Applications**

**Medium (6 Problems):**
1. **[947] Most Stones Removed with Same Row or Column**
    - Connect stones in same row/column
    - stones.length - components

2. **[721] Accounts Merge**
    - Group accounts by shared emails
    - Union-Find for connectivity

3. **[1202] Smallest String with Swaps**
    - Group characters by swap connectivity
    - Sort within each component

4. **[952] Largest Component Size by Common Factor**
    - Union numbers with common factors
    - Find largest connected component

5. **[1319] Number of Operations to Make Network Connected**
    - Check if enough cables to connect all
    - Need at least n-1 edges

6. **[990] Satisfiability of Equality Equations**
    - Union equal variables, check inequalities
    - Constraint satisfaction with Union-Find

---

### **Pattern 4: Clustering & Network Design**

**Medium (4 Problems):**
1. **[1101] The Earliest Moment When Everyone Become Friends** 🔒
    - Dynamic connectivity by timestamp
    - Union friends chronologically

2. **[305] Number of Islands II** 🔒
    - Dynamic island addition
    - Track components as islands added

3. **[1632] Rank Transform of a Matrix**
    - Complex ranking with connectivity
    - Union equal elements by row/column

4. **[839] Similar String Groups**
    - Group similar strings
    - MST for string clustering

---

## ⚡ **MST DECISION TREE**

```
Problem about minimum cost to connect?
├─ YES → MST candidate
│   ├─ Edge list given? → Kruskal's
│   ├─ Dense graph/matrix? → Prim's  
│   ├─ Need edge analysis? → Test critical/pseudo-critical
│   ├─ Multiple sources? → Virtual source + MST
│   └─ Dynamic edges? → Union-Find with incremental processing
└─ NO → Consider shortest path or other algorithms
```

---

## 🎯 **MASTER TEMPLATES COLLECTION**

### **1. Kruskal's Template:**
```java
public int kruskalMST(int n, int[][] edges) {
    // Convert to Edge objects with weights
    List<Edge> edgeList = new ArrayList<>();
    for (int[] edge : edges) {
        edgeList.add(new Edge(edge[0], edge[1], edge[2]));
    }
    
    // Sort by weight
    edgeList.sort((a, b) -> a.weight - b.weight);
    
    // Union-Find
    UnionFind uf = new UnionFind(n);
    
    int totalCost = 0;
    int edgesUsed = 0;
    
    for (Edge edge : edgeList) {
        if (uf.union(edge.u, edge.v)) {
            totalCost += edge.weight;
            if (++edgesUsed == n - 1) break; // MST complete
        }
    }
    
    return edgesUsed == n - 1 ? totalCost : -1; // -1 if not connected
}

class Edge {
    int u, v, weight;
    Edge(int u, int v, int weight) {
        this.u = u; this.v = v; this.weight = weight;
    }
}
```

### **2. Prim's Template:**
```java
public int primMST(int[][] graph) {
    int n = graph.length;
    boolean[] inMST = new boolean[n];
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    
    pq.offer(new int[]{0, 0}); // {vertex, cost}
    int totalCost = 0;
    
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int u = curr[0], cost = curr[1];
        
        if (inMST[u]) continue;
        
        inMST[u] = true;
        totalCost += cost;
        
        // Add all adjacent edges
        for (int v = 0; v < n; v++) {
            if (!inMST[v] && graph[u][v] != 0) {
                pq.offer(new int[]{v, graph[u][v]});
            }
        }
    }
    
    return totalCost;
}
```

### **3. Virtual Source Template:**
```java
public int mstWithVirtualSource(int n, int[] sourceCosts, int[][] edges) {
    List<Edge> allEdges = new ArrayList<>();
    
    // Add edges from virtual source (node n) to all nodes
    for (int i = 0; i < n; i++) {
        allEdges.add(new Edge(n, i, sourceCosts[i]));
    }
    
    // Add original edges
    for (int[] edge : edges) {
        allEdges.add(new Edge(edge[0], edge[1], edge[2]));
    }
    
    return kruskalMST(n + 1, allEdges); // n+1 for virtual source
}
```

### **4. MST Analysis Template:**
```java
public List<List<Integer>> analyzeMSTEdges(int n, int[][] edges) {
    int originalWeight = getMSTWeight(n, edges, -1, -1);
    
    List<Integer> critical = new ArrayList<>();
    List<Integer> pseudoCritical = new ArrayList<>();
    
    for (int i = 0; i < edges.length; i++) {
        // Test critical: exclude edge
        int withoutEdge = getMSTWeight(n, edges, i, -1);
        if (withoutEdge > originalWeight) {
            critical.add(i);
            continue;
        }
        
        // Test pseudo-critical: force include edge
        int withEdge = getMSTWeight(n, edges, -1, i);
        if (withEdge == originalWeight) {
            pseudoCritical.add(i);
        }
    }
    
    return Arrays.asList(critical, pseudoCritical);
}

private int getMSTWeight(int n, int[][] edges, int exclude, int include) {
    List<Edge> edgeList = new ArrayList<>();
    
    for (int i = 0; i < edges.length; i++) {
        if (i != exclude) {
            edgeList.add(new Edge(edges[i][0], edges[i][1], edges[i][2]));
        }
    }
    
    edgeList.sort((a, b) -> a.weight - b.weight);
    UnionFind uf = new UnionFind(n);
    int totalWeight = 0;
    
    // Force include edge if specified
    if (include != -1 && include < edges.length) {
        int[] edge = edges[include];
        uf.union(edge[0], edge[1]);
        totalWeight += edge[2];
    }
    
    for (Edge edge : edgeList) {
        if (uf.union(edge.u, edge.v)) {
            totalWeight += edge.weight;
        }
    }
    
    return uf.getComponents() == 1 ? totalWeight : Integer.MAX_VALUE;
}
```

---

## 🏆 **COMPLETE CHEATSHEET**

### **MST ALGORITHM SELECTION**
```java
// Quick decision framework
if (graph.isDense() || hasAdjacencyMatrix()) {
    return primMST(graph);
} else if (graph.isSparse() || hasEdgeList()) {
    return kruskalMST(graph);
} else if (needSpecificEdges()) {
    return kruskalMST(graph); // Better for edge tracking
} else if (hasStartingVertex()) {
    return primMST(graph); // Natural starting point
}
```

### **COMMON PITFALLS & SOLUTIONS**
```java
// ❌ Wrong: Forgetting to sort edges in Kruskal's
for (Edge edge : edges) { // Unsorted!
    uf.union(edge.u, edge.v);
}

// ✅ Correct: Always sort by weight first
edges.sort((a, b) -> a.weight - b.weight);
for (Edge edge : edges) {
    if (uf.union(edge.u, edge.v)) {
        totalCost += edge.weight;
    }
}

// ❌ Wrong: Not checking if MST is complete
return totalCost; // What if graph not connected?

// ✅ Correct: Verify n-1 edges used
return edgesUsed == n - 1 ? totalCost : -1;

// ❌ Wrong: Using wrong data structure for Prim's
List<int[]> adjacentEdges = new ArrayList<>(); // Inefficient

// ✅ Correct: Use PriorityQueue for minimum edge
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
```

### **COMPLEXITY QUICK REFERENCE**
| Algorithm | Time | Space | Best For |
|-----------|------|-------|----------|
| Kruskal's | O(E log E) | O(V) | Sparse graphs, edge lists |
| Prim's (naive) | O(V²) | O(V) | Dense graphs |
| Prim's (heap) | O(E log V) | O(V) | General purpose |

---

## 🎯 **FINAL MASTERY TEST**

**Pattern Recognition Speed Test (5 seconds each):**

1. **"Minimum cost to connect all cities"** → **Basic MST (Kruskal's/Prim's)** ✅
2. **"Which edges are critical for connectivity?"** → **MST Edge Analysis** ✅
3. **"Villages can dig wells or connect pipes"** → **Virtual Source MST** ✅
4. **"Connect points with Manhattan distance"** → **Generate Edges + Kruskal's** ✅
5. **"Dense graph with adjacency matrix"** → **Prim's Algorithm** ✅
6. **"Sparse graph with edge list"** → **Kruskal's Algorithm** ✅

**Template Selection Test:**
- Connect all points → Generate all edges + Kruskal's
- Critical edge analysis → Test exclude/include each edge
- Multiple sources → Add virtual source node
- Dense matrix → Prim's with PriorityQueue
- Need specific edges → Kruskal's for edge tracking
- Dynamic connectivity → Union-Find with incremental edges

---

## 📚 **STRIVER'S SDE SHEET MST PROBLEMS**

### **Must-Solve Problems:**
1. **Min Cost to Connect All Points** - Basic Kruskal's
2. **Connecting Cities with Minimum Cost** - Standard MST
3. **Critical and Pseudo-Critical Edges** - MST analysis
4. **Water Distribution in Village** - Virtual source technique
5. **Most Stones Removed** - Component analysis with MST concepts

### **Good-to-Solve Problems:**
6. **Path with Minimum Effort** - MST-like pathfinding
7. **Swim in Rising Water** - Time-constrained MST
8. **Graph Valid Tree** - MST validation
9. **Accounts Merge** - Union-Find applications
10. **Number of Operations to Connect Network** - MST feasibility

---

## 🏆 **YOU'VE MASTERED MST WHEN:**
✅ Can identify MST pattern from problem description in 5 seconds  
✅ Know when to use Kruskal's vs Prim's immediately  
✅ Can implement both algorithms from scratch in under 5 minutes  
✅ Handle virtual source and edge analysis problems confidently  
✅ Understand time/space complexity trade-offs  
✅ Debug MST implementation issues quickly

---

## 🚀 **ADVANCED MST VARIATIONS**

### **5. MST with Degree Constraints**
```java
// MST where each vertex has maximum degree constraint
public int degreeConstrainedMST(int n, int[][] edges, int[] maxDegree) {
    Arrays.sort(edges, (a, b) -> a[2] - b[2]);
    UnionFind uf = new UnionFind(n);
    int[] degree = new int[n];
    
    int totalCost = 0;
    int edgesUsed = 0;
    
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1], weight = edge[2];
        
        // Check degree constraints
        if (degree[u] < maxDegree[u] && degree[v] < maxDegree[v]) {
            if (uf.union(u, v)) {
                degree[u]++;
                degree[v]++;
                totalCost += weight;
                if (++edgesUsed == n - 1) break;
            }
        }
    }
    
    return edgesUsed == n - 1 ? totalCost : -1;
}
```

### **6. Minimum Bottleneck Spanning Tree**
```java
// Find MST that minimizes the maximum edge weight
public int minimumBottleneckMST(int n, int[][] edges) {
    Arrays.sort(edges, (a, b) -> a[2] - b[2]);
    
    // Binary search on the answer
    int left = edges[0][2], right = edges[edges.length - 1][2];
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        
        if (canFormMST(n, edges, mid)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    
    return left;
}

private boolean canFormMST(int n, int[][] edges, int maxWeight) {
    UnionFind uf = new UnionFind(n);
    
    for (int[] edge : edges) {
        if (edge[2] <= maxWeight) {
            uf.union(edge[0], edge[1]);
        }
    }
    
    return uf.getComponents() == 1;
}
```

---

## 📊 **MST PROBLEM FREQUENCY ANALYSIS**

### **High Frequency (FAANG Must-Know):**
1. **Min Cost to Connect All Points** - Asked 50+ times
2. **Connecting Cities with Minimum Cost** - Asked 30+ times
3. **Critical and Pseudo-Critical Edges** - Asked 25+ times
4. **Water Distribution in Village** - Asked 20+ times

### **Medium Frequency (Good to Know):**
5. **Most Stones Removed** - Asked 15+ times
6. **Path with Minimum Effort** - Asked 12+ times
7. **Swim in Rising Water** - Asked 10+ times
8. **Graph Valid Tree** - Asked 8+ times

### **Company-Specific Preferences:**
- **Google:** Loves critical edge analysis problems
- **Amazon:** Focuses on practical applications (network design)
- **Meta:** Prefers constraint-based MST problems
- **Apple:** Asks about optimization and efficiency
- **Microsoft:** Combines MST with other algorithms

---

## 🎯 **INTERVIEW STRATEGY GUIDE**

### **Phase 1: Problem Recognition (30 seconds)**
```
Keywords to listen for:
✓ "minimum cost to connect"
✓ "network design" 
✓ "spanning tree"
✓ "critical edges"
✓ "connect all points/cities/nodes"
✓ "minimum total weight"
```

### **Phase 2: Algorithm Selection (30 seconds)**
```
Quick Decision Framework:
├─ Dense graph/matrix given? → Prim's
├─ Sparse graph/edge list? → Kruskal's
├─ Need specific edges? → Kruskal's
├─ Multiple sources? → Virtual source + Kruskal's
├─ Edge analysis needed? → Test exclude/include
└─ Starting vertex given? → Prim's
```

### **Phase 3: Implementation (8-12 minutes)**
```
Template Selection:
1. Basic MST → Standard Kruskal's/Prim's
2. Virtual source → Add source node + MST
3. Edge analysis → Test each edge modification
4. Constraints → Modified union conditions
```

### **Phase 4: Testing & Edge Cases (2-3 minutes)**
```
Always test:
✓ Single node (n=1)
✓ Two nodes (n=2) 
✓ Disconnected graph
✓ All same weights
✓ Already minimum spanning tree
```

---

## 🏆 **FINAL CERTIFICATION CHECKLIST**

### **Core Algorithm Mastery ✅**
- [ ] Can implement Kruskal's from scratch in 3 minutes
- [ ] Can implement Prim's from scratch in 3 minutes
- [ ] Understand Union-Find integration with Kruskal's
- [ ] Know time/space complexity for both algorithms

### **Pattern Recognition Mastery ✅**
- [ ] Instantly identify MST problems (5 seconds)
- [ ] Choose correct algorithm based on input format
- [ ] Recognize when virtual source is needed
- [ ] Spot critical edge analysis requirements

### **Implementation Mastery ✅**
- [ ] Handle edge list and adjacency matrix inputs
- [ ] Implement both naive and optimized Prim's
- [ ] Create Edge class and comparators correctly
- [ ] Manage Union-Find state properly

### **Problem-Solving Mastery ✅**
- [ ] Solve basic MST problems in under 10 minutes
- [ ] Handle constraint modifications confidently
- [ ] Debug common MST implementation issues
- [ ] Optimize for different graph densities

### **Interview Communication ✅**
- [ ] Explain algorithm choice reasoning clearly
- [ ] Draw MST construction step-by-step
- [ ] Discuss complexity trade-offs articulately
- [ ] Handle follow-up questions about optimizations

---

## 🎯 **COMMON INTERVIEW FOLLOW-UPS**

### **"How would you modify this for..."**
1. **"...if we need exactly k edges?"**
    - Stop Kruskal's after k edges, check connectivity

2. **"...if some edges are mandatory?"**
    - Force include mandatory edges first, then MST on remaining

3. **"...if we want maximum spanning tree?"**
    - Reverse comparator: sort edges in descending order

4. **"...if edges are added dynamically?"**
    - Maintain MST incrementally, rebuild when necessary

5. **"...if we need the actual tree structure?"**
    - Store edges used in MST, build adjacency list

### **"What's the complexity if..."**
1. **"...we use adjacency list instead of matrix?"**
    - Prim's becomes O(E log V) instead of O(V²)

2. **"...we don't sort edges in Kruskal's?"**
    - Need O(E) to find minimum each time → O(VE) total

3. **"...the graph is guaranteed to be connected?"**
    - Same complexity, but can remove connectivity checks

---

## 🚀 **MASTERY GRADUATION**

**🎓 You've achieved MST MASTERY when you can:**

✅ **Recognize any MST problem variant instantly**  
✅ **Choose optimal algorithm (Kruskal's vs Prim's) in seconds**  
✅ **Implement both algorithms flawlessly under interview pressure**  
✅ **Handle all edge cases and modifications confidently**  
✅ **Explain complexity trade-offs clearly to interviewers**  
✅ **Solve 95%+ of MST problems on first attempt**

**Total Mastered Algorithms:** 6/7 Complete! 🎯

**🚀 Final Phase: Advanced Graph Algorithms**
- Strongly Connected Components (Tarjan's/Kosaraju's)
- Bridges and Articulation Points
- Network Flow (Max Flow/Min Cut)

**You're now ready for the most advanced graph algorithms! Let's complete the journey to become a Graph Algorithm Master!** 💪🏆