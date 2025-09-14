# 🎯 UNION-FIND MASTERY - PART 2

## 🔥 **PATTERN 3: WEIGHTED UNION-FIND**

### **Problem 4: Most Stones Removed with Same Row or Column**

**Problem Statement:**
On a 2D plane, stones are placed. A stone can be removed if it shares a row or column with another stone. Find the maximum number of stones that can be removed.

```
Example:
stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5 (can remove all except one from each connected component)
```

**🤔 Key Insight: Stones in same row/column form connected components!**

**Reference Solution:**
```java
class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(stones.length);
        
        // Group stones by rows and columns
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1];
            
            // Connect stones in same row
            if (rowMap.containsKey(row)) {
                uf.union(i, rowMap.get(row));
            } else {
                rowMap.put(row, i);
            }
            
            // Connect stones in same column  
            if (colMap.containsKey(col)) {
                uf.union(i, colMap.get(col));
            } else {
                colMap.put(col, i);
            }
        }
        
        // Each component can be reduced to 1 stone
        return stones.length - uf.getComponents();
    }
}
```

**Advanced Weighted Template:**
```java
class WeightedUnionFind {
    private int[] parent, weight;
    
    public WeightedUnionFind(int n) {
        parent = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 0; // Weight relative to parent
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            int originalParent = parent[x];
            parent[x] = find(parent[x]);
            weight[x] += weight[originalParent]; // Update weight
        }
        return parent[x];
    }
    
    public boolean union(int x, int y, int w) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false;
        
        parent[rootY] = rootX;
        weight[rootY] = weight[x] - weight[y] + w;
        return true;
    }
    
    public int getWeight(int x, int y) {
        if (find(x) != find(y)) return Integer.MAX_VALUE;
        return weight[y] - weight[x];
    }
}
```

---

## ⚡ **PATTERN 4: DYNAMIC CONNECTIVITY**

### **Problem 5: Number of Islands II**

**Problem Statement:**
You start with a 2D grid of water. Islands are added one by one. After each addition, count the number of islands.

```
Example:
m = 3, n = 3
positions = [[0,0],[0,1],[1,2],[2,1]]
Output: [1,1,2,3] (islands count after each addition)
```

**Reference Solution:**
```java
class Solution {
    public List<Integer> numIslandsII(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        boolean[][] grid = new boolean[m][n];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for (int[] pos : positions) {
            int x = pos[0], y = pos[1];
            
            if (grid[x][y]) {
                result.add(uf.getComponents());
                continue;
            }
            
            grid[x][y] = true;
            uf.addComponent(); // Add new island
            
            int currentId = x * n + y;
            
            // Check 4 directions for existing islands
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny]) {
                    int neighborId = nx * n + ny;
                    uf.union(currentId, neighborId);
                }
            }
            
            result.add(uf.getComponents());
        }
        
        return result;
    }
}

// Modified Union-Find for dynamic component addition
class UnionFind {
    private int[] parent, rank;
    private int components;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        components = 0; // Start with 0 components
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public void addComponent() {
        components++;
    }
    
    // ... rest of standard methods
}
```

---

## 🎯 **PATTERN 5: UNION-FIND WITH ROLLBACK**

### **Problem 6: Checking Existence of Edge Length Limited Paths**

**Problem Statement:**
Given a graph and queries asking if path exists between two nodes using only edges with weight < limit, answer each query.

```
Example:
n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]]
queries = [[0,1,2],[0,2,5]]
Output: [false, true]
```

**Reference Solution:**
```java
class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // Create query indices for sorting
        Integer[] queryIndices = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queryIndices[i] = i;
        }
        
        // Sort queries by limit
        Arrays.sort(queryIndices, (a, b) -> queries[a][2] - queries[b][2]);
        
        // Sort edges by weight
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        
        UnionFind uf = new UnionFind(n);
        boolean[] result = new boolean[queries.length];
        int edgeIndex = 0;
        
        for (int i : queryIndices) {
            int u = queries[i][0], v = queries[i][1], limit = queries[i][2];
            
            // Add all edges with weight < limit
            while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
                uf.union(edgeList[edgeIndex][0], edgeList[edgeIndex][1]);
                edgeIndex++;
            }
            
            result[i] = uf.isConnected(u, v);
        }
        
        return result;
    }
}
```

**Rollback Template (Advanced):**
```java
class UnionFindWithRollback {
    private int[] parent, rank;
    private Stack<int[]> operations; // Store operations for rollback
    
    public UnionFindWithRollback(int n) {
        parent = new int[n];
        rank = new int[n];
        operations = new Stack<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false;
        
        // Store operation for potential rollback
        if (rank[rootX] < rank[rootY]) {
            operations.push(new int[]{rootX, parent[rootX], rank[rootX]});
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            operations.push(new int[]{rootY, parent[rootY], rank[rootY]});
            parent[rootY] = rootX;
        } else {
            operations.push(new int[]{rootY, parent[rootY], rank[rootY]});
            operations.push(new int[]{rootX, parent[rootX], rank[rootX]});
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
    
    public void rollback() {
        if (operations.isEmpty()) return;
        
        int[] op = operations.pop();
        int node = op[0], oldParent = op[1], oldRank = op[2];
        parent[node] = oldParent;
        rank[node] = oldRank;
    }
}
```

---

## 🚀 **ADVANCED OPTIMIZATION TECHNIQUES**

### **Path Halving (Alternative to Path Compression):**
```java
public int findWithHalving(int x) {
    while (parent[x] != x) {
        parent[x] = parent[parent[x]]; // Skip one level
        x = parent[x];
    }
    return x;
}
```

### **Union by Size vs Union by Rank:**
```java
// Union by Size (often simpler)
class UnionFindBySize {
    private int[] parent, size;
    
    public boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false;
        
        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
        return true;
    }
}
```

### **Coordinate Compression for Large Grids:**
```java
// For problems with large coordinate ranges
class Solution {
    public int removeStones(int[][] stones) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        for (int[] stone : stones) {
            rows.add(stone[0]);
            cols.add(stone[1] + 10001); // Offset to avoid collision
        }
        
        UnionFind uf = new UnionFind(rows.size() + cols.size());
        Map<Integer, Integer> coordToId = new HashMap<>();
        
        int id = 0;
        for (int coord : rows) coordToId.put(coord, id++);
        for (int coord : cols) coordToId.put(coord, id++);
        
        for (int[] stone : stones) {
            uf.union(coordToId.get(stone[0]), coordToId.get(stone[1] + 10001));
        }
        
        return stones.length - uf.getComponents();
    }
}
```