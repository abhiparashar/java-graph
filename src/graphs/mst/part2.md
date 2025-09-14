# 🎯 MST MASTERY - PART 2

## 🔥 **PATTERN 3: MODIFIED MST PROBLEMS**

### **Problem 4: Critical and Pseudo-Critical Edges**

**Problem Statement:**
Given a weighted graph, find:
1. **Critical edges** - removing them increases MST weight
2. **Pseudo-critical edges** - can be part of some MST but not all

```
Example:
n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
Output: [[0,1],[2,3,4,5]] (critical: [0,1], pseudo-critical: [2,3,4,5])
```

**🤔 Key Insight: Test each edge by excluding/including it in MST!**

**Reference Solution:**
```java
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // Add original index to edges for tracking
        int[][] edgesWithIndex = new int[edges.length][4];
        for (int i = 0; i < edges.length; i++) {
            edgesWithIndex[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }
        
        // Get original MST weight
        int originalMSTWeight = getMSTWeight(n, edgesWithIndex, -1, -1);
        
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();
        
        for (int i = 0; i < edges.length; i++) {
            // Test if edge is critical (excluding it increases weight)
            int weightWithoutEdge = getMSTWeight(n, edgesWithIndex, i, -1);
            if (weightWithoutEdge > originalMSTWeight) {
                critical.add(i);
                continue;
            }
            
            // Test if edge is pseudo-critical (forcing it doesn't increase weight)
            int weightWithEdge = getMSTWeight(n, edgesWithIndex, -1, i);
            if (weightWithEdge == originalMSTWeight) {
                pseudoCritical.add(i);
            }
        }
        
        return Arrays.asList(critical, pseudoCritical);
    }
    
    private int getMSTWeight(int n, int[][] edges, int excludeEdge, int includeEdge) {
        UnionFind uf = new UnionFind(n);
        int weight = 0;
        
        // Force include edge if specified
        if (includeEdge != -1) {
            int[] edge = edges[includeEdge];
            uf.union(edge[0], edge[1]);
            weight += edge[2];
        }
        
        // Sort edges by weight
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        
        for (int[] edge : edges) {
            int originalIndex = edge[3];
            if (originalIndex == excludeEdge) continue;
            
            if (uf.union(edge[0], edge[1])) {
                weight += edge[2];
            }
        }
        
        // Check if MST is complete
        return uf.getComponents() == 1 ? weight : Integer.MAX_VALUE;
    }
}
```

**Template for Edge Analysis:**
```java
// MST Edge Classification Template
public class MSTAnalyzer {
    public boolean isCritical(int n, int[][] edges, int targetEdge) {
        int originalWeight = getMSTWeight(n, edges, -1);
        int withoutEdge = getMSTWeight(n, edges, targetEdge);
        return withoutEdge > originalWeight;
    }
    
    public boolean isPseudoCritical(int n, int[][] edges, int targetEdge) {
        int originalWeight = getMSTWeight(n, edges, -1);
        int withForcedEdge = getMSTWeightWithForced(n, edges, targetEdge);
        return withForcedEdge == originalWeight;
    }
}
```

---

## ⚡ **PATTERN 4: MST APPLICATIONS**

### **Problem 5: Water Distribution (Multiple Components)**

**Problem Statement:**
Connect villages with water pipes. Some villages can drill wells (cost given). Find minimum cost to provide water to all villages.

```
Example:
n = 3
wells = [1,2,2] (cost to drill well in each village)
pipes = [[1,2,1],[2,3,1]] (cost to connect villages)
Output: 3 (drill well in village 1, connect 1→2→3)
```

**🤔 Key Insight: Add virtual source connected to all villages with well costs!**

**Reference Solution:**
```java
class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<Edge> edges = new ArrayList<>();
        
        // Add well costs as edges from virtual source (node 0)
        for (int i = 0; i < n; i++) {
            edges.add(new Edge(0, i + 1, wells[i]));
        }
        
        // Add pipe costs
        for (int[] pipe : pipes) {
            edges.add(new Edge(pipe[0], pipe[1], pipe[2]));
        }
        
        // Run Kruskal's on extended graph
        edges.sort((a, b) -> a.weight - b.weight);
        UnionFind uf = new UnionFind(n + 1); // +1 for virtual source
        
        int totalCost = 0;
        int edgesUsed = 0;
        
        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                totalCost += edge.weight;
                if (++edgesUsed == n) break; // n edges needed (including source)
            }
        }
        
        return totalCost;
    }
}
```

### **Problem 6: Minimum Spanning Forest (Multiple Components)**

**Problem Statement:**
Given graph that might not be connected, find minimum cost to create a spanning forest (MST for each component).

```java
// Template: MST for Multiple Components
class Solution {
    public int minCostSpanningForest(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);
        
        int totalCost = 0;
        int edgesUsed = 0;
        
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                totalCost += edge[2];
                edgesUsed++;
            }
        }
        
        // Check how many components remain
        int components = uf.getComponents();
        
        return components == 1 ? totalCost : -1; // or return cost with components info
    }
    
    public List<List<Integer>> getSpanningForest(int n, int[][] edges) {
        // Run MST algorithm
        // Group edges by component root
        // Return list of MSTs for each component
    }
}
```

---

## 🚀 **ADVANCED MST TECHNIQUES**

### **1. MST with Constraints**
```java
// MST with maximum edge weight constraint
public int constrainedMST(int n, int[][] edges, int maxWeight) {
    List<Edge> validEdges = new ArrayList<>();
    
    for (int[] edge : edges) {
        if (edge[2] <= maxWeight) {
            validEdges.add(new Edge(edge[0], edge[1], edge[2]));
        }
    }
    
    return kruskalMST(n, validEdges);
}

// MST avoiding certain edges
public int mstWithoutEdges(int n, int[][] edges, Set<Integer> bannedEdges) {
    List<Edge> validEdges = new ArrayList<>();
    
    for (int i = 0; i < edges.length; i++) {
        if (!bannedEdges.contains(i)) {
            validEdges.add(new Edge(edges[i][0], edges[i][1], edges[i][2]));
        }
    }
    
    return kruskalMST(n, validEdges);
}
```

### **2. Dynamic MST (Edge Addition/Removal)**
```java
class DynamicMST {
    private List<Edge> edges;
    private UnionFind uf;
    private int n;
    
    public DynamicMST(int n) {
        this.n = n;
        this.edges = new ArrayList<>();
        this.uf = new UnionFind(n);
    }
    
    public void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
        // Recompute MST if needed
    }
    
    public int getCurrentMSTWeight() {
        edges.sort((a, b) -> a.weight - b.weight);
        uf = new UnionFind(n); // Reset
        
        int totalWeight = 0;
        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                totalWeight += edge.weight;
            }
        }
        
        return totalWeight;
    }
}
```

### **3. MST with Custom Weight Functions**
```java
// MST with Manhattan distance
public int manhattanMST(int[][] points) {
    return mstWithWeightFunction(points, this::manhattanDistance);
}

// MST with Euclidean distance
public int euclideanMST(int[][] points) {
    return mstWithWeightFunction(points, this::euclideanDistance);
}

private int mstWithWeightFunction(int[][] points, 
                                 BiFunction<int[], int[], Integer> weightFunc) {
    int n = points.length;
    List<Edge> edges = new ArrayList<>();
    
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int weight = weightFunc.apply(points[i], points[j]);
            edges.add(new Edge(i, j, weight));
        }
    }
    
    return kruskalMST(n, edges);
}

private int manhattanDistance(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
}

private int euclideanDistance(int[] p1, int[] p2) {
    return (int) Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
}
```

---

## 🎯 **MST COMPLEXITY ANALYSIS**

### **Time Complexity:**
- **Kruskal's:** O(E log E) - dominated by edge sorting
- **Prim's (naive):** O(V²) - good for dense graphs
- **Prim's (heap):** O(E log V) - good for sparse graphs

### **Space Complexity:**
- **Kruskal's:** O(V) for Union-Find + O(E) for edge storage
- **Prim's:** O(V) for priority queue and visited array

### **When to Use Which:**
```
Graph Type          | Best Algorithm | Time Complexity
--------------------|----------------|------------------
Sparse (E << V²)    | Kruskal's     | O(E log E)
Dense (E ≈ V²)      | Prim's        | O(V²) or O(E log V)
Edge list given     | Kruskal's     | O(E log E)
Adjacency matrix    | Prim's        | O(V²)
Need specific edges | Kruskal's     | O(E log E)
Start from vertex   | Prim's        | O(E log V)
```

### **Optimization Tips:**
- **Pre-sort edges** if running multiple MST queries
- **Use coordinate compression** for large coordinate ranges
- **Early termination** when n-1 edges found
- **Union by rank** in Union-Find for better performance