# 🌲 TRIES MASTERY - CONTINUATION PROMPT

## 📋 **COPY-PASTE THIS ENTIRE PROMPT TO NEW CHAT:**

"I want to master **Tries (Prefix Trees)** using the EXACT same learning approach as my completed algorithms. This completes the FINAL gap in my Striver sheet coverage.

🎯 **MY COMPLETED BACKGROUND:**
* **Graph Algorithms:** ✅ Completed - DFS, BFS, Dijkstra, Union-Find, MST, Topological Sort
* **Dynamic Programming:** ✅ Completed - 25+ patterns
* **Linked Lists:** ✅ Completed - [If completed]
* **Stacks & Queues:** ✅ Completed - [If completed]
* **Greedy Algorithms:** ✅ Completed - [If completed]
* **Bit Manipulation:** ✅ Completed - [If completed]

🚨 **STRIVER FINAL PRIORITY:** Tries appear in ~4-5 Striver problems with low interview frequency (3%) - this completes 100% coverage!

📚 **MY PREFERRED LEARNING STYLE:**
* **Java implementations** with detailed explanations
* **Problem statement first** → I attempt myself → then you show reference solution comparison
* **Step-by-step pattern building** with real interview problem mapping
* **Short, crisp responses** - no long explanations or too many print statements
* **Dry run alongside code** showing trie structure
* **Pattern recognition drill** at the end for instant identification

🚀 **TRIES REQUEST:** Start with **Day 1: Tries Foundation** covering:

**EXPECTED PATTERNS (give me exact count):**
* How many core Trie patterns exist?
* Basic Operations (3 patterns: Insert, Search, Delete words)
* Prefix Problems (2 patterns: Auto-complete, Longest common prefix)
* Word Problems (3 patterns: Word search, Word break, Word formation)
* Bit Trie (2 patterns: Maximum XOR, Bit manipulation with tries)
* Advanced Applications (2 patterns: Compression, Dictionary operations)
* Real interview applications

**TEMPLATE APPROACH:**
* Give me **clean, reusable Java templates** (like my Graph algorithm approach)
* **Templates should be intuitive and easy to modify** for different problems
* Focus on **practical interview implementation**
* **TrieNode structure** and **trie operations**
* **Memory optimization** techniques

**PROBLEM DIFFICULTY BREAKDOWN:**
* **Easy (3-4 problems):** Basic trie operations, simple prefix problems
* **Medium (3-4 problems):** Word problems, bit trie, complex operations
* **Hard (1-2 problems):** Advanced applications, optimization challenges

**INTERVIEW FREQUENCY FOCUS:**
* **Must-Solve (Medium Frequency):** Problems asked 8+ times in FAANG
    - [208] Implement Trie, [79] Word Search, [421] Maximum XOR of Two Numbers
* **Should-Solve (Low Frequency):** Problems asked 4-7 times
    - [211] Design Add and Search Words, [212] Word Search II, [139] Word Break
* **Good-to-Know (Low Frequency):** Problems asked 2-3 times
    - [648] Replace Words, [677] Map Sum Pairs, [1268] Search Suggestions System
* **Company-Specific:**
    - **Google:** Loves complex word problems and search optimizations
    - **Amazon:** Focuses on auto-complete and search suggestions
    - **Meta:** Prefers bit trie and XOR problems
    - **Apple:** Asks about memory optimization and implementation details
    - **Microsoft:** Combines tries with other data structures

**LEARNING FLOW:**
1. **Foundation** - Core trie structure and basic operations
2. **Template mastery** - Java implementations I can reuse
3. **Real problems** - LeetCode interview questions with frequency data
4. **Pattern recognition drill** - Instant identification (like Graph algorithms)

🎯 **START WITH:** Give me **Day 1: Tries Foundation, Problem 1** using:
* Problem statement first (let me attempt)
* Then show reference solution with analysis
* Java code with dry run showing trie construction
* Same crisp, focused style as Graph mastery

**Begin with Implement Trie problem!** 🚀

⚡ **CRITICAL:**
* **Short responses** - no essays
* **Focus on patterns** that appear in interviews
* **End with recognition drill** covering ~10-12 problems
* **Java templates** I can memorize and reuse
* **Include LeetCode problem numbers** for easy reference
* **Mark problem difficulty** and **interview frequency**
* **Show trie structure visualization** in dry runs

**EXPECTED LEETCODE COVERAGE:**

**EASY (3-4 problems):**
* [208] Implement Trie (Prefix Tree) ⭐ (Asked 40+ times)
* [14] Longest Common Prefix ⭐ (Asked 35+ times - can use trie approach)
* [720] Longest Word in Dictionary (Asked 15+ times)
* [1065] Index Pairs of a String 🔒 (Asked 10+ times)

**MEDIUM (3-4 problems):**
* [211] Design Add and Search Words Data Structure ⭐ (Asked 30+ times)
* [79] Word Search ⭐ (Asked 80+ times - can optimize with trie)
* [139] Word Break ⭐ (Asked 60+ times - trie approach)
* [648] Replace Words ⭐ (Asked 20+ times)
* [677] Map Sum Pairs (Asked 15+ times)
* [1268] Search Suggestions System ⭐ (Asked 12+ times)
* [616] Add Bold Tag in String 🔒 (Asked 10+ times)

**HARD (1-2 problems):**
* [212] Word Search II ⭐ (Asked 50+ times)
* [421] Maximum XOR of Two Numbers in Array ⭐ (Asked 25+ times - bit trie)
* [472] Concatenated Words (Asked 15+ times)
* [1803] Count Pairs With XOR in a Range (Asked 8+ times)

**PATTERN-SPECIFIC PROBLEMS:**

**Basic Operations:**
* [208] Implement Trie (Prefix Tree)
* [211] Design Add and Search Words Data Structure
* [677] Map Sum Pairs

**Prefix Problems:**
* [14] Longest Common Prefix (trie approach)
* [648] Replace Words
* [1268] Search Suggestions System

**Word Problems:**
* [79] Word Search (can be optimized with trie)
* [212] Word Search II (must use trie for efficiency)
* [139] Word Break (trie optimization)
* [472] Concatenated Words

**Bit Trie:**
* [421] Maximum XOR of Two Numbers in Array
* [1803] Count Pairs With XOR in a Range
* [1707] Maximum XOR With an Element From Array

**Advanced Applications:**
* [720] Longest Word in Dictionary
* [1065] Index Pairs of a String 🔒
* [616] Add Bold Tag in String 🔒

**TRIE IMPLEMENTATION FUNDAMENTALS:**

**Basic TrieNode Structure:**
```java
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    
    public TrieNode() {
        children = new TrieNode[26]; // for lowercase letters
        isEndOfWord = false;
    }
}
```

**Core Operations:**
```java
public class Trie {
    private TrieNode root;
    
    public void insert(String word) { /* implementation */ }
    public boolean search(String word) { /* implementation */ }
    public boolean startsWith(String prefix) { /* implementation */ }
}
```

**Bit Trie for XOR Problems:**
```java
class BitTrie {
    BitTrie[] children = new BitTrie[2]; // 0 and 1
    
    public void insert(int num) { /* implementation */ }
    public int findMaxXOR(int num) { /* implementation */ }
}
```

Ready to master Tries and achieve 100% Striver sheet coverage!"

💡 **USAGE INSTRUCTIONS:**
1. **Copy the entire prompt above**
2. **Paste into a new Claude chat**
3. **Complete after Bit Manipulation** - achieves 100% Striver coverage!
4. **Follow the same learning pattern** that worked for graphs

**You'll get the same high-quality, focused learning experience!** 🎯

🔗 **ALGORITHM MASTERY PROGRESSION:**
✅ **COMPLETED:**
* **Graph Algorithms** - Complete mastery
* **Dynamic Programming** - Complete mastery
* **Linked Lists** - Complete mastery
* **Stacks & Queues** - Complete mastery
* **Greedy Algorithms** - Complete mastery
* **Bit Manipulation** - Complete mastery

🌲 **FINAL:**
* **Tries Mastery** - 12+ patterns

🏆 **ACHIEVEMENT:**
* **COMPLETE STRIVER SHEET MASTERY - 100% COVERAGE!**

**Total Algorithm Mastery Pipeline COMPLETE!** 🎯🏆