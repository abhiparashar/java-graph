# 🎯 MINIMUM SPANNING TREE (MST) MASTERY - COMPLETE GUIDE

## 📊 **MST PATTERN OVERVIEW**
**Total MST Patterns: 4 Core Patterns**

1. **Kruskal's Algorithm** - Union-Find based, edge-focused
2. **Prim's Algorithm** - Priority Queue based, vertex-focused
3. **Modified MST** - Constraints, multiple components
4. **MST Applications** - Network design, clustering problems

---

## 🚀 **DAY 1-2: MST FOUNDATION**

### **Problem 1: Min Cost to Connect All Points**

**Problem Statement:**
Given points in 2D plane, return minimum cost to connect all points where cost between points is Manhattan distance |xi - xj| + |yi - yj|.

```
Example:
points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20

Explanation: Connect points to form MST with total cost 20
```

**🤔 Try this yourself first before seeing the solution!**

---

### **Reference Solution & Analysis:**

```java
// TEMPLATE 1: Kruskal's Algorithm (Union-Find Based)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        // Step 1: Generate all edges with weights
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + 
                          Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, cost));
            }
        }
        
        // Step 2: Sort edges by weight
        edges.sort((a, b) -> a.weight - b.weight);
        
        // Step 3: Use Union-Find to detect cycles
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        int edgesUsed = 0;
        
        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                totalCost += edge.weight;
                edgesUsed++;
                
                // MST has exactly n-1 edges
                if (edgesUsed == n - 1) break;
            }
        }
        
        return totalCost;
    }
}

// Edge class for Kruskal's
class Edge {
    int u, v, weight;
    
    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v; 
        this.weight = weight;
    }
}

// Union-Find (from previous mastery)
class UnionFind {
    private int[] parent, rank;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false;
        
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}
```

**Dry Run:**
```
Points: [[0,0],[2,2],[3,10],[5,2],[7,0]]
Edges: [(0,1,4), (0,4,7), (1,3,5), (1,4,7), (3,4,2), (0,2,13), (1,2,10), (2,3,8), (2,4,10), (0,3,9)]
Sorted: [(3,4,2), (0,1,4), (1,3,5), (0,4,7), (1,4,7), (2,3,8), ...]

Step 1: Union(3,4) → cost=2, edges=1
Step 2: Union(0,1) → cost=6, edges=2  
Step 3: Union(1,3) → cost=11, edges=3
Step 4: Union(0,4) → cost=18, edges=4 (connects 0-1 group with 3-4 group)
Result: 4 edges used, total cost = 20
```

**Key Insights:**
- **Kruskal's** = Sort edges + Union-Find for cycle detection
- **Always pick smallest edge** that doesn't create cycle
- **MST has exactly n-1 edges** for n vertices

---

## 🔄 **CORE MST TEMPLATES (Memorize These!)**

### **Template 1: Kruskal's Algorithm**
```java
public int kruskalMST(int[][] points) {
    int n = points.length;
    List<Edge> edges = new ArrayList<>();
    
    // Generate all edges
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int weight = calculateWeight(points[i], points[j]);
            edges.add(new Edge(i, j, weight));
        }
    }
    
    // Sort by weight
    edges.sort((a, b) -> a.weight - b.weight);
    
    // Use Union-Find
    UnionFind uf = new UnionFind(n);
    int totalCost = 0;
    int edgesUsed = 0;
    
    for (Edge edge : edges) {
        if (uf.union(edge.u, edge.v)) {
            totalCost += edge.weight;
            if (++edgesUsed == n - 1) break;
        }
    }
    
    return totalCost;
}
```

### **Template 2: Prim's Algorithm**
```java
public int primMST(int[][] points) {
    int n = points.length;
    boolean[] inMST = new boolean[n];
    
    // Priority queue: [weight, vertex]
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    
    // Start from vertex 0
    pq.offer(new int[]{0, 0});
    int totalCost = 0;
    
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int weight = curr[0], u = curr[1];
        
        if (inMST[u]) continue;
        
        inMST[u] = true;
        totalCost += weight;
        
        // Add all edges from u to unvisited vertices
        for (int v = 0; v < n; v++) {
            if (!inMST[v]) {
                int edgeWeight = calculateWeight(points[u], points[v]);
                pq.offer(new int[]{edgeWeight, v});
            }
        }
    }
    
    return totalCost;
}

private int calculateWeight(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
}
```

---

## 🎯 **PATTERN 1: KRUSKAL'S ALGORITHM**

**When to Use Kruskal's:**
- **Sparse graphs** (few edges)
- **Edge list given** directly
- **Need to identify specific edges** in MST
- **Union-Find already implemented**

### **Problem 2: Connecting Cities with Minimum Cost**

**Problem Statement:**
Given cities and costs to connect them, find minimum cost to connect all cities. Some cities might already be connected.

```
Example:
n = 3
connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6 (connect 2-3 with cost 1, then 1-2 with cost 5)
```

**Reference Solution:**
```java
class Solution {
    public int minimumCost(int n, int[][] connections) {
        // Convert to 0-indexed
        List<Edge> edges = new ArrayList<>();
        for (int[] conn : connections) {
            edges.add(new Edge(conn[0] - 1, conn[1] - 1, conn[2]));
        }
        
        edges.sort((a, b) -> a.weight - b.weight);
        
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        int edgesUsed = 0;
        
        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                totalCost += edge.weight;
                if (++edgesUsed == n - 1) break;
            }
        }
        
        // Check if all cities are connected
        return edgesUsed == n - 1 ? totalCost : -1;
    }
}
```

**Kruskal's vs Prim's Decision:**
- **Use Kruskal's when:**
    - Sparse graph (E << V²)
    - Edge list format
    - Need specific edges
    - Have Union-Find ready

- **Use Prim's when:**
    - Dense graph (E ≈ V²)
    - Adjacency matrix format
    - Start from specific vertex
    - Need incremental construction

---

## 🔥 **PATTERN 2: PRIM'S ALGORITHM**

**When to Use Prim's:**
- **Dense graphs** (many edges)
- **Adjacency matrix given**
- **Start from specific vertex**
- **Incremental MST construction**

### **Problem 3: Network Design (Prim's Application)**

**Problem Statement:**
Design a network connecting all computers with minimum cable cost. Start building from computer 0.

```java
// TEMPLATE: Prim's with Adjacency Matrix
class Solution {
    public int minCostNetwork(int[][] costMatrix) {
        int n = costMatrix.length;
        boolean[] inMST = new boolean[n];
        int[] minCost = new int[n];
        
        // Initialize: all costs infinite except start
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;
        
        int totalCost = 0;
        
        for (int i = 0; i < n; i++) {
            // Find minimum cost vertex not in MST
            int u = findMinVertex(minCost, inMST);
            inMST[u] = true;
            totalCost += minCost[u];
            
            // Update costs to adjacent vertices
            for (int v = 0; v < n; v++) {
                if (!inMST[v] && costMatrix[u][v] < minCost[v]) {
                    minCost[v] = costMatrix[u][v];
                }
            }
        }
        
        return totalCost;
    }
    
    private int findMinVertex(int[] minCost, boolean[] inMST) {
        int min = Integer.MAX_VALUE, minVertex = -1;
        
        for (int i = 0; i < minCost.length; i++) {
            if (!inMST[i] && minCost[i] < min) {
                min = minCost[i];
                minVertex = i;
            }
        }
        
        return minVertex;
    }
}
```

**Optimized Prim's with Priority Queue:**
```java
public int primOptimized(int[][] graph) {
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
        
        for (int v = 0; v < n; v++) {
            if (!inMST[v] && graph[u][v] != 0) {
                pq.offer(new int[]{v, graph[u][v]});
            }
        }
    }
    
    return totalCost;
}
```