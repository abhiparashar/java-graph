# 🎯 BFS GRAPH MASTERY - PART 2

## 🔥 **PATTERN 2: MULTI-SOURCE BFS**

### **Problem 2: Rotten Oranges (Multi-Source BFS)**

**Problem Statement:**
In a grid with fresh oranges (1), rotten oranges (2), and empty cells (0), rotten oranges spread to adjacent fresh oranges every minute. Find minimum time to rot all oranges, or -1 if impossible.

```
Example:
[[2,1,1],
 [1,1,0],
 [0,1,1]]

Output: 4 (all oranges rot after 4 minutes)
```

**🤔 Try this yourself first!**

---

### **Reference Solution:**

```java
// TEMPLATE 2: Multi-Source BFS
class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int m = grid.length, n = grid[0].length;
        
        // Add all initially rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if (fresh == 0) return 0;
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int minutes = 0;
        
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2; // Rot the orange
                        fresh--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            minutes++;
        }
        
        return fresh == 0 ? minutes : -1;
    }
}
```

**Dry Run:**
```
Initial: queue=[(0,0)], fresh=5, minutes=0
Minute 1: Rot (0,1), (1,0), fresh=3, queue=[(0,1),(1,0)]
Minute 2: Rot (0,2), (1,1), fresh=1, queue=[(0,2),(1,1)]
Minute 3: No new rots, fresh=1, queue=[(2,1)]
Minute 4: Rot (2,2), fresh=0, return 4
```

---

## ⚡ **PATTERN 3: BFS WITH STATE TRACKING**

### **Problem 3: Open the Lock (State BFS)**

**Problem Statement:**
You have a lock with 4 circular wheels, each with digits 0-9. Given a list of deadends and a target, find minimum turns to reach target from "0000".

```
Example:
deadends = ["0201","0101","0102","1212","2002"]
target = "0202"
Output: 6
```

**Reference Solution:**

```java
// TEMPLATE 3: BFS with State Tracking
class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer("0000");
        visited.add("0000");
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                if (curr.equals(target)) return steps;
                
                // Generate all possible next states
                for (int j = 0; j < 4; j++) {
                    char c = curr.charAt(j);
                    
                    // Turn up
                    String next1 = curr.substring(0, j) + 
                                  (c == '9' ? '0' : (char)(c + 1)) + 
                                  curr.substring(j + 1);
                    
                    // Turn down  
                    String next2 = curr.substring(0, j) + 
                                  (c == '0' ? '9' : (char)(c - 1)) + 
                                  curr.substring(j + 1);
                    
                    addIfValid(queue, visited, dead, next1);
                    addIfValid(queue, visited, dead, next2);
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    private void addIfValid(Queue<String> queue, Set<String> visited, 
                           Set<String> dead, String next) {
        if (!visited.contains(next) && !dead.contains(next)) {
            visited.add(next);
            queue.offer(next);
        }
    }
}
```

**Key State Tracking Concepts:**
- **State representation** (strings, coordinates, custom objects)
- **State generation** (all possible next states)
- **State validation** (avoiding deadends, boundaries)
- **Complex visited tracking** (may need custom equals/hashCode)

---

## 🎯 **MULTI-SOURCE BFS TEMPLATE**

```java
// TEMPLATE: Multi-Source BFS
public int multiSourceBFS(/* grid/graph */, /* sources */) {
    Queue</* PositionType */> queue = new LinkedList<>();
    /* VisitedType */ visited = new /* VisitedStructure */;
    
    // Add all source nodes
    for (/* source */ : /* sources */) {
        queue.offer(/* source */);
        visited./* markVisited */(/* source */);
    }
    
    int steps = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        
        for (int i = 0; i < size; i++) {
            /* current */ = queue.poll();
            
            for (/* neighbor */ : /* getNeighbors */) {
                if (/* isValid */ && !/* isVisited */) {
                    /* markVisited */;
                    queue.offer(/* neighbor */);
                }
            }
        }
        steps++;
    }
    
    return steps;
}
```

---

## 📚 **COMMON MULTI-SOURCE PROBLEMS:**
- **01 Matrix** - Distance to nearest 0
- **Walls and Gates** - Distance to nearest gate
- **As Far from Land as Possible** - Max distance from land
- **Shortest Bridge** - Connect two islands
- **Minimum Knight Moves** - Multiple starting positions