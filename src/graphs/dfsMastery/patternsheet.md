# 🎯 Ultimate BFS vs DFS Pattern Recognition Cheat Sheet

## 🚨 **CRITICAL Decision Framework (90% Success Rate)**

### **Step 1: Scan for INSTANT BFS Triggers**
```
Keywords that IMMEDIATELY = BFS:
✅ "shortest path/distance"
✅ "minimum steps/moves/time" 
✅ "level order/level by level"
✅ "nearest/closest"
✅ "minimum depth/height"
✅ "layer by layer"

If ANY of these found → STOP THINKING → BFS!
```

### **Step 2: Scan for INSTANT DFS Triggers**
```
Keywords that IMMEDIATELY = DFS:
✅ "all paths/solutions/ways"
✅ "count components/islands/regions" 
✅ "exists/reachable" (any path)
✅ "cycle detection"
✅ "backtracking/permutation/combination"
✅ "validate/check structure"

If ANY of these found → STOP THINKING → DFS!
```

### **Step 3: Confusing Cases (Look Deeper)**
```
If problem says "minimum/maximum" BUT:
- "minimum area/size/count" → DFS (component size)
- "minimum distance/steps" → BFS (shortest path)
- "maximum depth/path length" → DFS (go deep)
- "maximum width/level size" → BFS (level processing)
```

---

## 🔥 **Pattern Recognition by Problem Type**

### **🌐 Graph Problems**

| **Problem Type** | **Algorithm** | **Pattern** | **Why** |
|------------------|---------------|-------------|---------|
| **Path exists** | DFS | Basic traversal | Any path works, DFS memory efficient |
| **Shortest path** | BFS | Level-wise | Unweighted shortest = BFS guarantee |
| **All paths** | DFS | Backtracking | Need to explore deeply + undo |
| **Count components** | DFS | Multiple DFS calls | Count separate regions |
| **Cycle detection** | DFS | 3-color/recursion stack | Track current path |
| **Topological sort** | DFS | Post-order processing | Dependency resolution |
| **Clone graph** | Both | Traversal + copy | Either works fine |

### **🏝️ Grid/Matrix Problems**

| **Problem Type** | **Algorithm** | **Pattern** | **Example** |
|------------------|---------------|-------------|-------------|
| **Count islands/regions** | DFS | Component counting | Number of Islands |
| **Max area/size** | DFS | DFS with return value | Max Area of Island |
| **Shortest distance in grid** | BFS | Multi-source BFS | 01 Matrix |
| **Word search** | DFS | Backtracking | Word Search |
| **Boundary problems** | DFS | Boundary-initiated | Surrounded Regions |
| **Fill/paint** | DFS | Flood fill | Pacific Atlantic |
| **Level processing** | BFS | Queue-based | Walls and Gates |

### **🌳 Tree Problems**

| **Problem Type** | **Algorithm** | **Pattern** | **Example** |
|------------------|---------------|-------------|-------------|
| **Level order** | BFS | Queue processing | Binary Tree Level Order |
| **Right side view** | BFS | Level processing | Binary Tree Right Side View |
| **Minimum depth** | BFS | First leaf found | Minimum Depth |
| **Maximum depth** | DFS | Recursive depth | Maximum Depth |
| **Path sum** | DFS | Root-to-leaf paths | Path Sum |
| **All paths** | DFS | Backtracking | Binary Tree Paths |

---

## ⚡ **Instant Decision Tricks**

### **🎯 Keyword Mapping**
```java
// INSTANT BFS
if (problem.contains("shortest|minimum steps|level|nearest|closest")) {
    return "BFS";
}

// INSTANT DFS  
if (problem.contains("all|count|exists|cycle|backtrack")) {
    return "DFS";
}

// Grid specific
if (problem.contains("shortest distance in grid")) {
    return "BFS"; // Multi-source BFS
}

if (problem.contains("count islands|regions|components")) {
    return "DFS"; // Component counting
}
```

### **🔍 Context Clues**
```
Tree + "level" = BFS
Tree + "path" = DFS
Grid + "shortest" = BFS
Grid + "count" = DFS
Graph + "reachable" = DFS
Graph + "shortest path" = BFS
```

---

## 📚 **LeetCode Practice Problems (Categorized)**

### **🚀 BFS Essentials (Master These First)**
```
Easy:
- 102. Binary Tree Level Order Traversal
- 107. Binary Tree Level Order Traversal II  
- 111. Minimum Depth of Binary Tree
- 993. Cousins in Binary Tree

Medium:
- 542. 01 Matrix ⭐⭐⭐
- 994. Rotting Oranges ⭐⭐⭐
- 286. Walls and Gates ⭐⭐⭐
- 127. Word Ladder ⭐⭐⭐
- 199. Binary Tree Right Side View
- 103. Binary Tree Zigzag Level Order
- 1091. Shortest Path in Binary Matrix
- 317. Shortest Distance from All Buildings

Hard:
- 301. Remove Invalid Parentheses
- 773. Sliding Puzzle
```

### **🔥 DFS Essentials (Our 9 Patterns)**
```
Easy:
- 733. Flood Fill (Pattern 5)
- 200. Number of Islands ⭐⭐⭐ (Pattern 5)
- 463. Island Perimeter

Medium:
- 695. Max Area of Island ⭐⭐⭐ (Pattern 6)
- 130. Surrounded Regions ⭐⭐⭐ (Pattern 7)  
- 207. Course Schedule ⭐⭐⭐ (Pattern 8)
- 79. Word Search ⭐⭐⭐ (Pattern 9)
- 797. All Paths From Source to Target ⭐⭐⭐ (Pattern 4)
- 547. Number of Provinces (Pattern 3)
- 417. Pacific Atlantic Water Flow
- 139. Word Break (Pattern 4 variation)

Hard:
- 212. Word Search II (Pattern 9 + Trie)
- 140. Word Break II (Pattern 4 + backtracking)
- 51. N-Queens (Pattern 9 variation)
```

### **⚖️ Both Work (Good for Practice)**
```
- 133. Clone Graph
- 841. Keys and Rooms  
- 323. Number of Connected Components (Premium)
- 261. Graph Valid Tree (Premium)
```

---

## 🎯 **Common Confusion Resolvers**

### **"Minimum" Confusion**
```
❌ Wrong: "minimum" dekha toh BFS
✅ Right: Check what's being minimized

Examples:
- "minimum steps" → BFS (distance)
- "minimum area" → DFS (component calculation)
- "minimum depth" → BFS (first leaf)
- "minimum spanning tree" → Neither (special algorithm)
```

### **"All Paths" vs "Shortest Path"**
```
✅ "Find A path" → DFS or BFS (DFS memory efficient)
✅ "Find ALL paths" → DFS + Backtracking  
✅ "Find SHORTEST path" → BFS (unweighted)
```

### **Tree Problems**
```
✅ Process by level → BFS
✅ Process by depth → DFS
✅ Find path to node → DFS
✅ Find level of node → BFS
```

---

## 💡 **Memory Tricks**

### **BFS = "Breadth First Search"**
```
B = Breadth = Wide = Level = Shortest
F = First = Immediate = Nearest = Minimum distance
S = Search = Systematic = Layer by layer
```

### **DFS = "Depth First Search"**
```
D = Depth = Deep = All the way = Complete exploration
F = First = Path = Single route = Go deep first
S = Search = Systematic = Backtrack when needed
```

---

## 🏆 **Master These 20 Problems**

**BFS (10 problems):**
1. Binary Tree Level Order (102)
2. 01 Matrix (542) ⭐
3. Rotting Oranges (994) ⭐
4. Word Ladder (127) ⭐
5. Walls and Gates (286) ⭐
6. Binary Tree Right Side View (199)
7. Minimum Depth (111)
8. Shortest Path Binary Matrix (1091)
9. Open the Lock (752)
10. Perfect Squares (279)

**DFS (10 problems):**
1. Number of Islands (200) ⭐
2. Max Area Island (695) ⭐
3. Course Schedule (207) ⭐
4. Word Search (79) ⭐
5. Surrounded Regions (130) ⭐
6. All Paths Source Target (797) ⭐
7. Number of Provinces (547)
8. Flood Fill (733)
9. Clone Graph (133)
10. Pacific Atlantic (417)

**⭐ = Must solve for interviews**

---

## 🎯 **Final Decision Tree**
```
1. Read problem statement
2. Look for BFS trigger words (shortest, level, minimum steps)
   → If found: BFS
3. Look for DFS trigger words (all, count, exists, backtrack)  
   → If found: DFS
4. Still confused? Ask:
   - Need shortest distance? → BFS
   - Need all solutions? → DFS
   - Grid counting? → DFS
   - Tree level processing? → BFS
```

**Practice this cheat sheet daily for 1 week = Pattern mastery guaranteed!** 🚀