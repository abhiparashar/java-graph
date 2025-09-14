# 🎯 UNION-FIND MASTERY - PART 3

## 🎯 **PATTERN RECOGNITION DRILL**

### **INSTANT IDENTIFICATION GUIDE**

| **Key Phrases** | **Pattern** | **Template** |
|----------------|-------------|--------------|
| "connected components", "groups" | Basic Union-Find | Standard template with component counting |
| "cycle detection", "redundant edge" | Basic Union-Find | Return false when union fails |
| "merge accounts", "group by relation" | Union-Find with grouping | Use maps to group elements by root |
| "dynamic addition", "online queries" | Dynamic Connectivity | Add elements one by one |
| "same row/column", "grid connectivity" | Coordinate Union-Find | Map 2D coordinates to 1D indices |
| "path with constraints", "limited edges" | Weighted/Constraint UF | Sort by constraints, process incrementally |

---

## 🔥 **COMPLETE LEETCODE PROBLEM MAPPING**

### **Pattern 1: Basic Union-Find (Connectivity & Cycles)**

**Easy (3 Problems):**
1. **[1971] Find if Path Exists in Graph**
    - Basic connectivity check
    - Union all edges, check if source/target connected

2. **[1791] Find Center of Star Graph**
    - Alternative: Use Union-Find to find node connecting to all

3. **[1135] Connecting Cities with Minimum Cost** 🔒
    - MST problem, but can use Union-Find for validation

**Medium (8 Problems):**
1. **[684] Redundant Connection** ⭐ **MUST SOLVE**
    - Classic cycle detection
    - Return first edge that creates cycle

2. **[685] Redundant Connection II**
    - Directed graph cycle detection
    - More complex - handle in-degree violations

3. **[547] Number of Provinces** ⭐ **MUST SOLVE**
    - Basic connected components
    - Count friend circles

4. **[200] Number of Islands**
    - Can solve with Union-Find (DFS is more common)
    - Connect adjacent land cells

5. **[990] Satisfiability of Equality Equations**
    - Union equal variables, check inequalities don't contradict

6. **[1319] Number of Operations to Make Network Connected**
    - Check if enough edges exist to connect all nodes

7. **[1020] Number of Enclaves**
    - Connect boundary lands, count unconnected

8. **[1254] Number of Closed Islands**
    - Similar to enclaves, use Union-Find for boundary connection

---

### **Pattern 2: Union-Find with Size/Grouping**

**Medium (6 Problems):**
1. **[721] Accounts Merge** ⭐ **MUST SOLVE**
    - Group accounts by shared emails
    - Use email-to-account mapping

2. **[947] Most Stones Removed** ⭐ **MUST SOLVE**
    - stones.length - number_of_components
    - Connect stones in same row/column

3. **[1202] Smallest String with Swaps**
    - Group indices by swap connections
    - Sort characters within each group

4. **[1722] Minimize Hamming Distance After Swap Operations**
    - Similar to smallest string swaps
    - Group by allowable swaps, optimize character assignment

5. **[1391] Check if There is a Valid Path in Grid**
    - Connect cells based on pipe connections
    - Check if start and end are connected

6. **[952] Largest Component Size by Common Factor**
    - Union numbers sharing common factors
    - Find largest connected component

**Hard (2 Problems):**
1. **[128] Longest Consecutive Sequence**
    - Union consecutive numbers
    - Alternative approach to O(n) solution

2. **[1632] Rank Transform of a Matrix**
    - Complex Union-Find with ranking
    - Group equal elements, assign ranks

---

### **Pattern 3: Dynamic Connectivity**

**Medium (4 Problems):**
1. **[305] Number of Islands II** 🔒 ⭐ **MUST SOLVE**
    - Add islands dynamically
    - Connect to adjacent existing islands

2. **[1101] The Earliest Moment When Everyone Become Friends** 🔒
    - Add friendships by timestamp
    - Return when all connected

3. **[1559] Detect Cycles in 2D Grid**
    - Dynamic cycle detection in grid
    - Add cells, check for cycles

4. **[803] Bricks Falling When Hit**
    - Reverse Union-Find (remove then add back)
    - Complex dynamic connectivity

---

### **Pattern 4: Weighted/Constraint Union-Find**

**Medium (3 Problems):**
1. **[1697] Checking Existence of Edge Length Limited Paths** ⭐ **MUST SOLVE**
    - Sort queries and edges by limits
    - Process incrementally

2. **[1584] Min Cost to Connect All Points**
    - MST with Union-Find (Kruskal's algorithm)
    - Generate all edges, sort by weight

3. **[1489] Find Critical and Pseudo-Critical Edges in MST**
    - Advanced MST analysis
    - Use Union-Find to test edge importance

**Hard (2 Problems):**
1. **[1568] Minimum Number of Days to Disconnect Island**
    - Articulation point detection
    - Use Union-Find for connectivity checks

2. **[1724] Checking Existence of Edge Length Limited Paths II**
    - Online queries with Union-Find
    - Requires persistent data structures

---

### **Pattern 5: Advanced Applications**

**Hard (3 Problems):**
1. **[765] Couples Holding Hands**
    - Cycle detection in permutation
    - Union couples, count cycles

2. **[839] Similar String Groups**
    - Group anagrams using Union-Find
    - Union strings that are similar

3. **[1293] Shortest Path in Grid with Obstacles**
    - Can use Union-Find for connectivity analysis
    - Usually solved with BFS

---

## ⚡ **UNION-FIND DECISION TREE**

```
Problem asks about connectivity/grouping?
├─ YES → Union-Find candidate
│   ├─ Static graph? → Basic Union-Find
│   ├─ Dynamic edge addition? → Dynamic Connectivity
│   ├─ Need group sizes? → Union-Find with Size
│   ├─ Weighted edges/constraints? → Weighted Union-Find
│   └─ Complex grouping logic? → Custom Union-Find
└─ NO → Consider other algorithms
```

---

## 🎯 **MASTER TEMPLATES COLLECTION**

### **1. Basic Template:**
```java
class UnionFind {
    int[] parent, rank;
    int components;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[px] > rank[py]) parent[py] = px;
        else { parent[py] = px; rank[px]++; }
        components--;
        return true;
    }
}
```

### **2. Size-Tracking Template:**
```java
class UnionFindWithSize {
    int[] parent, size;
    
    public UnionFindWithSize(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) { parent[i] = i; size[i] = 1; }
    }
    
    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        if (size[px] < size[py]) { parent[px] = py; size[py] += size[px]; }
        else { parent[py] = px; size[px] += size[py]; }
        return true;
    }
    
    public int getSize(int x) { return size[find(x)]; }
}
```

### **3. Grid Coordinate Template:**
```java
// For 2D grid problems
class GridUnionFind {
    UnionFind uf;
    int m, n;
    boolean[][] grid;
    
    public GridUnionFind(int m, int n) {
        this.m = m; this.n = n;
        uf = new UnionFind(m * n);
        grid = new boolean[m][n];
    }
    
    private int getId(int x, int y) { return x * n + y; }
    
    public void addLand(int x, int y) {
        if (grid[x][y]) return;
        grid[x][y