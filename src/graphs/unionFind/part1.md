# 🎯 UNION-FIND MASTERY - COMPLETE GUIDE

## 📊 **UNION-FIND PATTERN OVERVIEW**
**Total Union-Find Patterns: 5 Core Patterns**

1. **Basic Union-Find** - Connected components, cycle detection
2. **Union-Find with Size/Count** - Component size tracking
3. **Union-Find with Rank/Weight** - Weighted union optimization
4. **Dynamic Connectivity** - Online edge addition/removal
5. **Union-Find with Rollback** - Undo operations

---

## 🚀 **DAY 1-2: UNION-FIND FOUNDATION**

### **Problem 1: Number of Connected Components**

**Problem Statement:**
Given n nodes and edges, find the number of connected components in an undirected graph.

```
Example:
n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2 (components: {0,1,2} and {3,4})
```

**🤔 Try this yourself first before seeing the solution!**

---

### **Reference Solution & Analysis:**

```java
// TEMPLATE 1: Basic Union-Find
class UnionFind {
    private int[] parent;
    private int[] rank;
    private int components;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Each node is its own parent initially
            rank[i] = 0;    // Initial rank is 0
        }
    }
    
    // Find with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }
    
    // Union by rank
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX == rootY) return false; // Already connected
        
        // Union by rank for optimization
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        
        components--; // One less component
        return true;
    }
    
    public int getComponents() {
        return components;
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        return uf.getComponents();
    }
}
```

**Dry Run:**
```
Initial: parent=[0,1,2,3,4], components=5
Edge [0,1]: union(0,1) → parent=[1,1,2,3,4], components=4
Edge [1,2]: union(1,2) → parent=[1,2,2,3,4], components=3  
Edge [3,4]: union(3,4) → parent=[1,2,2,4,4], components=2
Result: 2 components
```

**Key Insights:**
- **Path Compression** makes find O(α(n)) amortized
- **Union by Rank** keeps trees balanced
- **Component Counting** tracks connected groups

---

## 🔄 **CORE UNION-FIND TEMPLATE (Memorize This!)**

```java
// UNIVERSAL UNION-FIND TEMPLATE
class UnionFind {
    private int[] parent, rank;
    private int components;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
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
        components--;
        return true;
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
    
    public int getComponents() {
        return components;
    }
}
```

---

## 🎯 **PATTERN 1: BASIC UNION-FIND**

### **Problem 2: Redundant Connection**

**Problem Statement:**
In a graph that was originally a tree, one additional edge was added. Find the edge that when removed, makes it a tree again.

```
Example:
edges = [[1,2],[1,3],[2,3]]
Output: [2,3] (removing this makes it a tree)
```

**Reference Solution:**
```java
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        
        for (int[] edge : edges) {
            // If already connected, this edge creates a cycle
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        
        return new int[0]; // Should never reach here
    }
}
```

**When to Use Basic Union-Find:**
- Cycle detection in undirected graphs
- Connected components counting
- Dynamic connectivity queries
- Simple graph connectivity problems

**Common Interview Applications:**
- Number of Islands (2D grid connectivity)
- Friend Circles (social network connectivity)
- Graph Valid Tree (cycle detection + connectivity)
- Redundant Connection (cycle detection)

---

## 🔥 **PATTERN 2: UNION-FIND WITH SIZE TRACKING**

### **Problem 3: Accounts Merge**

**Problem Statement:**
Given a list of accounts with names and emails, merge accounts belonging to the same person (same name + any common email).

```
Example:
accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],
           ["John","johnsmith@mail.com","john00@mail.com"],
           ["Mary","mary@mail.com"],
           ["John","johnnybravo@mail.com"]]

Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],
         ["Mary","mary@mail.com"],
         ["John","johnnybravo@mail.com"]]
```

**Reference Solution:**
```java
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> emailToAccount = new HashMap<>();
        
        // Map emails to account indices
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                
                if (emailToAccount.containsKey(email)) {
                    // Same email found, union accounts
                    uf.union(i, emailToAccount.get(email));
                } else {
                    emailToAccount.put(email, i);
                }
            }
        }
        
        // Group emails by root account
        Map<Integer, List<String>> rootToEmails = new HashMap<>();
        for (String email : emailToAccount.keySet()) {
            int accountIdx = emailToAccount.get(email);
            int root = uf.find(accountIdx);
            
            rootToEmails.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }
        
        // Build result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : rootToEmails.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            
            List<String> account = new ArrayList<>();
            account.add(accounts.get(entry.getKey()).get(0)); // Name
            account.addAll(emails);
            
            result.add(account);
        }
        
        return result;
    }
}
```

**Size Tracking Template:**
```java
class UnionFindWithSize {
    private int[] parent, size;
    
    public UnionFindWithSize(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false;
        
        // Always attach smaller tree to larger tree
        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
        return true;
    }
    
    public int getSize(int x) {
        return size[find(x)];
    }
}
```