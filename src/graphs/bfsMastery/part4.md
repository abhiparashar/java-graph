# 🎯 BFS GRAPH MASTERY - PART 4

## 🎯 **PATTERN RECOGNITION DRILL**

### **INSTANT IDENTIFICATION GUIDE**

| **Key Phrases** | **Pattern** | **Template** |
|----------------|-------------|--------------|
| "shortest path", "minimum steps" | Basic BFS | Queue + visited + level counting |
| "from multiple sources", "all at once" | Multi-Source BFS | Multiple initial queue entries |
| "state transitions", "transform A to B" | State BFS | String/object states as nodes |
| "meet in middle", "large search space" | Bidirectional BFS | Two queues expanding toward each other |
| "level by level", "layer processing" | Level Processing | Process entire level at once |
| "conditional movement", "valid moves only" | Constraint BFS | Validity checks before adding to queue |

---

## 🔥 **LEETCODE PROBLEM MAPPING**

### **Pattern 1: Basic BFS Traversal**
1. **[127] Word Ladder** - Transform words one char at a time
2. **[279] Perfect Squares** - Min squares to sum to n
3. **[752] Open the Lock** - Minimum turns to reach target
4. **[1091] Shortest Path in Binary Matrix** - 0s form valid path
5. **[909] Snakes and Ladders** - Board game shortest path
6. **[1926] Nearest Exit from Entrance in Maze** - Escape maze
7. **[433] Minimum Genetic Mutation** - Gene mutations
8. **[365] Water and Jug Problem** - Pour water optimally

### **Pattern 2: Multi-Source BFS**
1. **[994] Rotting Oranges** - Spread from multiple rotten oranges
2. **[542] 01 Matrix** - Distance to nearest 0
3. **[286] Walls and Gates** - Distance to nearest gate
4. **[1162] As Far from Land as Possible** - Max distance from land
5. **[417] Pacific Atlantic Water Flow** - Water flow to oceans
6. **[934] Shortest Bridge** - Connect two islands
7. **[1020] Number of Enclaves** - Unreachable land cells

### **Pattern 3: State BFS**
1. **[752] Open the Lock** - 4-digit lock states
2. **[773] Sliding Puzzle** - 2x3 board configurations
3. **[854] K-Similar Strings** - String transformations
4. **[1345] Jump Game IV** - Array index jumping
5. **[126] Word Ladder II** - All shortest transformation paths
6. **[818] Race Car** - Car position/speed states

### **Pattern 4: Bidirectional BFS**
1. **[127] Word Ladder** - Optimize with bidirectional
2. **[752] Open the Lock** - Meet in middle optimization
3. **[126] Word Ladder II** - Find all shortest paths
4. **[433] Minimum Genetic Mutation** - Gene transformation

### **Pattern 5: Level Processing**
1. **[102] Binary Tree Level Order Traversal** - Classic level order
2. **[103] Binary Tree Zigzag Level Order** - Alternating directions
3. **[107] Binary Tree Level Order II** - Bottom-up traversal
4. **[199] Binary Tree Right Side View** - Rightmost nodes
5. **[637] Average of Levels** - Calculate level averages
6. **[515] Find Largest Value in Each Row** - Max per level
7. **[111] Minimum Depth of Binary Tree** - First leaf level

### **Pattern 6: Constraint BFS**
1. **[1306] Jump Game III** - Jump by array values
2. **[1129] Shortest Path with Alternating Colors** - Color constraints
3. **[847] Shortest Path Visiting All Nodes** - Visit all constraint
4. **[1293] Shortest Path with Obstacles** - Limited obstacles
5. **[505] The Maze II** - Ball rolling until wall

---

## ⚡ **BFS DECISION TREE**

```
Problem asks for shortest/minimum?
├─ YES → BFS candidate
│   ├─ Unweighted graph? → Basic BFS
│   ├─ Multiple starting points? → Multi-Source BFS  
│   ├─ Complex state transitions? → State BFS
│   ├─ Both start/end known + large space? → Bidirectional BFS
│   └─ Process by levels? → Level Processing BFS
└─ NO → Consider DFS/Other algorithms
```

---

## 🎯 **MASTER CHEATSHEET**

### **BFS COMPLEXITY ANALYSIS**
- **Time:** O(V + E) for graphs, O(4^n) for grids
- **Space:** O(V) for queue and visited
- **Bidirectional:** O(b^(d/2)) vs O(b^d)

### **COMMON PITFALLS & FIXES**
```java
// ❌ Wrong: Adding to queue without marking visited
queue.offer(neighbor);
visited.add(neighbor); // Too late!

// ✅ Correct: Mark visited when adding to queue  
if (!visited.contains(neighbor)) {
    visited.add(neighbor);
    queue.offer(neighbor);
}

// ❌ Wrong: Not processing by levels for shortest path
while (!queue.isEmpty()) {
    node = queue.poll();
    steps++; // Wrong place!
}

// ✅ Correct: Level-by-level processing
while (!queue.isEmpty()) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
        node = queue.poll();
        // Process node
    }
    steps++; // Correct place!
}
```

### **BFS vs DFS DECISION**
| **Use BFS When** | **Use DFS When** |
|------------------|------------------|
| Shortest path needed | All paths needed |
| Level-by-level processing | Deep exploration |
| Unweighted graphs | Weighted graphs with other algorithms |
| State space exploration | Backtracking problems |
| Multiple sources | Tree traversal |

### **GRID DIRECTIONS TEMPLATE**
```java
// 4-directional movement
int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

// 8-directional movement  
int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

// Bounds checking
private boolean isValid(int x, int y, int m, int n) {
    return x >= 0 && x < m && y >= 0 && y < n;
}
```

### **STATE REPRESENTATION EXAMPLES**
```java
// Position state
class Position {
    int x, y;
    Position(int x, int y) { this.x = x; this.y = y; }
}

// Complex state with multiple properties
class State {
    int x, y, keys, steps;
    State(int x, int y, int keys, int steps) {
        this.x = x; this.y = y; this.keys = keys; this.steps = steps;
    }
    
    @Override
    public boolean equals(Object o) {
        State s = (State) o;
        return x == s.x && y == s.y && keys == s.keys;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y, keys);
    }
}
```

---

## 🏆 **FINAL MASTERY TEST**

**Can you instantly identify the pattern?**

1. "Find minimum moves to solve sliding puzzle" → **State BFS**
2. "All cells start flooding simultaneously" → **Multi-Source BFS**
3. "Shortest path in maze from A to B" → **Basic BFS**
4. "Process binary tree level by level" → **Level Processing**
5. "Transform string optimally (both directions)" → **Bidirectional BFS**
6. "Jump only if array value allows" → **Constraint BFS**

**Template Selection Speed Test:**
- Basic shortest path → Queue + visited + level counting
- Multiple sources → Add all sources to initial queue
- State transitions → Custom state class with equals/hashCode
- Large search space → Two sets expanding toward each other
- Level processing → Process levelSize nodes per iteration
- Movement constraints → Validate before adding to queue

---

## 🎯 **YOU'VE MASTERED BFS WHEN:**
✅ Can identify pattern from problem description in 10 seconds  
✅ Know which template to use immediately  
✅ Can modify templates for problem variations  
✅ Understand time/space complexity implications  
✅ Can solve any BFS problem in interviews confidently

**Next Up: Union-Find Mastery! 🚀**