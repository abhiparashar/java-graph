# 🎯 UNION-FIND MASTERY - PART 4

## 🏆 **COMPLETE CHEATSHEET**

### **UNION-FIND COMPLEXITY ANALYSIS**
- **Time Complexity:** O(α(n)) per operation (amortized)
    - α(n) is inverse Ackermann function (practically constant)
    - Without optimizations: O(log n) per operation
- **Space Complexity:** O(n) for parent and rank arrays
- **Total for m operations:** O(m × α(n))

### **OPTIMIZATION TECHNIQUES**
```java
// 1. Path Compression (Recursive)
public int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]);
    return parent[x];
}

// 2. Path Compression (Iterative)
public int find(int x) {
    int root = x;
    while (parent[root] != root) root = parent[root];
    while (parent[x] != x) {
        int next = parent[x];
        parent[x] = root;
        x = next;
    }
    return root;
}

// 3. Path Halving (Alternative)
public int find(int x) {
    while (parent[x] != x) {
        parent[x] = parent[parent[x]];
        x = parent[x];
    }
    return x;
}

// 4. Union by Rank vs Union by Size
// Rank: Track tree height (more complex but slightly better)
// Size: Track subtree size (simpler, almost as good)
```

---

## ⚡ **COMMON PITFALLS & SOLUTIONS**

### **Pitfall 1: Forgetting Path Compression**
```java
// ❌ Wrong: O(n) find operations
public int find(int x) {
    while (parent[x] != x) {
        x = parent[x];
    }
    return x;
}

// ✅ Correct: O(α(n)) amortized
public int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]);
    return parent[x];
}
```

### **Pitfall 2: Not Using Union by Rank/Size**
```java
// ❌ Wrong: Can create skewed trees
public void union(int x, int y) {
    parent[find(x)] = find(y);
}

// ✅ Correct: Balanced trees
public boolean union(int x, int y) {
    int px = find(x), py = find(y);
    if (px == py) return false;
    if (rank[px] < rank[py]) parent[px] = py;
    else if (rank[px] > rank[py]) parent[py] = px;
    else { parent[py] = px; rank[px]++; }
    return true;
}
```

### **Pitfall 3: Grid Coordinate Mapping Errors**
```java
// ❌ Wrong: Boundary issues
int id = i * n + j; // What if j >= n?

// ✅ Correct: Always validate bounds
private int getId(int x, int y) {
    if (x < 0 || x >= m || y < 0 || y >= n) return -1;
    return x * n + y;
}
```

### **Pitfall 4: Component Counting Mistakes**
```java
// ❌ Wrong: Counting all roots
int components = 0;
for (int i = 0; i < n; i++) {
    if (parent[i] == i) components++;
}

// ✅ Correct: Track during union operations
// Or use Set<Integer> roots = new HashSet<>();
// for (int i = 0; i < n; i++) roots.add(find(i));
```

---

## 🎯 **PROBLEM PATTERN RECOGNITION SPEED TEST**

**Can you identify the pattern in 5 seconds?**

1. **"Find number of friend circles"** → **Basic Union-Find** ✅
2. **"Merge accounts with common emails"** → **Union-Find with Grouping** ✅
3. **"Islands added one by one"** → **Dynamic Connectivity** ✅
4. **"Path exists with edge weight < limit"** → **Weighted Union-Find** ✅
5. **"Remove maximum stones from grid"** → **Component Size Analysis** ✅
6. **"Detect redundant connection"** → **Cycle Detection** ✅

**Template Selection Test:**
- "Connected components" → Standard template with component counting
- "Account merging" → Use HashMap to group by root
- "Dynamic islands" → Modified template with addComponent()
- "Weighted constraints" → Sort edges/queries, process incrementally
- "Grid problems" → Coordinate mapping + direction arrays
- "Cycle detection" → Return false when union fails

---

## 📚 **STRIVER'S SDE SHEET UNION-FIND PROBLEMS**

### **Must-Solve Problems (High Frequency):**
1. **Number of Islands** - Basic connectivity
2. **Accounts Merge** - Grouping with mapping
3. **Number of Islands II** - Dynamic connectivity
4. **Most Stones Removed** - Component size analysis
5. **Redundant Connection** - Cycle detection
6. **Number of Provinces** - Basic connected components

### **Good-to-Solve Problems:**
7. **Satisfiability of Equality Equations** - Constraint checking
8. **Smallest String with Swaps** - Grouping + sorting
9. **Checking Edge Length Limited Paths** - Weighted constraints
10. **Min Cost to Connect All Points** - MST with Union-Find

---

## 🚀 **ADVANCED UNION-FIND VARIANTS**

### **1. Persistent Union-Find (Immutable)**
```java
class PersistentUnionFind {
    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> rank;
    
    public PersistentUnionFind() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }
    
    private PersistentUnionFind(Map<Integer, Integer> p, Map<Integer, Integer> r) {
        parent = new HashMap<>(p);
        rank = new HashMap<>(r);
    }
    
    public PersistentUnionFind union(int x, int y) {
        PersistentUnionFind newUF = new PersistentUnionFind(parent, rank);
        newUF.unionMutable(x, y);
        return newUF;
    }
    
    // Returns new version without modifying current
}
```

### **2. Union-Find with Deletion**
```java
class UnionFindWithDeletion {
    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> size;
    
    public void delete(int x) {
        if (!parent.containsKey(x)) return;
        
        // Move all children to a new representative
        int root = find(x);
        if (root == x) {
            // Need to find new root for this component
            // Implementation depends on specific requirements
        }
        parent.remove(x);
        size.remove(x);
    }
}
```

### **3. Union-Find with Range Queries**
```java
class RangeUnionFind {
    private UnionFind uf;
    private TreeMap<Integer, Integer> ranges;
    
    public void union(int start, int end) {
        // Union all elements in range [start, end]
        for (int i = start; i <= end; i++) {
            if (i > start) uf.union(start, i);
        }
        
        // Merge overlapping ranges
        ranges.put(start, end);
    }
}
```

---

## 🏆 **FINAL MASTERY CHECKLIST**

### **Core Understanding ✅**
- [ ] Can implement basic Union-Find from scratch in 2 minutes
- [ ] Understand path compression and union by rank optimizations
- [ ] Know time complexity: O(α(n)) per operation
- [ ] Can explain why Union-Find is efficient for connectivity queries

### **Pattern Recognition ✅**
- [ ] Instantly identify "connected components" → Union-Find
- [ ] Recognize "cycle detection" → Union fails when already connected
- [ ] Spot "dynamic connectivity" → Process operations incrementally
- [ ] See "grouping by relation" → Use maps with Union-Find

### **Implementation Skills ✅**
- [ ] Can modify template for different problem variants
- [ ] Handle 2D grid coordinate mapping correctly
- [ ] Implement size tracking when needed
- [ ] Use appropriate data structures for grouping

### **Problem-Solving Speed ✅**
- [ ] Solve basic connectivity problems in < 10 minutes
- [ ] Handle dynamic problems with proper state management
- [ ] Debug common issues (bounds, coordinate mapping, counting)
- [ ] Optimize for time/space when constraints are tight

---

## 🎯 **INTERVIEW PREPARATION FINAL TIPS**

### **What Interviewers Look For:**
1. **Quick Pattern Recognition** - "Oh, this is about connected components"
2. **Clean Implementation** - Standard template with clear variable names
3. **Optimization Awareness** - Path compression + union by rank
4. **Edge Case Handling** - Empty input, single elements, etc.
5. **Complexity Analysis** - Know it's O(α(n)) per operation

### **Common Interview Mistakes:**
- Implementing naive O(n) find without path compression
- Forgetting to handle the case when elements are already connected
- Incorrect coordinate mapping in grid problems
- Not considering the initial state (are all elements separate initially?)

### **Pro Tips:**
- Start with standard template, then modify as needed
- Draw small examples to verify logic
- Test with edge cases: n=1, n=2, already connected, etc.
- If asked to optimize, mention persistent Union-Find for functional programming contexts

---

## 🚀 **NEXT PHASE: MINIMUM SPANNING TREE**

You've mastered Union-Find! Ready for **MST (Kruskal's + Prim's)** next?

**Key Connection:** Union-Find is the core of Kruskal's MST algorithm! 💪

**YOU'VE ACHIEVED UNION-FIND MASTERY WHEN:**
✅ Can solve any connectivity problem in interviews confidently  
✅ Implement Union-Find template in under 2 minutes  
✅ Recognize patterns instantly from problem description  
✅ Debug implementation issues quickly  
✅ Understand time/space complexity implications

**Total Mastered Algorithms:** 4/7 Complete! 🎯