# ⚡ DIJKSTRA PATTERN RECOGNITION CHART

## 🎯 **5-SECOND DECISION TREE**

```
Is it weighted graph problem? 
    ↓ YES
Does it ask for shortest/minimum/cheapest PATH?
    ↓ YES
Are all weights positive?
    ↓ YES
    🎯 USE DIJKSTRA! → Which pattern?
```

---

## 📊 **PATTERN IDENTIFICATION CHART**

| **PATTERN** | **TRIGGERS** | **EXAMPLES** | **TEMPLATE CHANGES** |
|-------------|--------------|--------------|---------------------|
| **🟢 BASIC** | • Single source<br>• "Shortest distance"<br>• "Network delay" | • LeetCode 743<br>• Find shortest paths<br>• Single source all destinations | Standard Dijkstra |
| **🟡 MODIFIED** | • **"At most K"**<br>• **"With constraint"**<br>• **"Limited moves/stops"** | • LeetCode 787<br>• K stops flights<br>• Limited moves | Track extra state<br>(cost + constraint) |
| **🔴 VARIANT** | • **"Maximum"** something<br>• **"Minimize the maximum"**<br>• Different objective | • LeetCode 1514<br>• Max probability<br>• Min effort path | Change heap direction<br>or comparison logic |
| **🟣 MULTI-SOURCE** | • **"Multiple sources"**<br>• **"Nearest facility"**<br>• **"Distance to any"** | • LeetCode 1334<br>• Multiple hospitals<br>• Nearest exit | Initialize all sources<br>with distance 0 |

---

## 🚨 **RED FLAGS - NOT DIJKSTRA**

| **PROBLEM TYPE** | **KEYWORDS** | **REAL ALGORITHM** | **EXAMPLES** |
|------------------|--------------|-------------------|--------------|
| **MST** | "Connect **all**"<br>"Minimum **total** cost"<br>"Spanning tree" | Kruskal/Prim | Connect cities<br>Minimum cable cost |
| **Connectivity** | "**Count** components"<br>"**Reachable**"<br>"Connected" | DFS/BFS/Union Find | Islands problem<br>Component counting |
| **Negative Weights** | "**Negative** edges"<br>"Can have negative" | Bellman Ford | Currency exchange<br>Negative cycles |
| **All-Pairs** | "**All pairs** shortest"<br>"**Every** node to **every** node" | Floyd Warshall | Distance matrix<br>Transitive closure |
| **Unweighted** | "**No weights** mentioned"<br>"**Equal cost** edges" | BFS | Unweighted shortest<br>Level-order traversal |

---

## ⚡ **LIGHTNING RECOGNITION RULES**

### **✅ DIJKSTRA IF:**
```
✅ Weighted graph (positive weights)
✅ "Shortest/Minimum/Cheapest" PATH
✅ Single or multiple sources
✅ Need actual distances/costs
```

### **❌ NOT DIJKSTRA IF:**
```
❌ No weights OR negative weights
❌ "Connect all" (MST problem)
❌ "Count/Find components" (Graph traversal)
❌ "All pairs" (Floyd Warshall)
❌ Just "reachability" (DFS/BFS)
```

---

## 🎯 **PATTERN DECISION FLOWCHART**

```
DIJKSTRA CONFIRMED ✅
    ↓
How many sources?
    ├── Multiple → 🟣 MULTI-SOURCE
    └── Single → Continue
        ↓
    Any constraints? (K stops, moves, etc.)
        ├── YES → 🟡 MODIFIED
        └── NO → Continue
            ↓
        What's the objective?
            ├── Maximize OR Minimize-Maximum → 🔴 VARIANT
            └── Standard shortest path → 🟢 BASIC
```

---

## 📋 **QUICK CHECKLIST**

**Before coding, ask:**
- [ ] Is this actually a Dijkstra problem?
- [ ] Which of the 4 patterns does it fit?
- [ ] What template modifications do I need?
- [ ] Am I falling for any red flag keywords?

---

## 🏆 **MASTERY INDICATORS**

**✅ You've mastered Dijkstra when:**
- Pattern identification in < 10 seconds
- 90%+ accuracy on mixed problems
- Can spot "NOT Dijkstra" tricks
- Know exact template changes needed

---

## 💡 **INTERVIEW TIP**

**Say this out loud:**
*"This looks like a shortest path problem with positive weights, so I'll use Dijkstra. It seems like [PATTERN] because [REASON]. Let me implement using [TEMPLATE MODIFICATION]."*

**Interviewer = Impressed!** 🎯